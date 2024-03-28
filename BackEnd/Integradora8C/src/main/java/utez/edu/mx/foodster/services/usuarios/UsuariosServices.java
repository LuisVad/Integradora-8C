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
    public Optional<Usuarios> getByCorreo(String correo) {
        return this.repository.findByCorreoAndActive(correo, true);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> insert(Usuarios Usuarios) {
        Usuarios.setContrasena(this.passwordEncoder.encode(Usuarios.getContrasena()));
        Usuarios resultado = this.repository.save(Usuarios);
        resultado.getRoles().forEach(rol -> this.repository.saveUserRole(Usuarios.getIdUsuario(), rol.getIdRol()));
        return new Response<>(resultado, false, 200, "OK");
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

    public long count() {
        return this.repository.count();
    }


}
