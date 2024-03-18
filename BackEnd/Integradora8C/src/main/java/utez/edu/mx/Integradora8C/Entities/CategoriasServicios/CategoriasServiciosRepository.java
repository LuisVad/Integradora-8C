package utez.edu.mx.Integradora8C.Entities.CategoriasServicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasServiciosRepository extends JpaRepository<CategoriasServicios, String> {
    List<CategoriasServicios> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
