package utez.edu.mx.Integradora8C.Services.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Direcciones.Direcciones;
import utez.edu.mx.Integradora8C.Entities.Direcciones.DireccionesRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionesServices {
    @Autowired
    private DireccionesRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Direcciones>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<Direcciones>> getAllByStatus(Boolean status){
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Direcciones> insert(Direcciones direcciones){
        return new Response<>(
                this.repository.save(direcciones),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Direcciones> update(Direcciones direcciones){
        Optional<Direcciones> entity = this.repository.findById(direcciones.getIdDireccion());
        if (entity.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(direcciones),
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
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id){
        Optional<Direcciones> entity = this.repository.findById(id);
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
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> changeStatus(String id){
        Optional<Direcciones> entity = this.repository.findById(id);
        if(entity.isPresent()){
            entity.get().setActive(!entity.get().getActive());
            this.repository.saveAndFlush(entity.get());
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
}
