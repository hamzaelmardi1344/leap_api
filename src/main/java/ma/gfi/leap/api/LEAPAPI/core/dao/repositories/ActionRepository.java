package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

    @Query(value = "select a  from Action a  where a.dateFin < :date AND a.etat = :etat")
    Collection<Action> findAllByDateFinAndEtat(Date date , String etat);

    @Query(value = "select a  from Action a  where a.dateDebut < :date AND a.avancement = :avancement")
    Collection<Action> findAllByDateDebutAndAvancement(Date date,Float avancement);


    @Query(value = "select a  from Action a  where a.dateFin < :date AND a.avancement < 100")
    Collection<Action> findAllByDateFin(Date date);

    @Query(value = "select a  from Action a  where a.utilisateur.id = :id AND a.etat = :etat")
    Collection<Action> findAllByUtilisateurAndEtat(Long id,String etat);



}
