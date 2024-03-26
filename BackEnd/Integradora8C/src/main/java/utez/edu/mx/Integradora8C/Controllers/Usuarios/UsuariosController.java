package utez.edu.mx.Integradora8C.Controllers.Usuarios;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Usuarios.UsuariosDto;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Services.Usuarios.UsuariosServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/usuarios")
@CrossOrigin(value = {"*"})
public class UsuariosController {
    private final UsuariosServices services;

    @Autowired
    public UsuariosController(UsuariosServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Usuarios>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Usuarios>> insert(@RequestBody @Valid UsuariosDto UsuariosDto) {
        return new ResponseEntity<>(this.services.insert(UsuariosDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Usuarios>> update(@RequestBody @Valid UsuariosDto UsuariosDto) {
        return new ResponseEntity<>(this.services.update(UsuariosDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}
