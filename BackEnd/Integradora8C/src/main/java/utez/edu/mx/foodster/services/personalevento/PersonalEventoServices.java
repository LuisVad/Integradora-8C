package utez.edu.mx.foodster.services.personalevento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.personalevento.PersonalEvento;
import utez.edu.mx.foodster.entities.personalevento.PersonalEventoRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalEventoServices {
    private final PersonalEventoRepository repository;

    public PersonalEventoServices(PersonalEventoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<PersonalEvento>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<PersonalEvento> insert(PersonalEvento personalEvento) {
        return new Response<>(this.repository.save(personalEvento), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<PersonalEvento> update(PersonalEvento personalEvento) {
        Optional<PersonalEvento> entityUpdate = this.repository.findById(personalEvento.getIdPersonalEvento());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(personalEvento), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<PersonalEvento> personalEvento = this.repository.findById(id);
        if (personalEvento.isPresent()) {
            this.repository.delete(personalEvento.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
