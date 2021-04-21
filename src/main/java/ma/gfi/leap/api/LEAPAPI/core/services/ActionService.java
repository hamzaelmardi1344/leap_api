package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ActionService implements IActionService {

    @Autowired
    private ActionRepository ActionRepository;

    @Override
    public Collection<Action> getAllActions() {
        Collection<Action> list = new ArrayList<>();
        ActionRepository.findAll(Sort.by(Sort.Direction.DESC,"id")).forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Action getActionById(Long ActionId) {
        Action Action = ActionRepository.findById(ActionId).get();
        return Action;
    }

    @Override
    public Action addAction(Action Action) {
        return ActionRepository.save(Action);
    }

    @Override
    public void updateAction(Action Action) {
        ActionRepository.save(Action);
    }

    @Override
    public void deleteAction(Long ActionId) {
        ActionRepository.delete(getActionById(ActionId));
    }

    @Override
    public Collection<Action> findByDateAndEtat(Date date, String etat) {
        return ActionRepository.findAllByDateFinAndEtat(date,etat);
    }

    @Override
    public Collection<Action> findByDateDebutAndAvancement(Date date,Float avancement) {
        return ActionRepository.findAllByDateDebutAndAvancement(date,avancement);
    }

    @Override
    public Collection<Action> findByDateFin(Date date) {
        return ActionRepository.findAllByDateFin(date);
    }

    @Override
    public Collection<Risque> getListRisqueByAction(Long id) {

        Action action = ActionRepository.findById(id).get();
        return action.getRisques();
    }

    @Override
    public Collection<Action> getByUtilisateurAndEtat(Long id, String etat) {
        return ActionRepository.findAllByUtilisateurAndEtat(id,etat);
    }

    @Override
    public Collection<Action> findActionByPublicAccess() {

        Collection<Action> actions = ActionRepository.findAll();

        return actions.stream().filter( p -> !p.getActionPrive()).collect(Collectors.toList());
    }



}
