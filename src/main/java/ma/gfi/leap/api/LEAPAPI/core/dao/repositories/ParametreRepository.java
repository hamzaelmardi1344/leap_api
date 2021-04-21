package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParametreRepository extends JpaRepository<Parametre,Long> {
}
