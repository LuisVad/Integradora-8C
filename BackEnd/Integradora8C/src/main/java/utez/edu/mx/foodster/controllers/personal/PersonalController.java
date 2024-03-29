package utez.edu.mx.foodster.controllers.personal;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.personal.PersonalDto;
import utez.edu.mx.foodster.entities.personal.Personal;
import utez.edu.mx.foodster.services.personal.PersonalServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/personal")
@CrossOrigin(value = {"*"})
public class PersonalController {

    private final PersonalServices services;

    public PersonalController(PersonalServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Personal>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<Response<List<Personal>>> getAllByStatus(@PathVariable("status") Boolean status) {
        return new ResponseEntity<>(this.services.getAllByStatus(status), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Personal>> insert(@RequestBody @Valid PersonalDto personalDto) {
        return new ResponseEntity<>(this.services.insert(personalDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Personal>> update(@RequestBody @Valid PersonalDto personalDto) {
        return new ResponseEntity<>(this.services.update(personalDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
    @DeleteMapping("/status/{uid}")
    public ResponseEntity<Response<Boolean>> changeStatus(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.changeStatus(uid), HttpStatus.OK);
    }
}
