package utez.edu.mx.foodster.controllers.direcciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.direcciones.DireccionesDto;
import utez.edu.mx.foodster.entities.direcciones.Direcciones;
import utez.edu.mx.foodster.services.direcciones.DireccionesServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/direcciones")
@CrossOrigin(value = {"*"})
public class DireccionesController {
    private final DireccionesServices services;

    public DireccionesController(DireccionesServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Direcciones>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Response<Direcciones>> getById(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.getById(uid), HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Response<List<Direcciones>>> getAllByUsuario(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.services.getAllByUsuario(id), HttpStatus.OK);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<Direcciones>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Direcciones>> insert(@RequestBody DireccionesDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Direcciones>> update(@RequestBody DireccionesDto dto){
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
    public ResponseEntity<Response<Boolean>> changeStatus(@PathVariable("uid") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
