package utez.edu.mx.foodster.services.personal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.personal.Personal;
import utez.edu.mx.foodster.entities.personal.PersonalRepository;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.entities.usuarios.UsuariosRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalServices {
    private final PersonalRepository repository;
    private final UsuariosRepository usuariosRepository;


    public PersonalServices(PersonalRepository repository, UsuariosRepository usuariosRepository) {
        this.repository = repository;
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional(readOnly = true)
    public Response<List<Personal>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Personal> insert(Personal personal) {
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
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<Personal> Personal = this.repository.findById(id);
        if (Personal.isPresent()) {
            this.repository.delete(Personal.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
