package utez.edu.mx.Integradora8C.Entities.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    List<Usuarios> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}