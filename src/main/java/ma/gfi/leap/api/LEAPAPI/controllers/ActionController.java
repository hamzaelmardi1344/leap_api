package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Projet;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import ma.gfi.leap.api.LEAPAPI.core.services.IActionService;
import ma.gfi.leap.api.LEAPAPI.core.services.IUtilisateurService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ActionController {

    @Autowired
    private IActionService ActionService;

    @Autowired
    private IUtilisateurService utilisateurService;


    //Fetches Action by id
    @GetMapping(value= "/action/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Action> getActionById(@PathVariable("id") Long id) {
        Action ob = new Action();
        BeanUtils.copyProperties(ActionService.getActionById(id), ob);
        return new ResponseEntity<Action>(ob, HttpStatus.OK);
    }



    //Fetches all Actions
    @GetMapping(value= "/action/listAction", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Action>> getAllActions() {
        Collection<Action> ActionList = ActionService.getAllActions();

        return new ResponseEntity<>(ActionList, HttpStatus.OK);
    }

    //Creates a new Action
    @PostMapping(value= "/action/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Action addAction(@RequestBody Action Action, UriComponentsBuilder builder) {
        Action Action1 = ActionService.addAction(Action);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Action/{id}").buildAndExpand(Action1.getId()).toUri());
        return Action1;
    }


   //Updates evenmement
    @PutMapping("/action/edit/{id}")
    public ResponseEntity<Action> updateAction(@PathVariable(value = "id") Long ActionId,
                                                 @Valid @RequestBody Action ActionDetails) throws Exception{
        Action Action = ActionService.getActionById(ActionId);

        Action.setUtilisateur(ActionDetails.getUtilisateur());
        Action.setRisques(ActionDetails.getRisques());
        Action.setResponsable(ActionDetails.getResponsable());
        Action.setProjet(ActionDetails.getProjet());
        Action.setProgramme(ActionDetails.getProgramme());
        Action.setEtat(ActionDetails.getEtat());
        Action.setDescription(ActionDetails.getDescription());
        Action.setDateFin(ActionDetails.getDateFin());
        Action.setDateDebut(ActionDetails.getDateDebut());
        Action.setCode(ActionDetails.getCode());
        Action.setBudgetAction(ActionDetails.getBudgetAction());
        Action.setAvancementTheorique(ActionDetails.getAvancementTheorique());
        Action.setAvancement(ActionDetails.getAvancement());
        Action.setAction(ActionDetails.getAction());
        Action.setActionPrive(ActionDetails.getActionPrive());



        final Action updatedAction = ActionService.addAction(Action);
        return ResponseEntity.ok(updatedAction);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "/action/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteAction(@PathVariable("id") Long id) {
        ActionService.deleteAction(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



    @GetMapping(value = "/action/{id}/risques")
    public ResponseEntity<Collection<Risque>> getListRisqueByProjetID(@PathVariable("id") Long id)
    {
        Collection<Risque> risques = ActionService.getListRisqueByAction(id);
        return  new ResponseEntity<Collection<Risque>>(risques,HttpStatus.OK);
    }


    @GetMapping(value = "/listAction/{date}/{etat}")
    public ResponseEntity<Collection<Action>> getListActionByDateFinAndEtat(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable("etat") String etat)
    {
        Collection<Action> action = ActionService.findByDateAndEtat(date,etat);
        return  new ResponseEntity<Collection<Action>>(action,HttpStatus.OK);
    }



    @GetMapping(value = "/listAction/getByDateAndAvancement/{date}/{avancement}")
    public ResponseEntity<Collection<Action>> getListActionByDateDebut(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,@PathVariable(name = "avancement") Float avancement)
    {
        Collection<Action> action = ActionService.findByDateDebutAndAvancement(date,avancement);
        return  new ResponseEntity<Collection<Action>>(action,HttpStatus.OK);
    }


    @GetMapping(value = "/listAction/getByDateFin/{date}")
    public ResponseEntity<Collection<Action>> getListActionByDateFin(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        Collection<Action> action = ActionService.findByDateFin(date);
        return  new ResponseEntity<Collection<Action>>(action,HttpStatus.OK);
    }


    @GetMapping(value = "/listAction/getByUserAndEtat/{id}/{etat}")
    public ResponseEntity<Collection<Action>> getByUtilisateurAndEtat(@PathVariable("id") Long id, @PathVariable("etat") String etat)
    {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        Collection<Action> action = ActionService.getByUtilisateurAndEtat(utilisateur.getId(),etat);
        return  new ResponseEntity<Collection<Action>>(action,HttpStatus.OK);
    }


    @GetMapping(value = "/actions/byAccess")
    public Collection<Action> findActionByAccess()
    {
        return  ActionService.findActionByPublicAccess();
    }





}
