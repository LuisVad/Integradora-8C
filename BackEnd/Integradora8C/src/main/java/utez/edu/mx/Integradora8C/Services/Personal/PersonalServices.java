package utez.edu.mx.Integradora8C.Services.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Personal.Personal;
import utez.edu.mx.Integradora8C.Entities.Personal.PersonalRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalServices {
    private final PersonalRepository repository;

    @Autowired
    public PersonalServices(PersonalRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<Personal>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Personal> insert(Personal Personal) {
        return new Response<>(this.repository.save(Personal), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Personal> update(Personal Personal) {
        Optional<Personal> entityUpdate = this.repository.findById(Personal.getIdPersonal());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(Personal), false, 200, "OK");
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
