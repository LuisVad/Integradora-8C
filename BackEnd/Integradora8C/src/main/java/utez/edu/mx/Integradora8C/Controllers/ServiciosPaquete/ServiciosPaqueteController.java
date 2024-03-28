package utez.edu.mx.Integradora8C.Controllers.ServiciosPaquete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.ServiciosPaquete.ServiciosPaqueteDto;
import utez.edu.mx.Integradora8C.Entities.ServiciosPaquete.ServiciosPaquete;
import utez.edu.mx.Integradora8C.Services.ServiciosPaquete.ServiciosPaqueteServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/servicios-paquete")
@CrossOrigin(value = {"*"})
public class ServiciosPaqueteController {
    @Autowired
    private ServiciosPaqueteServices services;
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
