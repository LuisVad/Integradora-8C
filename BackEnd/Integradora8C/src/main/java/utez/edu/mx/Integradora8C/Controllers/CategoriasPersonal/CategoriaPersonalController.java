package utez.edu.mx.Integradora8C.Controllers.CategoriasPersonal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.CategoriasPersonal.CategoriasPersonalDto;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Services.CategoriasPersonal.CategoriasPersonalServices;
import utez.edu.mx.Integradora8C.utils.Response;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/categoria-personal")
@CrossOrigin(value = {"*"})
public class CategoriaPersonalController {
    @Autowired
    private CategoriasPersonalServices services;
    @GetMapping("/")
    public ResponseEntity<Response<List<CategoriasPersonal>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<CategoriasPersonal>> insert(@RequestBody CategoriasPersonalDto categoriasPersonalDto){
        return new ResponseEntity<>(
                this.services.insert(categoriasPersonalDto.toEntity()),
                HttpStatus.OK
        );
    }
    @PutMapping("/")
    public ResponseEntity<Response<CategoriasPersonal>> update(@RequestBody CategoriasPersonalDto categoriasPersonalDto){
        return new ResponseEntity<>(
                this.services.update(categoriasPersonalDto.toEntity()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{uid}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable("uid") String uid ){
        return new ResponseEntity<>(
                this.services.delete(uid),
                HttpStatus.OK
        );
    }
}
