package utez.edu.mx.Integradora8C.Services.Eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Eventos.Eventos;
import utez.edu.mx.Integradora8C.Entities.Eventos.EventosRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class EventosServices {
    @Autowired
    private EventosRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Eventos>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<Eventos>> getAllByStatus(Boolean status){
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Eventos> insert(Eventos eventos){
        return new Response<>(
                this.repository.save(eventos),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Eventos> update(Eventos eventos){
        Optional<Eventos> update = this.repository.findById(eventos.getIdEvento());
        if(update.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(update.get()),
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
        Optional<Eventos> entity = this.repository.findById(id);
        if (entity.isPresent()){
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
}
