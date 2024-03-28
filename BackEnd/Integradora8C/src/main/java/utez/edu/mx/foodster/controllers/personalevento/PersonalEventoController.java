package utez.edu.mx.foodster.controllers.personalevento;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.personalevento.PersonalEventoDto;
import utez.edu.mx.foodster.entities.personalevento.PersonalEvento;
import utez.edu.mx.foodster.services.personalevento.PersonalEventoServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/personal-evento")
@CrossOrigin(value = {"*"})
public class PersonalEventoController {
    private final PersonalEventoServices services;

    public PersonalEventoController(PersonalEventoServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<PersonalEvento>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<PersonalEvento>> insert(@RequestBody @Valid PersonalEventoDto personalEventoDto) {
        return new ResponseEntity<>(this.services.insert(personalEventoDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<PersonalEvento>> update(@RequestBody @Valid PersonalEventoDto personalEventoDto) {
        return new ResponseEntity<>(this.services.update(personalEventoDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}
