package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Criticite;
import ma.gfi.leap.api.LEAPAPI.core.services.ICriticiteService;
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
public class CriticiteController {

    @Autowired
    private ICriticiteService CriticiteService;



    //Fetches Criticite by id
    @GetMapping(value= "/criticite/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Criticite> getCriticiteById(@PathVariable("id") Long id) {
        Criticite ob = new Criticite();
        BeanUtils.copyProperties(CriticiteService.getCriticiteById(id), ob);
        return new ResponseEntity<Criticite>(ob, HttpStatus.OK);
    }



    //Fetches all Criticites
    @GetMapping(value= "/criticite/listCriticite", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Criticite>> getAllCriticites() {
        Collection<Criticite> CriticiteList = CriticiteService.getAllCriticites();

        return new ResponseEntity<>(CriticiteList, HttpStatus.OK);
    }

    //Creates a new Criticite
    @PostMapping(value= "/criticite/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Criticite addCriticite(@RequestBody Criticite Criticite, UriComponentsBuilder builder) {
        Criticite Criticite1 = CriticiteService.addCriticite(Criticite);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Criticite/{id}").buildAndExpand(Criticite1.getId()).toUri());
        return Criticite1;
    }


  /*  //Updates evenmement
    @PutMapping("/Criticite/edit/{id}")
    public ResponseEntity<Criticite> updateCriticite(@PathVariable(value = "id") Long CriticiteId,
                                                 @Valid @RequestBody Criticite CriticiteDetails) throws Exception{
        Criticite Criticite = CriticiteService.getCriticiteById(CriticiteId);

        Criticite.setValeur(CriticiteDetails.getValeur());


        final Criticite updatedCriticite = CriticiteService.addCriticite(Criticite);
        return ResponseEntity.ok(updatedCriticite);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/criticite/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteCriticite(@PathVariable("id") Long id) {
        CriticiteService.deleteCriticite(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
