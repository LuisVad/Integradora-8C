package utez.edu.mx.foodster.controllers.eventos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.eventos.EventosDto;
import utez.edu.mx.foodster.entities.eventos.Eventos;
import utez.edu.mx.foodster.services.eventos.EventosServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/eventos")
@CrossOrigin(value = {"*"})
public class EventosController {
    private final EventosServices services;

    public EventosController(EventosServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Eventos>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<Eventos>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Eventos>> insert(@RequestBody EventosDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Eventos>> update(@RequestBody EventosDto dto){
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
}
