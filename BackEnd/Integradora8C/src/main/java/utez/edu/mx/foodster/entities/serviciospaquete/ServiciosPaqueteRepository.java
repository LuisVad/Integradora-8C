package utez.edu.mx.foodster.entities.serviciospaquete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ServiciosPaqueteRepository extends JpaRepository<ServiciosPaquete, String> {
    List<ServiciosPaquete> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
