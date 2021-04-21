package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProjet;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributProjetRepository extends JpaRepository<AttributProjet,Long> {
}
