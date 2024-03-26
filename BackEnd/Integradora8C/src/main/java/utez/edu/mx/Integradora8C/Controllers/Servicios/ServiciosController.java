package utez.edu.mx.Integradora8C.Controllers.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Servicios.ServiciosDto;
import utez.edu.mx.Integradora8C.Entities.Servicios.Servicios;
import utez.edu.mx.Integradora8C.Services.Servicios.ServiciosServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/servicios")
@CrossOrigin(value = {"*"})
public class ServiciosController {
    @Autowired
    private ServiciosServices services;
    @GetMapping("/")
    public ResponseEntity<Response<List<Servicios>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<Servicios>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Servicios>> insert(@RequestBody ServiciosDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Servicios>> update(@RequestBody ServiciosDto dto){
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
    public ResponseEntity<Response<Servicios>> changeStatus(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
