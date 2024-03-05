package utez.edu.mx.Integradora8C.Entities.DireccionesUsuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionesUsuarioRepository extends JpaRepository<DireccionesUsuario, String> {
}
