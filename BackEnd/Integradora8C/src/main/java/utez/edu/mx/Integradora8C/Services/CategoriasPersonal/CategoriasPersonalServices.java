package utez.edu.mx.Integradora8C.Services.CategoriasPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonalRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriasPersonalServices {
    private final CategoriasPersonalRepository repository;

    @Autowired
    public CategoriasPersonalServices(CategoriasPersonalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<CategoriasPersonal>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<CategoriasPersonal> insert(CategoriasPersonal categoriasPersonal) {
        return new Response<>(this.repository.save(categoriasPersonal), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<CategoriasPersonal> update(CategoriasPersonal categoriasPersonal) {
        Optional<CategoriasPersonal> entityUpdate = this.repository.findById(categoriasPersonal.getIdCategoria());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(categoriasPersonal), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<CategoriasPersonal> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            this.repository.delete(entity.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
