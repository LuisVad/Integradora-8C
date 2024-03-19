package utez.edu.mx.Integradora8C.Services.AuthService;

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
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Security.Jwt.JwtProvider;
import utez.edu.mx.Integradora8C.Services.Usuarios.UsuariosServices;
import utez.edu.mx.Integradora8C.Utils.Response;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class AuthService {

    private Logger logger = Logger.getLogger(AuthService.class.getName());

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
    public ResponseEntity<Response> signIn(String username, String password) {
        try {
            Optional<Usuarios> foundUser = service.getByCorreo(username);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new Response(null, true, 404, "UserNotFound"), HttpStatus.BAD_REQUEST);
            Usuarios user = foundUser.get();
            if (!user.getActive())
                return new ResponseEntity<>(new Response(null, true, 401, "Inactive"), HttpStatus.BAD_REQUEST);

            Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = provider.generateToken(auth);
            return new ResponseEntity<>(new Response(token, false, 200, "OK"), HttpStatus.OK);
        } catch (Exception e) {
            this.logger.severe(e.getMessage());
            String message = "CredentialsMismatch";
            if (e instanceof DisabledException) message = "UserDisabled";
            return new ResponseEntity<>(new Response(null, true, 401, message), HttpStatus.BAD_REQUEST);
        }
    }
}
