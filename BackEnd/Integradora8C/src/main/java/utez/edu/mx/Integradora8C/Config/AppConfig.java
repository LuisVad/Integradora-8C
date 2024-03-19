package utez.edu.mx.Integradora8C.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import utez.edu.mx.Integradora8C.Dtos.CategoriasPersonal.CategoriasPersonalDto;
import utez.edu.mx.Integradora8C.Dtos.Roles.RolesDto;
import utez.edu.mx.Integradora8C.Dtos.Usuarios.UsuariosDto;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonalRepository;
import utez.edu.mx.Integradora8C.Entities.Roles.Roles;
import utez.edu.mx.Integradora8C.Entities.Roles.RolesRepository;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Services.Usuarios.UsuariosServices;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {

    private final RolesRepository rolesRepository;
    private final UsuariosServices usuariosServices;

    private final CategoriasPersonalRepository categoriasPersonalRepository;


    @Autowired
    public AppConfig(RolesRepository rolesRepository, UsuariosServices usuariosServices, CategoriasPersonalRepository categoriasPersonalRepository) {
        this.rolesRepository = rolesRepository;
        this.usuariosServices = usuariosServices;
        this.categoriasPersonalRepository = categoriasPersonalRepository;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init() {
        if (rolesRepository.count() == 0) {
            RolesDto rolesDto = new RolesDto(null, "ADMIN", new Timestamp(System.currentTimeMillis()), true);
            rolesRepository.save(rolesDto.toEntity());
            rolesDto = new RolesDto(null, "CLIENTE", new Timestamp(System.currentTimeMillis()), true);
            rolesRepository.save(rolesDto.toEntity());
            rolesDto = new RolesDto(null, "PERSONAL", new Timestamp(System.currentTimeMillis()), true);
            rolesRepository.save(rolesDto.toEntity());
        }
        if (categoriasPersonalRepository.count() == 0) {
            categoriasPersonalRepository.save(new CategoriasPersonalDto(null, "Mesero", new Timestamp(System.currentTimeMillis()), true).toEntity());
            categoriasPersonalRepository.save(new CategoriasPersonalDto(null, "Chef", new Timestamp(System.currentTimeMillis()), true).toEntity());
        }

        if (usuariosServices.count() == 0) {
            rolesRepository.findAllByActiveOrderByUltimaModificacionDesc(true).forEach(roles -> {
                if (roles.getNombre().equals("ADMIN")) {
                    Set<Roles> rolesUser = new HashSet<>();
                    rolesUser.add(roles);
                    UsuariosDto usuariosDto = new UsuariosDto(null, "Cristian", "Rodriguez", "Rodriguez", "7777909013", "redalphasiete@gmail.com", "admin", new Timestamp(System.currentTimeMillis()), true, rolesUser);
                    Usuarios usuarios = usuariosDto.toEntity();
                    usuariosServices.insert(usuarios);
                }
                if (roles.getNombre().equals("CLIENTE")) {
                    Set<Roles> rolesUser = new HashSet<>();
                    rolesUser.add(roles);
                    UsuariosDto usuariosDto = new UsuariosDto(null, "Juan", "Camaney", "Ramirez", "7777909014", "juancamaney@gmail.com", "cliente", new Timestamp(System.currentTimeMillis()), true, rolesUser);
                    Usuarios usuarios = usuariosDto.toEntity();
                    usuariosServices.insert(usuarios);
                }
            });
        }


    }
}
