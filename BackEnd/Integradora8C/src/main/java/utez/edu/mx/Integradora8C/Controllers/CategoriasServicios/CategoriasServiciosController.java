package utez.edu.mx.Integradora8C.Controllers.CategoriasServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.CategoriasServicios.CategoriasServiciosDto;
import utez.edu.mx.Integradora8C.Entities.CategoriasServicios.CategoriasServicios;
import utez.edu.mx.Integradora8C.Services.CategoriasServicios.CategoriasServiciosServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/categorias-servicios")
@CrossOrigin(value = {"*"})
public class CategoriasServiciosController {
    @Autowired
    private CategoriasServiciosServices services;
    @GetMapping("/")
    public ResponseEntity<Response<List<CategoriasServicios>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<CategoriasServicios>>> getAllByStatus(@PathVariable("status") Boolean status){
        return new ResponseEntity<>(
                this.services.getAllByStatus(status),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<CategoriasServicios>> insert(@RequestBody CategoriasServiciosDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<CategoriasServicios>> update(@RequestBody CategoriasServiciosDto dto){
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
    public ResponseEntity<Response<Boolean>> changeStatus(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.changeStatus(id),
                HttpStatus.OK
        );
    }
}
