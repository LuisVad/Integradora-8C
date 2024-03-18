package utez.edu.mx.Integradora8C.Services.PersonalEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.PersonalEvento.PersonalEvento;
import utez.edu.mx.Integradora8C.Entities.PersonalEvento.PersonalEventoRepository;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonalEventoServices {
    private final PersonalEventoRepository repository;

    @Autowired
    public PersonalEventoServices(PersonalEventoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<PersonalEvento>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<PersonalEvento> insert(PersonalEvento PersonalEvento) {
        return new Response<>(this.repository.save(PersonalEvento), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<PersonalEvento> update(PersonalEvento PersonalEvento) {
        Optional<PersonalEvento> entityUpdate = this.repository.findById(PersonalEvento.getIdPersonalEvento());
        if (entityUpdate.isPresent()) {
            return new Response<>(this.repository.saveAndFlush(PersonalEvento), false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(String id) {
        Optional<PersonalEvento> PersonalEvento = this.repository.findById(id);
        if (PersonalEvento.isPresent()) {
            this.repository.delete(PersonalEvento.get());
            return new Response<>(true, false, 200, "Eliminado correctamente");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }
}
