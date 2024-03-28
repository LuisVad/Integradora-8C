package utez.edu.mx.foodster.controllers.auth;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.foodster.dtos.auth.SignDto;
import utez.edu.mx.foodster.services.auth.AuthService;
import utez.edu.mx.foodster.utils.Response;

@RestController
@RequestMapping("${apiPrefix}/auth")
@CrossOrigin(value = {"*"})
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Response> signIn(@RequestBody @Valid SignDto dto) {
        return service.signIn(dto.getCorreo(), dto.getContrasenia());
    }
}
