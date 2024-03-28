package utez.edu.mx.foodster.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.foodster.dtos.auth.UsuarioTokenDto;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.security.jwt.JwtProvider;
import utez.edu.mx.foodster.services.usuarios.UsuariosServices;
import utez.edu.mx.foodster.utils.Response;

import java.util.logging.Logger;

@Service
@Transactional
public class AuthService {

    private final Logger logger = Logger.getLogger(AuthService.class.getName());

    private final UsuariosServices service;

    private final AuthenticationManager manager;

    private final JwtProvider provider;

    @Autowired
    public AuthService(UsuariosServices service, AuthenticationManager manager, JwtProvider provider) {
        this.service = service;
        this.manager = manager;
        this.provider = provider;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Response<UsuarioTokenDto>> login(String username, String password) {
        try {
            Usuarios foundUser = service.getByCorreo(username);
            if (foundUser == null)
                return new ResponseEntity<>(new Response<>(null, true, 404, "Usuario no encontrado"), HttpStatus.NOT_FOUND);
            if (Boolean.FALSE.equals(foundUser.getActive())) {
                return new ResponseEntity<>(new Response<>(null, true, 401, "Usuario inactivo"), HttpStatus.UNAUTHORIZED);
            }
            Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = provider.generateToken(auth);
            UsuarioTokenDto data = new UsuarioTokenDto(foundUser, token);
            return new ResponseEntity<>(new Response<>(data, false, 200, "OK"), HttpStatus.OK);
        } catch (Exception e) {
            this.logger.severe(e.getMessage());
            String message = "Credenciales incorrectas";
            if (e instanceof DisabledException) message = "Usuario inactivo";
            return new ResponseEntity<>(new Response<>(null, true, 401, message), HttpStatus.BAD_REQUEST);
        }
    }
}
