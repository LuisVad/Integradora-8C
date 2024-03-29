package utez.edu.mx.foodster.controllers.calificaciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.foodster.entities.calificaciones.Calificaciones;
import utez.edu.mx.foodster.services.calificaciones.CalificacionesService;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/calificaciones")
@CrossOrigin(value = {"*"})
public class CalificacionesController {

    private final CalificacionesService services;

    public CalificacionesController(CalificacionesService services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Calificaciones>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }


}
