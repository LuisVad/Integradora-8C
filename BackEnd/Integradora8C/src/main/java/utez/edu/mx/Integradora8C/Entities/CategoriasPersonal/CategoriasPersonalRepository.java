package utez.edu.mx.Integradora8C.Entities.CategoriasPersonal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasPersonalRepository extends JpaRepository<CategoriasPersonal, String> {

    List<CategoriasPersonal> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
