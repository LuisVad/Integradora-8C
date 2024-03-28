package utez.edu.mx.foodster.controllers.direccionesusuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.direccionesusuarios.DireccionesUsuariosDto;
import utez.edu.mx.foodster.entities.direccionesusuario.DireccionesUsuario;
import utez.edu.mx.foodster.services.direccionesusuario.DireccionesUsuarioServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/direcciones-usuario")
@CrossOrigin(value = {"*"})
public class DireccionesUsuarioController {
    private final DireccionesUsuarioServices services;

    public DireccionesUsuarioController(DireccionesUsuarioServices services) {
        this.services = services;
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Response<List<DireccionesUsuario>>> getAllByUsuario(@PathVariable("id") String id){
        return new ResponseEntity<>(
                this.services.getAllByUsuarios(id),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<DireccionesUsuario>> insert(@RequestBody DireccionesUsuariosDto dto){
        return new ResponseEntity<>(
                this.services.insert(dto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<DireccionesUsuario>> update(@RequestBody DireccionesUsuariosDto dto){
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
