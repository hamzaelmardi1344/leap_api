package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Indicateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Perimetre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicateurRepository extends JpaRepository<Indicateur,Long> {
}
