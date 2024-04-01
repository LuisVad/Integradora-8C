package utez.edu.mx.foodster.entities.personalevento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalEventoRepository extends JpaRepository<PersonalEvento, String> {

    List<PersonalEvento> findAllByActiveOrderByUltimaModificacionDesc(Boolean active);

    PersonalEvento findByIdPersonalEventoAndActive(String idPersonalEvento, Boolean active);

    @Query(value = "SELECT * FROM personal_evento WHERE id_evento = ?1 AND active = ?2", nativeQuery = true)
    List<PersonalEvento> findByIdEventoAndActive(String idEvento, Boolean active);
}
