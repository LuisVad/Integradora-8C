package utez.edu.mx.foodster.services.personalevento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Response<Page<PersonalEvento>> getAll(Pageable pageable) {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true, pageable), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public Response<PersonalEvento> getById(String id) {
        return new Response<>(this.repository.findByIdPersonalEventoAndActive(id, true), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public Response<List<PersonalEvento>> getAllByIdEvento(String idEvento) {
        return new Response<>(this.repository.findByIdEventoAndActive(idEvento, true), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public Response<List<PersonalEvento>> getAllByStatus(Boolean status) {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(status), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public Response<Page<PersonalEvento>> getAllByStatus(Boolean status, Pageable pageable) {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(status, pageable), false, 200, "OK");
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
            personalEvento.get().setActive(!personalEvento.get().getActive());
            return new Response<>(this.repository.saveAndFlush(personalEvento.get()).getActive(), false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
