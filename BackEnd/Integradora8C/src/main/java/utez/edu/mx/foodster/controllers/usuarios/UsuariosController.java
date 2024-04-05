package utez.edu.mx.foodster.controllers.usuarios;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.usuarios.UsuariosDto;
import utez.edu.mx.foodster.dtos.usuarios.UsuariosPublicDto;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.services.usuarios.UsuariosServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/usuarios")
@CrossOrigin(value = {"*"})
public class UsuariosController {
    private final UsuariosServices services;

    public UsuariosController(UsuariosServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Usuarios>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Response<Usuarios>> getById(@PathVariable("uid") @NotBlank String uid) {
        return new ResponseEntity<>(this.services.getById(uid), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Response<Usuarios>> insert(@RequestBody @Valid UsuariosDto usuariosDto) {
        return new ResponseEntity<>(this.services.insert(usuariosDto.toEntity()), HttpStatus.OK);
    }

    @PostMapping("/public")
    public ResponseEntity<Response<Usuarios>> publicInsert(@RequestBody @Valid UsuariosPublicDto usuarios) {
        return new ResponseEntity<>(this.services.publicInsert(usuarios), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Usuarios>> update(@RequestBody @Valid UsuariosDto usuariosDto) {
        return new ResponseEntity<>(this.services.update(usuariosDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") @NotBlank String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
    @DeleteMapping("/status/{uid}")
    public ResponseEntity<Response<Boolean>> changeStatus(@PathVariable("uid") @NotBlank String uid) {
        return new ResponseEntity<>(this.services.changeStatus(uid), HttpStatus.OK);
    }
}
