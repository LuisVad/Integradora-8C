package utez.edu.mx.Integradora8C.Entities.Paquetes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaquetesRepository extends JpaRepository<Paquetes, String> {
}
