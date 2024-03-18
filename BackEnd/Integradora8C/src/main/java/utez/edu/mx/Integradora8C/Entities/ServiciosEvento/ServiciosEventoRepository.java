package utez.edu.mx.Integradora8C.Entities.ServiciosEvento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiciosEventoRepository extends JpaRepository<ServiciosEvento, String> {
    List<ServiciosEvento> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
