package utez.edu.mx.Integradora8C.Entities.Direcciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionesRepository extends JpaRepository<Direcciones, String> {
    List<Direcciones> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
