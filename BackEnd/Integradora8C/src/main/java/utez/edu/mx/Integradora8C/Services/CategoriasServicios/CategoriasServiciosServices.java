package utez.edu.mx.Integradora8C.Services.CategoriasServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServicios;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServiciosRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServiciosServices {
    @Autowired
    private CategoriasServiciosRepository repository;
    @Transactional(readOnly = true)
    public Response<List<CategoriasServicios>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<CategoriasServicios>> getAllByStatus(Boolean status){
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<CategoriasServicios> insert(CategoriasServicios categoriasServicios){
        return new Response<>(
                this.repository.save(categoriasServicios),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<CategoriasServicios> update(CategoriasServicios categoriasServicios){
        Optional<CategoriasServicios> update = this.repository.findById(categoriasServicios.getIdCategoria());
        if(update.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(categoriasServicios),
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
        Optional<CategoriasServicios> entity = this.repository.findById(id);
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
    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Boolean> changeStatus(String id){
        Optional<CategoriasServicios> entity = this.repository.findById(id);
        if (entity.isPresent()){
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
