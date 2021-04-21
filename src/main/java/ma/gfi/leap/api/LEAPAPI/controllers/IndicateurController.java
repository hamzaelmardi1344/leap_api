package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Indicateur;
import ma.gfi.leap.api.LEAPAPI.core.services.IIndicateurService;
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
@RequestMapping("api")
@CrossOrigin("*")
public class IndicateurController {

    @Autowired
    private IIndicateurService IndicateurService;



    //Fetches Indicateur by id
    @GetMapping(value= "/indicateur/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Indicateur> getIndicateurById(@PathVariable("id") Long id) {
        Indicateur ob = new Indicateur();
        BeanUtils.copyProperties(IndicateurService.getIndicateurById(id), ob);
        return new ResponseEntity<Indicateur>(ob, HttpStatus.OK);
    }



    //Fetches all Indicateurs
    @GetMapping(value= "/indicateur/listIndicateur", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Indicateur>> getAllIndicateurs() {
        Collection<Indicateur> IndicateurList = IndicateurService.getAllIndicateurs();

        return new ResponseEntity<>(IndicateurList, HttpStatus.OK);
    }

    //Creates a new Indicateur
    @PostMapping(value= "/indicateur/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Indicateur addIndicateur(@RequestBody Indicateur Indicateur, UriComponentsBuilder builder) {
        Indicateur Indicateur1 = IndicateurService.addIndicateur(Indicateur);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Indicateur/{id}").buildAndExpand(Indicateur1.getId()).toUri());
        return Indicateur1;
    }


   //Updates evenmement
    @PutMapping("/indicateur/edit/{id}")
    public ResponseEntity<Indicateur> updateIndicateur(@PathVariable(value = "id") Long IndicateurId,
                                                 @Valid @RequestBody Indicateur IndicateurDetails) throws Exception{
        Indicateur Indicateur = IndicateurService.getIndicateurById(IndicateurId);

        Indicateur.setCible(IndicateurDetails.getCible());
        Indicateur.setIndicateur(IndicateurDetails.getIndicateur());
        Indicateur.setRealisation(IndicateurDetails.getRealisation());


        final Indicateur updatedIndicateur = IndicateurService.addIndicateur(Indicateur);
        return ResponseEntity.ok(updatedIndicateur);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "/indicateur/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteIndicateur(@PathVariable("id") Long id) {
        IndicateurService.deleteIndicateur(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
