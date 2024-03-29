package utez.edu.mx.foodster.controllers.categoriaspersonal;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.categoriaspersonal.CategoriasPersonalDto;
import utez.edu.mx.foodster.entities.categoriaspersonal.CategoriasPersonal;
import utez.edu.mx.foodster.services.categoriaspersonal.CategoriasPersonalServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/categoria-personal")
@CrossOrigin(value = {"*"})
public class CategoriaPersonalController {
    private final CategoriasPersonalServices services;

    public CategoriaPersonalController(CategoriasPersonalServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<CategoriasPersonal>>> getAll() {
        return new ResponseEntity<>(this.services.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<CategoriasPersonal>> insert(@RequestBody @Valid CategoriasPersonalDto categoriasPersonalDto) {
        return new ResponseEntity<>(this.services.insert(categoriasPersonalDto.toEntity()), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Response<CategoriasPersonal>> update(@RequestBody @Valid CategoriasPersonalDto categoriasPersonalDto) {
        return new ResponseEntity<>(this.services.update(categoriasPersonalDto.toEntity()), HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid) {
        return new ResponseEntity<>(this.services.delete(uid), HttpStatus.OK);
    }
}