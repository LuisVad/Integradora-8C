package utez.edu.mx.foodster.services.personal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.personal.Personal;
import utez.edu.mx.foodster.entities.personal.PersonalRepository;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.entities.usuarios.UsuariosRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalServices {
    private final PasswordEncoder passwordEncoder;
    private final PersonalRepository repository;
    private final UsuariosRepository usuariosRepository;


    public PersonalServices(PersonalRepository repository, UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Response<List<Personal>> getAllByStatus(Boolean status) {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(status), false, 200, "OK");
    }
    @Transactional(readOnly = true)
    public Response<List<Personal>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Personal> insert(Personal personal) {
        Optional<Usuarios> exist = this.usuariosRepository.findByCorreo(personal.getUsuarios().getCorreo());
        if(exist.isPresent()){
            return new Response<>(
                    null,
                    true,
                    400,
                    "Correo ya registrado"
            );
        }
        personal.getUsuarios().setUltimaModificacion(new Timestamp(System.currentTimeMillis()));
        personal.getUsuarios().setContrasena(this.passwordEncoder.encode(personal.getUsuarios().getContrasena()));
        Usuarios usuarios = this.usuariosRepository.save(personal.getUsuarios());
        personal.setUsuarios(usuarios);
        return new Response<>(this.repository.save(personal), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Personal> update(Personal personal) {
        Optional<Personal> entityUpdate = this.repository.findById(personal.getIdPersonal());
        if (entityUpdate.isPresent()) {
            Usuarios usuarios = this.usuariosRepository.save(personal.getUsuarios());
            personal.setUsuarios(usuarios);
            return new Response<>(this.repository.saveAndFlush(personal), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado para actualizar");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Personal> personal = this.repository.findById(id);
        if (personal.isPresent()) {
            this.repository.delete(personal.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado para eliminar");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> changeStatus(String id) {
        Optional<Personal> personal = this.repository.findById(id);
        if (personal.isPresent()) {
            personal.get().setActive(!personal.get().getActive());
            this.repository.saveAndFlush(personal.get());
            return new Response<>(true, false, 200, "Estatus cambiado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado para cambiar estatus");
    }
}
