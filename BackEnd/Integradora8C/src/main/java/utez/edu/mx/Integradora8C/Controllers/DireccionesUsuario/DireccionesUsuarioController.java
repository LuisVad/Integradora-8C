package utez.edu.mx.Integradora8C.Controllers.DireccionesUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.DireccionesUsuarios.DireccionesUsuariosDto;
import utez.edu.mx.Integradora8C.Entities.DireccionesUsuario.DireccionesUsuario;
import utez.edu.mx.Integradora8C.Services.DireccionesUsuario.DireccionesUsuarioServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/direcciones-usuario")
@CrossOrigin(value = {"*"})
public class DireccionesUsuarioController {
    @Autowired
    private DireccionesUsuarioServices services;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(String id){
        return new ResponseEntity<>(
                this.services.delete(id),
                HttpStatus.OK
        );
    }
}
