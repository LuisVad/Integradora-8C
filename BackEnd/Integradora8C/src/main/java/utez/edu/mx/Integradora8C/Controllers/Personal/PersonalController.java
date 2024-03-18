package utez.edu.mx.Integradora8C.Controllers.Personal;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Personal.PersonalDto;
import utez.edu.mx.Integradora8C.Entities.Personal.Personal;
import utez.edu.mx.Integradora8C.Services.Personal.PersonalServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/personal")
@CrossOrigin(value = {"*"})
public class PersonalController {

    private final PersonalServices services;

    @Autowired
    public PersonalController(PersonalServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Personal>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Personal>> insert(@RequestBody @Valid PersonalDto PersonalDto) {
        return new ResponseEntity<>(this.services.insert(PersonalDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Personal>> update(@RequestBody @Valid PersonalDto PersonalDto) {
        return new ResponseEntity<>(this.services.update(PersonalDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}
