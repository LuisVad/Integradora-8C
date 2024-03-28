package utez.edu.mx.foodster.services.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.entities.calificaciones.Calificaciones;
import utez.edu.mx.foodster.entities.calificaciones.CalificacionesRepository;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@Service
@Transactional
public class CalificacionesService {

    private final CalificacionesRepository repository;
    @Autowired
    public CalificacionesService(CalificacionesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Response<List<Calificaciones>> getAll() {
        return new Response<>(this.repository.findAllByActiveOrderByUltimaModificacionDesc(true), false, 200, "OK");
    }

    @Transactional(rollbackFor = {Exception.class})
    public Response<Calificaciones> insert(Calificaciones calificaciones) {
        return new Response<>(this.repository.save(calificaciones), false, 200, "OK");
    }

    @Transactional(rollbackFor = {Exception.class})
    public Response<Calificaciones> update(Calificaciones calificaciones) {
        return new Response<>(this.repository.saveAndFlush(calificaciones), false, 200, "OK");
    }

    @Transactional(rollbackFor = {Exception.class})
    public Response<Boolean> delete(String id) {
        this.repository.deleteById(id);
        return new Response<>(true, false, 200, "OK");
    }

    @Transactional(rollbackFor = {Exception.class})
    public Response<Boolean> changeStatus(String id) {
        Calificaciones calificaciones = this.repository.findById(id).orElse(null);
        if (calificaciones != null) {
            calificaciones.setActive(!calificaciones.getActive());
            this.repository.save(calificaciones);
            return new Response<>(true, false, 200, "OK");
        }
        return new Response<>(null, true, 400, "No encontrado");
    }

    @Transactional(readOnly = true)
    public Response<Calificaciones> getById(String id) {
        return new Response<>(this.repository.findById(id).orElse(null), false, 200, "OK");
    }








}
