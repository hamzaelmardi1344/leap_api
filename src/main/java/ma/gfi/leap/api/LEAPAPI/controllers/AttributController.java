package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Attribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RevisionProjet;
import ma.gfi.leap.api.LEAPAPI.core.services.IAttributService;
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
public class AttributController {

    @Autowired
    private IAttributService AttributService;



    //Fetches Attribut by id
    @GetMapping(value= "/attribut/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Attribut> getAttributById(@PathVariable("id") Long id) {
        Attribut ob = new Attribut();
        BeanUtils.copyProperties(AttributService.getAttributById(id), ob);
        return new ResponseEntity<Attribut>(ob, HttpStatus.OK);
    }



    //Fetches all Attributs
    @GetMapping(value= "/attribut/listAttribut", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Attribut>> getAllAttributs() {
        Collection<Attribut> AttributList = AttributService.getAllAttributs();

        return new ResponseEntity<>(AttributList, HttpStatus.OK);
    }

    //Creates a new Attribut
    @PostMapping(value= "/attribut/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Attribut addAttribut(@RequestBody Attribut Attribut, UriComponentsBuilder builder) {
        Attribut Attribut1 = AttributService.addAttribut(Attribut);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Attribut/{id}").buildAndExpand(Attribut1.getId()).toUri());
        return Attribut1;
    }


  /*  //Updates evenmement
    @PutMapping("/Attribut/edit/{id}")
    public ResponseEntity<Attribut> updateAttribut(@PathVariable(value = "id") Long AttributId,
                                                 @Valid @RequestBody Attribut AttributDetails) throws Exception{
        Attribut Attribut = AttributService.getAttributById(AttributId);

        Attribut.setValeur(AttributDetails.getValeur());


        final Attribut updatedAttribut = AttributService.addAttribut(Attribut);
        return ResponseEntity.ok(updatedAttribut);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/attribut/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteAttribut(@PathVariable("id") Long id) {
        AttributService.deleteAttribut(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/attribut/{id}/attributProgrammes")
    public ResponseEntity<Collection<AttributProgramme>> getListAttributProgrammeByAttribut(@PathVariable("id") Long id)
    {
        Collection<AttributProgramme> attributProgrammes = AttributService.getAttributProgrammeByAttribut(id);
        return  new ResponseEntity<Collection<AttributProgramme>>(attributProgrammes,HttpStatus.OK);
    }







}
