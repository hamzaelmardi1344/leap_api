package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Projet;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;

import java.util.Collection;
import java.util.Date;

public interface IActionService {

    Collection<Action> getAllActions();
    Action getActionById(Long ActionId);
    Action addAction(Action Action);
    void updateAction(Action Action);
    void deleteAction(Long ActionId);


    Collection<Action> findByDateAndEtat(Date date, String etat);
    Collection<Action> findByDateDebutAndAvancement(Date date,Float avancement);
    Collection<Action> findByDateFin(Date date);

    Collection<Risque> getListRisqueByAction(Long id);

    Collection<Action> getByUtilisateurAndEtat(Long id,String etat);
    Collection<Action> findActionByPublicAccess();


}
