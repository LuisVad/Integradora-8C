package utez.edu.mx.foodster.services.usuarios;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.entities.usuarios.UsuariosRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuariosServices {
    private final UsuariosRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosServices(UsuariosRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Response<List<Usuarios>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public Usuarios getByCorreo(String correo) {
        return this.repository.findByCorreoAndActive(correo, true);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> insert(Usuarios usuarios) {
        usuarios.setContrasena(this.passwordEncoder.encode(usuarios.getContrasena()));
        return new Response<>(
                this.repository.save(usuarios),
                false,
                200,
                "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> update(Usuarios usuarios) {
        Optional<Usuarios> entityUpdate = this.repository.findById(usuarios.getIdUsuario());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(usuarios), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Usuarios> usuarios = this.repository.findById(id);
        if (usuarios.isPresent()) {
            this.repository.delete(usuarios.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    public long count() {
        return this.repository.count();
    }


}
