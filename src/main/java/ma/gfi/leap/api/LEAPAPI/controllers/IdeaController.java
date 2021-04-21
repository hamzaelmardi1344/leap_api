package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.services.IIdeaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class IdeaController {

    @Autowired
    private IIdeaService IdeaService;



    //Fetches Idea by id
    @GetMapping(value= "/idea/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Idea> getIdeaById(@PathVariable("id") Long id) {
        Idea ob = new Idea();
        BeanUtils.copyProperties(IdeaService.getIdeaById(id), ob);
        return new ResponseEntity<Idea>(ob, HttpStatus.OK);
    }



    //Fetches all Ideas
    @GetMapping(value= "/idea/listIdea", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Idea>> getAllIdeas() {
        Collection<Idea> IdeaList = IdeaService.getAllIdeas();

        return new ResponseEntity<>(IdeaList, HttpStatus.OK);
    }

    //Creates a new Idea
    @PostMapping(value= "/idea/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Idea addIdea(@RequestBody Idea Idea, UriComponentsBuilder builder) {
        Idea Idea1 = IdeaService.addIdea(Idea);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Idea/{id}").buildAndExpand(Idea1.getId()).toUri());
        return Idea1;
    }


    //Updates evenmement
    @PutMapping("/idea/edit/{id}")
    public ResponseEntity<Idea> updateIdea(@PathVariable(value = "id") Long IdeaId,
                                                 @Valid @RequestBody Idea IdeaDetails) throws Exception{
        Idea Idea = IdeaService.getIdeaById(IdeaId);

        Idea.setValidePar(IdeaDetails.getValidePar());
        Idea.setValideLe(IdeaDetails.getValideLe());
        Idea.setTitre(IdeaDetails.getTitre());
        Idea.setStatut(IdeaDetails.getStatut());
        Idea.setProprietaire(IdeaDetails.getProprietaire());
        Idea.setModerePar(IdeaDetails.getModerePar());
        Idea.setModereLe(IdeaDetails.getModereLe());
        Idea.setFichierJoint(IdeaDetails.getFichierJoint());
        Idea.setDomaine(IdeaDetails.getDomaine());
        Idea.setDecisionValidateur(IdeaDetails.getDecisionValidateur());
        Idea.setDecisionModeration(IdeaDetails.getDecisionModeration());
        Idea.setConvertiPar(IdeaDetails.getConvertiPar());
        Idea.setConvertiLe(IdeaDetails.getConvertiLe());
        Idea.setCommValidateur(IdeaDetails.getCommValidateur());
        Idea.setCommModeration(IdeaDetails.getCommModeration());
        Idea.setCommConversion(IdeaDetails.getCommConversion());
        Idea.setIdea(IdeaDetails.getIdea());
        Idea.setUtilisateurs(IdeaDetails.getUtilisateurs());
        Idea.setNumeroEtape(IdeaDetails.getNumeroEtape());
        Idea.setConverted(IdeaDetails.getConverted());
        Idea.setModerated(IdeaDetails.getModerated());
        Idea.setValidated(IdeaDetails.getValidated());
        Idea.setCreatedIdea(IdeaDetails.getCreatedIdea());


        final Idea updatedIdea = IdeaService.addIdea(Idea);
        return ResponseEntity.ok(updatedIdea);
    }
    //Deletes evenemnt by id
    @DeleteMapping(value= "/idea/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteIdea(@PathVariable("id") Long id) {
        IdeaService.deleteIdea(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }





    @PostMapping(value = "/idea/add/{id}/documentaires")
    public boolean addDocToIdea(@PathVariable("id") Long id,@RequestBody DocumentaireVF DocumentaireVF)
    {
        return  IdeaService.addDocToIdea(DocumentaireVF,id);
    }




    @GetMapping(value = "/idea/{id}/documentaireVFs")
    public ResponseEntity<Collection<DocumentaireVF>> getListDocByIdeaID(@PathVariable("id") Long id)
    {
        Collection<DocumentaireVF> documentaireVFS = IdeaService.getListDocByIdea(id);
        return  new ResponseEntity<Collection<DocumentaireVF>>(documentaireVFS,HttpStatus.OK);
    }
}
