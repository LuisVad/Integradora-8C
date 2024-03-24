package utez.edu.mx.Integradora8C.Controllers.Auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Integradora8C.Dtos.Auth.SignDto;
import utez.edu.mx.Integradora8C.Services.AuthService.AuthService;
import utez.edu.mx.Integradora8C.Utils.Response;

@RestController
@RequestMapping("${apiPrefix}/auth")
@CrossOrigin(origins = {"*"})
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> signIn(@RequestBody SignDto dto) {
        return service.signIn(dto.getUsername(), dto.getPassword());
    }
}