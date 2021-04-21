package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Perimetre;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerimetreRepository extends JpaRepository<Perimetre,Long> {
}
