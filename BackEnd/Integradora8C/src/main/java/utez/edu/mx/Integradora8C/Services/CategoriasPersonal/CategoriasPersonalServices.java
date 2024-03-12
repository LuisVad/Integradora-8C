package utez.edu.mx.Integradora8C.Services.CategoriasPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonalRepository;
import utez.edu.mx.Integradora8C.utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriasPersonalServices {
    @Autowired
    private CategoriasPersonalRepository repository;

    @Transactional(readOnly = true)
    public Response<List<CategoriasPersonal>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<CategoriasPersonal> insert(CategoriasPersonal categoriasPersonal){
        return new Response<>(
                this.repository.save(categoriasPersonal),
                false,
                200,
                "OK"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<CategoriasPersonal> update(CategoriasPersonal categoriasPersonal){
        Optional<CategoriasPersonal> categoriasUpdate = this.repository.findById(categoriasPersonal.getIdCategoria());
        if(categoriasUpdate.isPresent()){
           return new Response<>(
                   this.repository.saveAndFlush(categoriasPersonal),
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
        Optional<CategoriasPersonal> categoriasPersonal = this.repository.findById(id);
        if(categoriasPersonal.isPresent()){
            this.repository.delete(categoriasPersonal.get());
            return new Response<>(
                    true,
                    false,
                    200,
                    "Eliminado correctamente"
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
