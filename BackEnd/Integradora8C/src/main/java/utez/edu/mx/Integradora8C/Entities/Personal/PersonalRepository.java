package utez.edu.mx.Integradora8C.Entities.Personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {

    List<Personal> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);
}
