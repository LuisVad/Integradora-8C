package utez.edu.mx.Integradora8C.Controllers.Roles;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Roles.RolesDto;
import utez.edu.mx.Integradora8C.Entities.Roles.Roles;
import utez.edu.mx.Integradora8C.Services.Roles.RolesServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/roles")
@CrossOrigin(value = {"*"})
public class RolesController {
    private final RolesServices services;

    @Autowired
    public RolesController(RolesServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Roles>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Roles>> insert(@RequestBody @Valid RolesDto RolesDto) {
        return new ResponseEntity<>(this.services.insert(RolesDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Roles>> update(@RequestBody @Valid RolesDto RolesDto) {
        return new ResponseEntity<>(this.services.update(RolesDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}
