package utez.edu.mx.Integradora8C.Entities.BitacoraDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraDatosRepository extends JpaRepository<BitacoraDatos, String> {
}
