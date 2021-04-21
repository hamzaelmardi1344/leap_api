package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Perimetre;
import ma.gfi.leap.api.LEAPAPI.core.services.IPerimetreService;
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
public class PerimetreController {

    @Autowired
    private IPerimetreService PerimetreService;



    //Fetches Perimetre by id
    @GetMapping(value= "/perimetre/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Perimetre> getPerimetreById(@PathVariable("id") Long id) {
        Perimetre ob = new Perimetre();
        BeanUtils.copyProperties(PerimetreService.getPerimetreById(id), ob);
        return new ResponseEntity<Perimetre>(ob, HttpStatus.OK);
    }



    //Fetches all Perimetres
    @GetMapping(value= "/perimetre/listPerimetre", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Perimetre>> getAllPerimetres() {
        Collection<Perimetre> PerimetreList = PerimetreService.getAllPerimetres();

        return new ResponseEntity<>(PerimetreList, HttpStatus.OK);
    }

    //Creates a new Perimetre
    @PostMapping(value= "/perimetre/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Perimetre addPerimetre(@RequestBody Perimetre Perimetre, UriComponentsBuilder builder) {
        Perimetre Perimetre1 = PerimetreService.addPerimetre(Perimetre);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Perimetre/{id}").buildAndExpand(Perimetre1.getId()).toUri());
        return Perimetre1;
    }


  /*  //Updates evenmement
    @PutMapping("/Perimetre/edit/{id}")
    public ResponseEntity<Perimetre> updatePerimetre(@PathVariable(value = "id") Long PerimetreId,
                                                 @Valid @RequestBody Perimetre PerimetreDetails) throws Exception{
        Perimetre Perimetre = PerimetreService.getPerimetreById(PerimetreId);

        Perimetre.setValeur(PerimetreDetails.getValeur());


        final Perimetre updatedPerimetre = PerimetreService.addPerimetre(Perimetre);
        return ResponseEntity.ok(updatedPerimetre);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/perimetre/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deletePerimetre(@PathVariable("id") Long id) {
        PerimetreService.deletePerimetre(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
