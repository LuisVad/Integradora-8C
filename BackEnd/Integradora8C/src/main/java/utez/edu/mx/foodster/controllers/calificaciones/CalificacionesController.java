package utez.edu.mx.foodster.controllers.calificaciones;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.foodster.services.calificaciones.CalificacionesService;

@RestController
@RequestMapping("${apiPrefix}/calificaciones")
@CrossOrigin(value = {"*"})
public class CalificacionesController {

    private final CalificacionesService services;

    public CalificacionesController(CalificacionesService services) {
        this.services = services;
    }
}
