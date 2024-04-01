package utez.edu.mx.foodster.controllers.serviciospaquete;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.serviciospaquete.ServiciosPaqueteDto;
import utez.edu.mx.foodster.services.serviciospaquete.ServiciosPaqueteServices;
import utez.edu.mx.foodster.entities.serviciospaquete.ServiciosPaquete;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/servicios-paquete")
@CrossOrigin(value = {"*"})
public class ServiciosPaqueteController {
    private final ServiciosPaqueteServices services;

    public ServiciosPaqueteController(ServiciosPaqueteServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<ServiciosPaquete>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<ServiciosPaquete>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<ServiciosPaquete>> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/paquete/{id}")
    public ResponseEntity<Response<List<ServiciosPaquete>>> getAllByIdPaquete(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.getAllByIdPaquete(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<ServiciosPaquete>> insert(@RequestBody ServiciosPaqueteDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<ServiciosPaquete>> update(@RequestBody ServiciosPaqueteDto dto){
        return new ResponseEntity<>(
                this.services.update(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<ServiciosPaquete>> changeStatus(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
