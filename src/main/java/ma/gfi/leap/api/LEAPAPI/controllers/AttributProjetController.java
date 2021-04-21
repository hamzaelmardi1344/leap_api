package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProjet;
import ma.gfi.leap.api.LEAPAPI.core.services.IAttributProjetService;
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
public class AttributProjetController {

    @Autowired
    private IAttributProjetService AttributProjetService;



    //Fetches AttributProjet by id
    @GetMapping(value= "/attributProjet/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<AttributProjet> getAttributProjetById(@PathVariable("id") Long id) {
        AttributProjet ob = new AttributProjet();
        BeanUtils.copyProperties(AttributProjetService.getAttributProjetById(id), ob);
        return new ResponseEntity<AttributProjet>(ob, HttpStatus.OK);
    }



    //Fetches all AttributProjets
    @GetMapping(value= "/attributProjet/listAttributProjet", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<AttributProjet>> getAllAttributProjets() {
        Collection<AttributProjet> AttributProjetList = AttributProjetService.getAllAttributProjets();

        return new ResponseEntity<>(AttributProjetList, HttpStatus.OK);
    }

    //Creates a new AttributProjet
    @PostMapping(value= "/attributProjet/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public AttributProjet addAttributProjet(@RequestBody AttributProjet AttributProjet, UriComponentsBuilder builder) {
        AttributProjet AttributProjet1 = AttributProjetService.addAttributProjet(AttributProjet);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/AttributProjet/{id}").buildAndExpand(AttributProjet1.getId()).toUri());
        return AttributProjet1;
    }


  /*  //Updates evenmement
    @PutMapping("/AttributProjet/edit/{id}")
    public ResponseEntity<AttributProjet> updateAttributProjet(@PathVariable(value = "id") Long AttributProjetId,
                                                 @Valid @RequestBody AttributProjet AttributProjetDetails) throws Exception{
        AttributProjet AttributProjet = AttributProjetService.getAttributProjetById(AttributProjetId);

        AttributProjet.setValeur(AttributProjetDetails.getValeur());


        final AttributProjet updatedAttributProjet = AttributProjetService.addAttributProjet(AttributProjet);
        return ResponseEntity.ok(updatedAttributProjet);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/attributProjet/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteAttributProjet(@PathVariable("id") Long id) {
        AttributProjetService.deleteAttributProjet(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }









}
