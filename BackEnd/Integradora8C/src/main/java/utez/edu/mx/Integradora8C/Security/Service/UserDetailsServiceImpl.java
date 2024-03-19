package utez.edu.mx.Integradora8C.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Entities.Usuarios.UsuariosRepository;
import utez.edu.mx.Integradora8C.Security.Entity.UserDetailsImpl;
import utez.edu.mx.Integradora8C.Services.Usuarios.UsuariosServices;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuariosRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UsuariosRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> foundUser = this.repository.findByCorreoAndActive(username, true);
        if (foundUser.isPresent()) return UserDetailsImpl.build(foundUser.get());
        throw new UsernameNotFoundException("UserNotFound");
    }
}
