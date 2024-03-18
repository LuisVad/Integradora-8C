package utez.edu.mx.Integradora8C.Services.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Roles.Roles;
import utez.edu.mx.Integradora8C.Entities.Roles.RolesRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolesServices {
    private final RolesRepository repository;

    @Autowired
    public RolesServices(RolesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<Roles>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Roles> insert(Roles Roles) {
        return new Response<>(this.repository.save(Roles), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Roles> update(Roles Roles) {
        Optional<Roles> entityUpdate = this.repository.findById(Roles.getIdRol());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(Roles), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Roles> Roles = this.repository.findById(id);
        if (Roles.isPresent()) {
            this.repository.delete(Roles.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
