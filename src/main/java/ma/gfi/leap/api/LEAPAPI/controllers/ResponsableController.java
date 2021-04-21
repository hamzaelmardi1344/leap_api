package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Responsable;
import ma.gfi.leap.api.LEAPAPI.core.services.IResponsableService;
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
public class ResponsableController {

    @Autowired
    private IResponsableService ResponsableService;



    //Fetches Responsable by id
    @GetMapping(value= "/responsable/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Responsable> getResponsableById(@PathVariable("id") Long id) {
        Responsable ob = new Responsable();
        BeanUtils.copyProperties(ResponsableService.getResponsableById(id), ob);
        return new ResponseEntity<Responsable>(ob, HttpStatus.OK);
    }



    //Fetches all Responsables
    @GetMapping(value= "/responsable/listResponsable", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Responsable>> getAllResponsables() {
        Collection<Responsable> ResponsableList = ResponsableService.getAllResponsables();

        return new ResponseEntity<>(ResponsableList, HttpStatus.OK);
    }

    //Creates a new Responsable
    @PostMapping(value= "/responsable/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Responsable addResponsable(@RequestBody Responsable Responsable, UriComponentsBuilder builder) {
        Responsable Responsable1 = ResponsableService.addResponsable(Responsable);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Responsable/{id}").buildAndExpand(Responsable1.getId()).toUri());
        return Responsable1;
    }


  /*  //Updates evenmement
    @PutMapping("/Responsable/edit/{id}")
    public ResponseEntity<Responsable> updateResponsable(@PathVariable(value = "id") Long ResponsableId,
                                                 @Valid @RequestBody Responsable ResponsableDetails) throws Exception{
        Responsable Responsable = ResponsableService.getResponsableById(ResponsableId);

        Responsable.setValeur(ResponsableDetails.getValeur());


        final Responsable updatedResponsable = ResponsableService.addResponsable(Responsable);
        return ResponseEntity.ok(updatedResponsable);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/responsable/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteResponsable(@PathVariable("id") Long id) {
        ResponsableService.deleteResponsable(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
