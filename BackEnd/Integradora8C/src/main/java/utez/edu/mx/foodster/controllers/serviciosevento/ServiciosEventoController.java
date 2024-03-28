package utez.edu.mx.foodster.controllers.serviciosevento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.serviciosevento.ServiciosEventoDto;
import utez.edu.mx.foodster.entities.serviciosevento.ServiciosEvento;
import utez.edu.mx.foodster.services.serviciosevento.ServiciosEventoServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/servicios-evento")
@CrossOrigin(value = {"*"})
public class ServiciosEventoController {
    private final ServiciosEventoServices services;

    public ServiciosEventoController(ServiciosEventoServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<ServiciosEvento>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<ServiciosEvento>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<ServiciosEvento>> insert(@RequestBody ServiciosEventoDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<ServiciosEvento>> update(@RequestBody ServiciosEventoDto dto){
        return new ResponseEntity<>(
                this.services.update(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String id){
        return new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/status/{uid}")
    public ResponseEntity<Response<ServiciosEvento>> changeStatus(@PathVariable("uid") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
