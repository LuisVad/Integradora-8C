package utez.edu.mx.foodster.controllers.bitacoradatos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.foodster.entities.bitacoradatos.BitacoraDatos;
import utez.edu.mx.foodster.services.bitacoradatos.BitacoraDatosServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/bitacora")
@CrossOrigin(value = {"*"})
public class BitacoraDatosController {
    private final BitacoraDatosServices services;

    public BitacoraDatosController(BitacoraDatosServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<BitacoraDatos>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

}
