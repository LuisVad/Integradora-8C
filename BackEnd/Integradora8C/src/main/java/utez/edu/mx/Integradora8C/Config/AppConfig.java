package utez.edu.mx.Integradora8C.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import utez.edu.mx.Integradora8C.Dtos.CategoriasPersonal.CategoriasPersonalDto;
import utez.edu.mx.Integradora8C.Dtos.Personal.PersonalDto;
import utez.edu.mx.Integradora8C.Dtos.Roles.RolesDto;
import utez.edu.mx.Integradora8C.Dtos.Usuarios.UsuariosDto;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonalRepository;
import utez.edu.mx.Integradora8C.Entities.Roles.Roles;
import utez.edu.mx.Integradora8C.Entities.Roles.RolesRepository;
import utez.edu.mx.Integradora8C.Entities.Usuarios.Usuarios;
import utez.edu.mx.Integradora8C.Services.Personal.PersonalServices;
import utez.edu.mx.Integradora8C.Services.Usuarios.UsuariosServices;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {

    private final RolesRepository rolesRepository;
    private final UsuariosServices usuariosServices;
    private final PersonalServices personalServices;

    private final CategoriasPersonalRepository categoriasPersonalRepository;


    @Autowired
    public AppConfig(RolesRepository rolesRepository, UsuariosServices usuariosServices, PersonalServices personalServices, CategoriasPersonalRepository categoriasPersonalRepository) {
        this.rolesRepository = rolesRepository;
        this.usuariosServices = usuariosServices;
        this.personalServices = personalServices;
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
                    UsuariosDto usuariosDto = new UsuariosDto(null, "Juan", "Camaney", "Ramirez", "7777909014", "juancamaney@yopmail.com", "cliente", new Timestamp(System.currentTimeMillis()), true, rolesUser);
                    Usuarios usuarios = usuariosDto.toEntity();
                    usuariosServices.insert(usuarios);
                }
                if (roles.getNombre().equals("PERSONAL")) {
                    String[] nombres = {"Juan", "Pedro", "Maria", "Jose", "Luis", "Ana", "Rosa", "Carlos", "Jorge", "Fernando", "Ricardo", "Roberto"};
                    String[] apellidos = {"Rodriguez", "Juarez", "Jimenez", "Gonzalez", "Perez", "Lopez", "Garcia", "Hernandez", "Martinez", "Torres", "Sanchez", "Ramirez"};

                    for (int i = 0; i < 400; i++) {
                        if (i <= 100){
                            Set<Roles> rolesUser = new HashSet<>();
                            rolesUser.add(roles);
                            UsuariosDto usuariosDto = new UsuariosDto(null, nombres[(int) (Math.random() * 12)], apellidos[(int) (Math.random() * 12)], apellidos[(int) (Math.random() * 12)], "7777909013", "usuario" + i + "@yopmail.com", "personal", new Timestamp(System.currentTimeMillis()), true, rolesUser);
                            Usuarios usuarios = usuariosDto.toEntity();
                            usuariosServices.insert(usuarios);
                            CategoriasPersonal categoriasPersonal = categoriasPersonalRepository.findByNombreAndActive("Chef", true);
                            PersonalDto personalDto = new PersonalDto(null, usuarios, categoriasPersonal, new Timestamp(System.currentTimeMillis()), true);
                            personalServices.insert(personalDto.toEntity());
                        }else {
                            Set<Roles> rolesUser = new HashSet<>();
                            rolesUser.add(roles);
                            UsuariosDto usuariosDto = new UsuariosDto(null, nombres[(int) (Math.random() * 12)], apellidos[(int) (Math.random() * 12)], apellidos[(int) (Math.random() * 12)], "7777909013", "usuario" + i + "@yopmail.com", "personal", new Timestamp(System.currentTimeMillis()), true, rolesUser);
                            Usuarios usuarios = usuariosDto.toEntity();
                            usuariosServices.insert(usuarios);
                            CategoriasPersonal categoriasPersonal = categoriasPersonalRepository.findByNombreAndActive("Mesero", true);
                            PersonalDto personalDto = new PersonalDto(null, usuarios, categoriasPersonal, new Timestamp(System.currentTimeMillis()), true);
                            personalServices.insert(personalDto.toEntity());

                        }
                    }
                }
            });
        }


    }
}
