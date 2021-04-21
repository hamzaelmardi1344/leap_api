package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {

    @Query(value = "select p  from Projet p  where p.dateFin < :date AND p.etat = :etat")
    Collection<Projet> findAllByDateFinAndEtat(Date date , String etat);


}
