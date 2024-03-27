package utez.edu.mx.Integradora8C.Controllers.ServiciosEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.ServiciosEvento.ServiciosEventoDto;
import utez.edu.mx.Integradora8C.Entities.ServiciosEvento.ServiciosEvento;
import utez.edu.mx.Integradora8C.Services.ServiciosEvento.ServiciosEventoServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/servicios-evento")
@CrossOrigin(value = {"*"})
public class ServiciosEventoController {
    @Autowired
    private ServiciosEventoServices services;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<ServiciosEvento>> changeStatus(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
