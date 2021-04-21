package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;
import ma.gfi.leap.api.LEAPAPI.core.services.IRefValeurAttributService;
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
public class RefValeurAttributController {

    @Autowired
    private IRefValeurAttributService RefValeurAttributService;



    //Fetches RefValeurAttribut by id
    @GetMapping(value= "/refValeurAttribut/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RefValeurAttribut> getRefValeurAttributById(@PathVariable("id") Long id) {
        RefValeurAttribut ob = new RefValeurAttribut();
        BeanUtils.copyProperties(RefValeurAttributService.getRefValeurAttributById(id), ob);
        return new ResponseEntity<RefValeurAttribut>(ob, HttpStatus.OK);
    }



    //Fetches all RefValeurAttributs
    @GetMapping(value= "/refValeurAttribut/listRefValeurAttribut", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<RefValeurAttribut>> getAllRefValeurAttributs() {
        Collection<RefValeurAttribut> RefValeurAttributList = RefValeurAttributService.getAllRefValeurAttributs();

        return new ResponseEntity<>(RefValeurAttributList, HttpStatus.OK);
    }

    //Creates a new RefValeurAttribut
    @PostMapping(value= "/refValeurAttribut/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public RefValeurAttribut addRefValeurAttribut(@RequestBody RefValeurAttribut RefValeurAttribut, UriComponentsBuilder builder) {
        RefValeurAttribut RefValeurAttribut1 = RefValeurAttributService.addRefValeurAttribut(RefValeurAttribut);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/RefValeurAttribut/{id}").buildAndExpand(RefValeurAttribut1.getId()).toUri());
        return RefValeurAttribut1;
    }



    @PutMapping("/refValeurAttribut/edit/{id}")
    public ResponseEntity<RefValeurAttribut> updateRefValeurAttribut(@PathVariable(value = "id") Long RefValeurAttributId,
                                                  @RequestBody RefValeurAttribut RefValeurAttributDetails) throws Exception{
        RefValeurAttribut RefValeurAttribut = RefValeurAttributService.getRefValeurAttributById(RefValeurAttributId);

        RefValeurAttribut.setValeur(RefValeurAttributDetails.getValeur());



        final RefValeurAttribut updatedRefValeurAttribut = RefValeurAttributService.addRefValeurAttribut(RefValeurAttribut);
        return ResponseEntity.ok(updatedRefValeurAttribut);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "refValeurAttribut/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteRefValeurAttribut(@PathVariable("id") Long id) {
        RefValeurAttributService.deleteRefValeurAttribut(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "refValeurAttribut/getByValeur/{valeur}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public RefValeurAttribut getRefValeurAttributByValeur(@PathVariable("valeur") String valeur)
    {
        
        return  RefValeurAttributService.getRefValeurAttributByValeur(valeur);
    }


 


}
