package utez.edu.mx.Integradora8C.Entities.PersonalEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalEventoRepository extends JpaRepository<PersonalEvento, String> {
}
