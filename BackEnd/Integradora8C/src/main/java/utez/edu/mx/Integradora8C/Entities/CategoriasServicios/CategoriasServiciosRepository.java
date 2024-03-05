package utez.edu.mx.Integradora8C.Entities.CategoriasServicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utez.edu.mx.Integradora8C.Entities.CategoriasPersonal.CategoriasPersonal;

@Repository
public interface CategoriasServiciosRepository extends JpaRepository<CategoriasServicios, String> {
}
