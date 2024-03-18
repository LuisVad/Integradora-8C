package utez.edu.mx.Integradora8C.Services.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Entities.Usuarios.UsuariosRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuariosServices {
    private final UsuariosRepository repository;

    @Autowired
    public UsuariosServices(UsuariosRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<Usuarios>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> insert(Usuarios Usuarios) {
        return new Response<>(this.repository.save(Usuarios), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> update(Usuarios Usuarios) {
        Optional<Usuarios> entityUpdate = this.repository.findById(Usuarios.getIdUsuario());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(Usuarios), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Usuarios> Usuarios = this.repository.findById(id);
        if (Usuarios.isPresent()) {
            this.repository.delete(Usuarios.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
