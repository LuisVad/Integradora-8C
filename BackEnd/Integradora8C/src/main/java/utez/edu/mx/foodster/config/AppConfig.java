package utez.edu.mx.foodster.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import utez.edu.mx.foodster.dtos.categoriaspersonal.CategoriasPersonalDto;
import utez.edu.mx.foodster.dtos.personal.PersonalDto;
import utez.edu.mx.foodster.dtos.roles.RolesDto;
import utez.edu.mx.foodster.dtos.usuarios.UsuariosDto;
import utez.edu.mx.foodster.entities.categoriaspersonal.CategoriasPersonal;
import utez.edu.mx.foodster.entities.categoriaspersonal.CategoriasPersonalRepository;
import utez.edu.mx.foodster.entities.roles.Roles;
import utez.edu.mx.foodster.entities.roles.RolesRepository;
import utez.edu.mx.foodster.entities.usuarios.Usuarios;
import utez.edu.mx.foodster.services.personal.PersonalServices;
import utez.edu.mx.foodster.services.usuarios.UsuariosServices;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class AppConfig {

    private final RolesRepository rolesRepository;
    private final UsuariosServices usuariosServices;

    private final Random random = new Random();
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
        initRoles();
        initCategories();
        initUsers();
    }

    private void initRoles() {
        if (rolesRepository.count() != 0) return;

        saveRole("ADMIN");
        saveRole("CLIENTE");
        saveRole("PERSONAL");
    }

    private void saveRole(String roleName) {
        RolesDto rolesDto = new RolesDto(null, roleName, new Timestamp(System.currentTimeMillis()), true);
        rolesRepository.save(rolesDto.toEntity());
    }

    private void initCategories() {
        if (categoriasPersonalRepository.count() != 0) return;

        saveCategory("Mesero");
        saveCategory("Chef");
    }

    private void saveCategory(String categoryName) {
        categoriasPersonalRepository.save(new CategoriasPersonalDto(null, categoryName, new Timestamp(System.currentTimeMillis()), true).toEntity());
    }

    private void initUsers() {
        if (usuariosServices.count() != 0) return;

        rolesRepository.findAllByActiveOrderByUltimaModificacionDesc(true).forEach(this::processRole);
    }

    private void processRole(Roles roles) {
        String roleName = roles.getNombre();
        if (roleName.equals("ADMIN")) {
            saveUser(roles, "Cristian", "Jimenez", "Rodriguez", "7777909055", "redalphasiete@gmail.com", "admin");
        } else if (roleName.equals("CLIENTE")) {
            saveUser(roles, "Juan", "Camaney", "Ramirez", "7777909014", "juancamaney@yopmail.com", "cliente");
        } else if (roleName.equals("PERSONAL")) {
            createPersonalUsers(roles);
        }
    }

    private void saveUser(Roles roles, String name, String lastName1, String lastName2, String phone, String email, String password) {
        Set<Roles> rolesUser = new HashSet<>();
        rolesUser.add(roles);
        UsuariosDto usuariosDto = new UsuariosDto(null, name, lastName1, lastName2, phone, email, password, new Timestamp(System.currentTimeMillis()), true, rolesUser);
        Usuarios usuarios = usuariosDto.toEntity();
        usuariosServices.insert(usuarios);
    }

    private void createPersonalUsers(Roles roles) {
    String[] nombres = {"Juan", "Pedro", "Maria", "Jose", "Luis", "Ana", "Rosa", "Carlos", "Jorge", "Fernando", "Ricardo", "Roberto"};
    String[] apellidos = {"Rodriguez", "Juarez", "Jimenez", "Gonzalez", "Perez", "Lopez", "Garcia", "Hernandez", "Martinez", "Torres", "Sanchez", "Ramirez"};

    for (int i = 0; i < 100; i++) {
        String name = nombres[random.nextInt(nombres.length)];
        String lastName1 = apellidos[random.nextInt(apellidos.length)];
        String lastName2 = apellidos[random.nextInt(apellidos.length)];
        String email = "usuario" + i + "@yopmail.com";
        saveUser(roles, name, lastName1, lastName2, "7777909013", email, "personal");

        String categoryName = i <= 50 ? "Chef" : "Mesero";
        CategoriasPersonal categoriasPersonal = categoriasPersonalRepository.findByNombreAndActive(categoryName, true);
        PersonalDto personalDto = new PersonalDto(null, usuariosServices.getByCorreo(email), categoriasPersonal, new Timestamp(System.currentTimeMillis()), true);
        personalServices.insert(personalDto.toEntity());
    }
}
}
