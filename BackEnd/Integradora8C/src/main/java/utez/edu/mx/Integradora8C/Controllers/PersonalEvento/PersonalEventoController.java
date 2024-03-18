package utez.edu.mx.Integradora8C.Controllers.PersonalEvento;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.PersonalEvento.PersonalEventoDto;
import utez.edu.mx.Integradora8C.Entities.PersonalEvento.PersonalEvento;
import utez.edu.mx.Integradora8C.Services.PersonalEvento.PersonalEventoServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/personal-evento")
@CrossOrigin(value = {"*"})
public class PersonalEventoController {
    private final PersonalEventoServices services;

    @Autowired
    public PersonalEventoController(PersonalEventoServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<PersonalEvento>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<PersonalEvento>> insert(@RequestBody @Valid PersonalEventoDto PersonalEventoDto) {
        return new ResponseEntity<>(this.services.insert(PersonalEventoDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<PersonalEvento>> update(@RequestBody @Valid PersonalEventoDto PersonalEventoDto) {
        return new ResponseEntity<>(this.services.update(PersonalEventoDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}
