package utez.edu.mx.foodster.entities.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    List<Usuarios> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);

    Usuarios findByCorreoAndActive(String correo, Boolean active);

    @Modifying
    @Query(value = "INSERT INTO usuarios_roles (id_rol,id_usuario) VALUES (:roleId, :userId);", nativeQuery = true)
    int saveUserRole(String userId, String roleId);

}