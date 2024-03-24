package utez.edu.mx.Integradora8C.Controllers.Paquetes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Paquetes.PaquetesDto;
import utez.edu.mx.Integradora8C.Entities.Paquetes.Paquetes;
import utez.edu.mx.Integradora8C.Services.Paquetes.PaquetesServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/paquetes")
@CrossOrigin(value = {"*"})
public class PaquetesController {
    @Autowired
    private PaquetesServices services;

    @GetMapping("/")
    public ResponseEntity<Response<List<Paquetes>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<Paquetes>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Paquetes>> insert(@RequestBody PaquetesDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<Paquetes>> update(@RequestBody PaquetesDto dto){
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
    public ResponseEntity<Response<Paquetes>> changeStatus(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }

}
