package utez.edu.mx.foodster.services.serviciosevento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.serviciosevento.ServiciosEvento;
import utez.edu.mx.foodster.entities.serviciosevento.ServiciosEventoRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiciosEventoServices {
    private final ServiciosEventoRepository repository;

    public ServiciosEventoServices(ServiciosEventoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<ServiciosEvento>> getAll() {
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)

    public Response<ServiciosEvento> getById(String id) {
        return new Response<>(
                this.repository.findByIdServicioEventoAndActive(id, true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<List<ServiciosEvento>> getAllByIdEvento(String idEvento) {
        return new Response<>(
                this.repository.findAllByEventoAndActiveOrderByUltimaModificacionDesc(idEvento, true),
                false,
                200,
                "OK"
        );
    }


    @Transactional(readOnly = true)
    public Response<List<ServiciosEvento>> getAllByStatus(Boolean status) {
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<ServiciosEvento> insert(ServiciosEvento serviciosEvento) {
        return new Response<>(
                this.repository.save(serviciosEvento),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<ServiciosEvento> update(ServiciosEvento serviciosEvento) {
        Optional<ServiciosEvento> update = this.repository.findById(serviciosEvento.getIdServicioEvento());
        if (update.isPresent()) {
            return new Response<>(
                    this.repository.saveAndFlush(serviciosEvento),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado para actualizar"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<Boolean> delete(String id) {
        Optional<ServiciosEvento> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            this.repository.delete(entity.get());
            return new Response<>(
                    true,
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado para eliminar"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<ServiciosEvento> changeStatus(String id) {
        Optional<ServiciosEvento> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            entity.get().setActive(!entity.get().isActive());
            return new Response<>(
                    this.repository.saveAndFlush(entity.get()),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "No encontrado para cambiar estado"
        );
    }
}
