package utez.edu.mx.foodster.services.serviciospaquete;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.serviciospaquete.ServiciosPaquete;
import utez.edu.mx.foodster.entities.serviciospaquete.ServiciosPaqueteRepository;
import utez.edu.mx.foodster.utils.Response;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;


@Service
public class ServiciosPaqueteServices {
    private final ServiciosPaqueteRepository repository;

    public ServiciosPaqueteServices(ServiciosPaqueteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<ServiciosPaquete>> getAll() {
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<ServiciosPaquete> getById(String id) {
        return new Response<>(
                this.repository.findByIdServicioPaqueteAndActive(id, true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<List<ServiciosPaquete>> getAllByIdPaquete(String idPaquete) {
        return new Response<>(
                this.repository.findByIdPaqueteAndActive(idPaquete, true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<List<ServiciosPaquete>> getAllByStatus(Boolean status) {
        return new Response<>(
                this.repository.findAllByActiveOrderByUltimaModificacionDesc(status),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<ServiciosPaquete> insert(ServiciosPaquete serviciosPaquete) {
        return new Response<>(
                this.repository.save(serviciosPaquete),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLDataException.class})
    public Response<ServiciosPaquete> update(ServiciosPaquete serviciosPaquete) {
        Optional<ServiciosPaquete> update = this.repository.findById(serviciosPaquete.getIdServicioPaquete());
        if (update.isPresent()) {
            return new Response<>(
                    this.repository.saveAndFlush(serviciosPaquete),
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
        Optional<ServiciosPaquete> entity = this.repository.findById(id);
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
    public Response<ServiciosPaquete> changeStatus(String id) {
        Optional<ServiciosPaquete> entity = this.repository.findById(id);
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
                "No encontrado para cambiar estatus"
        );
    }
}
