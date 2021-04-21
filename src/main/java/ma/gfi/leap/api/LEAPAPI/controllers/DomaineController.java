package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Domaine;
import ma.gfi.leap.api.LEAPAPI.core.services.IDomaineService;
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
public class DomaineController {

    @Autowired
    private IDomaineService DomaineService;



    //Fetches Domaine by id
    @GetMapping(value= "/domaine/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Domaine> getDomaineById(@PathVariable("id") Long id) {
        Domaine ob = new Domaine();
        BeanUtils.copyProperties(DomaineService.getDomaineById(id), ob);
        return new ResponseEntity<Domaine>(ob, HttpStatus.OK);
    }



    //Fetches all Domaines
    @GetMapping(value= "/domaine/listDomaine", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Domaine>> getAllDomaines() {
        Collection<Domaine> DomaineList = DomaineService.getAllDomaines();

        return new ResponseEntity<>(DomaineList, HttpStatus.OK);
    }

    //Creates a new Domaine
    @PostMapping(value= "/domaine/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Domaine addDomaine(@RequestBody Domaine Domaine, UriComponentsBuilder builder) {
        Domaine Domaine1 = DomaineService.addDomaine(Domaine);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Domaine/{id}").buildAndExpand(Domaine1.getId()).toUri());
        return Domaine1;
    }


    //Updates evenmement
    @PutMapping("/domaine/edit/{id}")
    public ResponseEntity<Domaine> updateDomaine(@PathVariable(value = "id") Long DomaineId,
                                                 @Valid @RequestBody Domaine DomaineDetails) throws Exception{
        Domaine Domaine = DomaineService.getDomaineById(DomaineId);

        Domaine.setValeur(DomaineDetails.getValeur());


        final Domaine updatedDomaine = DomaineService.addDomaine(Domaine);
        return ResponseEntity.ok(updatedDomaine);
    }
    //Deletes evenemnt by id
    @DeleteMapping(value= "/domaine/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteDomaine(@PathVariable("id") Long id) {
        DomaineService.deleteDomaine(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
