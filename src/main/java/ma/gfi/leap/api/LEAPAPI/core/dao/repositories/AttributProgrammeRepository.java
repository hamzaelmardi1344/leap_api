package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AttributProgrammeRepository extends JpaRepository<AttributProgramme,Long> {

    AttributProgramme findByValeur(String valeur);
    Collection<AttributProgramme> findAllByValeur(String valeur);
}
