package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.RevisionProjet;
import ma.gfi.leap.api.LEAPAPI.core.services.IRevisionProjetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class RevisionProjetController {

    @Autowired
    private IRevisionProjetService RevisionProjetService;



    //Fetches RevisionProjet by id
    @GetMapping(value= "/revisionProjet/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RevisionProjet> getRevisionProjetById(@PathVariable("id") Long id) {
        RevisionProjet ob = new RevisionProjet();
        BeanUtils.copyProperties(RevisionProjetService.getRevisionProjetById(id), ob);
        return new ResponseEntity<RevisionProjet>(ob, HttpStatus.OK);
    }



    //Fetches all RevisionProjets
    @GetMapping(value= "/revisionProjet/listRevisionProjet", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<RevisionProjet>> getAllRevisionProjets() {
        Collection<RevisionProjet> RevisionProjetList = RevisionProjetService.getAllRevisionProjets();

        return new ResponseEntity<>(RevisionProjetList, HttpStatus.OK);
    }

    //Creates a new RevisionProjet
    @PostMapping(value= "/revisionProjet/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public RevisionProjet addRevisionProjet(@RequestBody RevisionProjet RevisionProjet, UriComponentsBuilder builder) {
        RevisionProjet RevisionProjet1 = RevisionProjetService.addRevisionProjet(RevisionProjet);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/RevisionProjet/{id}").buildAndExpand(RevisionProjet1.getId()).toUri());
        return RevisionProjet1;
    }


  /*  //Updates evenmement
    @PutMapping("/RevisionProjet/edit/{id}")
    public ResponseEntity<RevisionProjet> updateRevisionProjet(@PathVariable(value = "id") Long RevisionProjetId,
                                                 @Valid @RequestBody RevisionProjet RevisionProjetDetails) throws Exception{
        RevisionProjet RevisionProjet = RevisionProjetService.getRevisionProjetById(RevisionProjetId);

        RevisionProjet.setValeur(RevisionProjetDetails.getValeur());


        final RevisionProjet updatedRevisionProjet = RevisionProjetService.addRevisionProjet(RevisionProjet);
        return ResponseEntity.ok(updatedRevisionProjet);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/revisionProjet/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteRevisionProjet(@PathVariable("id") Long id) {
        RevisionProjetService.deleteRevisionProjet(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
