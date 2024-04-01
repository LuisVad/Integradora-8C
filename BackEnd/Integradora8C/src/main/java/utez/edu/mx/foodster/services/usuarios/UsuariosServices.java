package utez.edu.mx.foodster.services.usuarios;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.dtos.usuarios.UsuariosPublicDto;
import utez.edu.mx.foodster.entities.roles.Roles;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.entities.usuarios.UsuariosRepository;
import utez.edu.mx.foodster.services.captcha.CaptchaService;
import utez.edu.mx.foodster.services.roles.RolesServices;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuariosServices {
    private final UsuariosRepository repository;

    private final RolesServices rolesServices;


    private final PasswordEncoder passwordEncoder;

    private final CaptchaService captchaService;

    public UsuariosServices(UsuariosRepository repository, RolesServices rolesServices, PasswordEncoder passwordEncoder, CaptchaService captchaService) {
        this.repository = repository;
        this.rolesServices = rolesServices;
        this.passwordEncoder = passwordEncoder;
        this.captchaService = captchaService;
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
        return new Response<>(this.repository.save(usuarios), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> publicInsert(UsuariosPublicDto usuarios) {
        Boolean captchaVerification = this.captchaService.verificarCaptchaBoolean(usuarios.getSolucion());
        if (captchaVerification == null || !captchaVerification) {
            return new Response<>(null, true, 400, "Captcha invalido");
        }
        Usuarios usuario = usuarios.toEntity();
        Set<Roles> roles = usuario.getRoles();
        roles.add(this.rolesServices.getByNombreAndActive("USUARIO", true));
        usuario.setRoles(roles);
        usuario.setActive(true);
        usuario.setContrasena(this.passwordEncoder.encode(usuario.getContrasena()));
        return new Response<>(this.repository.save(usuario), false, 200, "OK");
    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuarios> update(Usuarios usuarios) {
        Optional<Usuarios> entityUpdate = this.repository.findById(usuarios.getIdUsuario());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(usuarios), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado para actualizar");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Usuarios> usuarios = this.repository.findById(id);
        if (usuarios.isPresent()) {
            this.repository.delete(usuarios.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado para eliminar");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> changeStatus(String id) {
        Optional<Usuarios> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            entity.get().setActive(!entity.get().getActive());
            return new Response<>(true, false, 200, "Estatus cambiado!");
        }
        return new Response<>(null, true, 400, "No encontrado para cambiar estatus");
    }

    public long count() {
        return this.repository.count();
    }


}
