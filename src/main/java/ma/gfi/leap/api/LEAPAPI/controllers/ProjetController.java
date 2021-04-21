package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.services.IProjetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ProjetController {

    @Autowired
    private IProjetService ProjetService;



    //Fetches Projet by id
    @GetMapping(value= "/projet/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Projet> getProjetById(@PathVariable("id") Long id) {
        Projet ob = new Projet();
        BeanUtils.copyProperties(ProjetService.getProjetById(id), ob);
        return new ResponseEntity<Projet>(ob, HttpStatus.OK);
    }



    //Fetches all Projets
    @GetMapping(value= "/projet/listProjet", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Projet>> getAllProjets() {
        Collection<Projet> ProjetList = ProjetService.getAllProjets();

        return new ResponseEntity<>(ProjetList, HttpStatus.OK);
    }

    //Creates a new Projet
    @PostMapping(value= "/projet/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Projet addProjet(@RequestBody Projet Projet, UriComponentsBuilder builder) {
        Projet Projet1 = ProjetService.addProjet(Projet);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Projet/{id}").buildAndExpand(Projet1.getId()).toUri());
        return Projet1;
    }


    //Updates evenmement
    @PutMapping("/projet/edit/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable(value = "id") Long ProjetId,
                                                 @Valid @RequestBody Projet ProjetDetails) throws Exception{
        Projet Projet = ProjetService.getProjetById(ProjetId);

        Projet.setRisques(ProjetDetails.getRisques());
        Projet.setRevisionProjets(ProjetDetails.getRevisionProjets());
        Projet.setProgramme(ProjetDetails.getProgramme());
        Projet.setEtat(ProjetDetails.getEtat());
        Projet.setListValeurAttribut(ProjetDetails.getListValeurAttribut());
        Projet.setProjet(ProjetDetails.getProjet());
       Projet.setRisques(ProjetDetails.getRisques());
       Projet.setRevisionProjets(ProjetDetails.getRevisionProjets());
       Projet.setActionProjets(ProjetDetails.getActionProjets());
       Projet.setAlerte(ProjetDetails.getAlerte());
       Projet.setAttributProgrammes(ProjetDetails.getAttributProgrammes());
       Projet.setAttributProjets(ProjetDetails.getAttributProjets());
       Projet.setAvancement(ProjetDetails.getAvancement());
       Projet.setAvancementTheorique(ProjetDetails.getAvancementTheorique());
       Projet.setCode(ProjetDetails.getCode());
       Projet.setDateDebut(ProjetDetails.getDateDebut());
       Projet.setDateFin(ProjetDetails.getDateFin());
       Projet.setDescription(ProjetDetails.getDescription());
       Projet.setProjetPrive(ProjetDetails.getProjetPrive());

        final Projet updatedProjet = ProjetService.addProjet(Projet);
        return ResponseEntity.ok(updatedProjet);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "/projet/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteProjet(@PathVariable("id") Long id) {
        ProjetService.deleteProjet(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



    @GetMapping(value = "/projet/{id}/attributProgrammes")
    public ResponseEntity<Collection<AttributProgramme>> getListAtributProgrammeByProjetID(@PathVariable("id") Long id)
    {
        Collection<AttributProgramme> attributProgrammes = ProjetService.getListAttributProgrammeByProjet(id);
        return  new ResponseEntity<Collection<AttributProgramme>>(attributProgrammes,HttpStatus.OK);
    }

    @GetMapping(value = "/projet/{id}/attributProjets")
    public ResponseEntity<Collection<AttributProjet>> getListAtributProjetByProjetID(@PathVariable("id") Long id)
    {
        Collection<AttributProjet> attributProjets = ProjetService.getListAttributProjetByProjet(id);
        return  new ResponseEntity<Collection<AttributProjet>>(attributProjets,HttpStatus.OK);
    }

    @GetMapping(value = "/projet/{id}/risques")
    public ResponseEntity<Collection<Risque>> getListRisqueByProjetID(@PathVariable("id") Long id)
    {
        Collection<Risque> risques = ProjetService.getListRisqueByProjet(id);
        return  new ResponseEntity<Collection<Risque>>(risques,HttpStatus.OK);
    }


    @GetMapping(value = "/projet/{id}/actions")
    public ResponseEntity<Collection<Action>> getListActionByProjetID(@PathVariable("id") Long id)
    {
        Collection<Action> actions = ProjetService.getListActionByProjet(id);
        return  new ResponseEntity<Collection<Action>>(actions,HttpStatus.OK);
    }
    @GetMapping(value = "/projet/{id}/restrictedActions")
    public ResponseEntity<Collection<Action>> getListActionByProjetIDAndAccess(@PathVariable("id") Long id)
    {
        Collection<Action> actions = ProjetService.getListActionByProjetAndAccess(id);
        return  new ResponseEntity<Collection<Action>>(actions,HttpStatus.OK);
    }

    @GetMapping(value = "/projet/{id}/revisionProjet")
    public ResponseEntity<Collection<RevisionProjet>> getListRevisionByProjetID(@PathVariable("id") Long id)
    {
        Collection<RevisionProjet> revisionProjets = ProjetService.getListRevisionByProjet(id);
        return  new ResponseEntity<Collection<RevisionProjet>>(revisionProjets,HttpStatus.OK);
    }









    @GetMapping(value = "/listProjet/{date}/{etat}")
    public ResponseEntity<Collection<Projet>> getListProjetByDateFinAndEtat(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable("etat") String etat)
    {
        Collection<Projet> projets= ProjetService.findByDateAndEtat(date,etat);
        return  new ResponseEntity<Collection<Projet>>(projets,HttpStatus.OK);
    }

    @GetMapping(value = "/projets/byAccess")
    public Collection<Projet> findProjByAccess()
    {
        return  ProjetService.findProjByPublicAccess();
    }




    @GetMapping(value = "/projet/{id}/documentaireVFs")
    public ResponseEntity<Collection<DocumentaireVF>> getListDocByProjetID(@PathVariable("id") Long id)
    {
        Collection<DocumentaireVF> documentaireVFS = ProjetService.getListDocByProjet(id);
        return  new ResponseEntity<Collection<DocumentaireVF>>(documentaireVFS,HttpStatus.OK);
    }


    @GetMapping(value = "/projet/{id}/fichierJoints")
    public ResponseEntity<Collection<FichierJoint>> getFichierJointByProjetID(@PathVariable("id") Long id)
    {
        Collection<FichierJoint> fichierJoints = ProjetService.getFichierJointByProjet(id);
        return  new ResponseEntity<Collection<FichierJoint>>(fichierJoints,HttpStatus.OK);
    }


    @GetMapping(value = "/projet/{id}/indicateurs")
    public ResponseEntity<Collection<Indicateur>> getIndicateurByProjetID(@PathVariable("id") Long id)
    {
        Collection<Indicateur> indicateurs = ProjetService.getIndicateurByProjet(id);
        return  new ResponseEntity<Collection<Indicateur>>(indicateurs,HttpStatus.OK);
    }



    @PostMapping(value = "/projet/add/{id}/documentaires")
    public boolean addDocToProgramme(@PathVariable("id") Long id,@RequestBody DocumentaireVF DocumentaireVF)
    {
        return  ProjetService.addDocToProjet(DocumentaireVF,id);
    }


}
