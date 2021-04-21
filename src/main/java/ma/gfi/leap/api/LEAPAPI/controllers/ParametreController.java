package ma.gfi.leap.api.LEAPAPI.controllers;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Parametre;
import ma.gfi.leap.api.LEAPAPI.core.services.IParametreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("api")

public class ParametreController {
    
    
    @Autowired
    private IParametreService parametreService;


    //Fetches Parametre by id
    @GetMapping(value= "/parametre/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Parametre> getParametreById(@PathVariable("id") Long id) {
        Parametre ob = new Parametre();
        BeanUtils.copyProperties(parametreService.getParametreById(id), ob);
        return new ResponseEntity<Parametre>(ob, HttpStatus.OK);
    }


    //Fetches all Parametres
    @GetMapping(value= "/parametres", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Parametre>> getAllParametres() {
        Collection<Parametre> ParametreList = parametreService.getAllParametres();

        return new ResponseEntity<>(ParametreList, HttpStatus.OK);
    }

    //Creates a new Parametre
    @PostMapping(value= "/parametre", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Parametre addParametre(@RequestBody Parametre Parametre, UriComponentsBuilder builder) {
        Parametre Parametre1 = parametreService.addParametre(Parametre);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Parametre/{id}").buildAndExpand(Parametre1.getId()).toUri());
        return Parametre1;
    }


    //Updates evenmement
    @PutMapping("/parametre/{id}")
    public ResponseEntity<Parametre> updateParametre(@PathVariable(value = "id") Long ParametreId,
                                                     @Valid @RequestBody Parametre ParametreDetails) throws Exception{
        Parametre Parametre = parametreService.getParametreById(ParametreId);

        Parametre.setValeur(ParametreDetails.getValeur());


        final Parametre updatedParametre = parametreService.addParametre(Parametre);
        return ResponseEntity.ok(updatedParametre);
    }


    //Deletes evenemnt by id
    @DeleteMapping(value= "/parametre/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteParametre(@PathVariable("id") Long id) {
        parametreService.deleteParametre(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}
