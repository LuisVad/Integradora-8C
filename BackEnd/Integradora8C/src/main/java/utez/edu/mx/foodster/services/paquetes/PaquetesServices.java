package utez.edu.mx.foodster.services.paquetes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.paquetes.Paquetes;
import utez.edu.mx.foodster.entities.paquetes.PaquetesRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class PaquetesServices {
    private final PaquetesRepository repository;

    public PaquetesServices(PaquetesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<Paquetes>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<Paquetes>> getAllByStatus(Boolean status){
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Paquetes> insert(Paquetes paquetes){
        return new Response<>(
                this.repository.save(paquetes),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Paquetes> update(Paquetes paquetes){
        Optional<Paquetes> entity = this.repository.findById(paquetes.getIdPaquete());
        if(entity.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(paquetes),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Boolean> delete(String id){
        Optional<Paquetes> entity = this.repository.findById(id);
        if(entity.isPresent()){
            this.repository.delete(entity.get());
            return new Response<>(
                    true,
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Paquetes> changeStatus(String id){
        Optional<Paquetes> entity = this.repository.findById(id);
        if(entity.isPresent()){
            entity.get().setActive(!entity.get().getActive());
            return new Response<>(
                    this.repository.saveAndFlush(entity.get()),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado"
        );
    }
}
