package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;
import ma.gfi.leap.api.LEAPAPI.core.services.IAttributProgrammeService;
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
public class AttributProgrammeController {

    @Autowired
    private IAttributProgrammeService AttributProgrammeService;



    //Fetches AttributProgramme by id
    @GetMapping(value= "/attributProgramme/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<AttributProgramme> getAttributProgrammeById(@PathVariable("id") Long id) {
        AttributProgramme ob = new AttributProgramme();
        BeanUtils.copyProperties(AttributProgrammeService.getAttributProgrammeById(id), ob);
        return new ResponseEntity<AttributProgramme>(ob, HttpStatus.OK);
    }

    //Fetches AttributProgramme by id
    @GetMapping(value= "/attributProgramme/getByValeur/{valeur}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<AttributProgramme> getAttributProgrammeByValeur(@PathVariable("valeur") String valeur) {
        AttributProgramme ob = new AttributProgramme();
        BeanUtils.copyProperties(AttributProgrammeService.findByValeur(valeur), ob);
        return new ResponseEntity<AttributProgramme>(ob, HttpStatus.OK);
    }



    //Fetches all AttributProgrammes
        @GetMapping(value= "/attributProgramme/getlistAttributProgramme/{valeur}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<AttributProgramme>> getAllAttributProgrammesByValeur(@PathVariable(name = "valeur") String valeur) {
        Collection<AttributProgramme> AttributProgrammeList = AttributProgrammeService.findAllByValeur(valeur);

        return new ResponseEntity<>(AttributProgrammeList, HttpStatus.OK);
    }

    //Fetches all AttributProgrammes
    @GetMapping(value= "/attributProgramme/listAttributProgramme", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<AttributProgramme>> getAllAttributProgrammes() {
        Collection<AttributProgramme> AttributProgrammeList = AttributProgrammeService.getAllAttributProgrammes();

        return new ResponseEntity<>(AttributProgrammeList, HttpStatus.OK);
    }

    //Creates a new AttributProgramme
    @PostMapping(value= "/attributProgramme/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public AttributProgramme addAttributProgramme(@RequestBody AttributProgramme AttributProgramme, UriComponentsBuilder builder) {
        AttributProgramme AttributProgramme1 = AttributProgrammeService.addAttributProgramme(AttributProgramme);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/AttributProgramme/{id}").buildAndExpand(AttributProgramme1.getId()).toUri());
        return AttributProgramme1;
    }


  /*  //Updates evenmement
    @PutMapping("/AttributProgramme/edit/{id}")
    public ResponseEntity<AttributProgramme> updateAttributProgramme(@PathVariable(value = "id") Long AttributProgrammeId,
                                                 @Valid @RequestBody AttributProgramme AttributProgrammeDetails) throws Exception{
        AttributProgramme AttributProgramme = AttributProgrammeService.getAttributProgrammeById(AttributProgrammeId);

        AttributProgramme.setValeur(AttributProgrammeDetails.getValeur());


        final AttributProgramme updatedAttributProgramme = AttributProgrammeService.addAttributProgramme(AttributProgramme);
        return ResponseEntity.ok(updatedAttributProgramme);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/attributProgramme/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteAttributProgramme(@PathVariable("id") Long id) {
        AttributProgrammeService.deleteAttributProgramme(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
