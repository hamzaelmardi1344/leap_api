package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Action;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;
import ma.gfi.leap.api.LEAPAPI.core.services.IRefAttributService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Ref;
import java.util.Collection;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class RefAttributController {

    @Autowired
    private IRefAttributService RefAttributService;



    //Fetches RefAttribut by id
    @GetMapping(value= "/refAttribut/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RefAttribut> getRefAttributById(@PathVariable("id") Long id) {
        RefAttribut ob = new RefAttribut();
        BeanUtils.copyProperties(RefAttributService.getRefAttributById(id), ob);
        return new ResponseEntity<RefAttribut>(ob, HttpStatus.OK);
    }



    //Fetches all RefAttributs
    @GetMapping(value= "/refAttribut/listRefAttribut", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<RefAttribut>> getAllRefAttributs() {
        Collection<RefAttribut> RefAttributList = RefAttributService.getAllRefAttributs();

        return new ResponseEntity<>(RefAttributList, HttpStatus.OK);
    }

    //Creates a new RefAttribut
    @PostMapping(value= "/refAttribut/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public RefAttribut addRefAttribut(@RequestBody RefAttribut RefAttribut, UriComponentsBuilder builder) {
        RefAttribut RefAttribut1 = RefAttributService.addRefAttribut(RefAttribut);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/RefAttribut/{id}").buildAndExpand(RefAttribut1.getId()).toUri());
        return RefAttribut1;
    }



    @PutMapping("/refAttribut/edit/{id}")
    public ResponseEntity<RefAttribut> updateRefAttribut(@PathVariable(value = "id") Long RefAttributId,
                                                  @RequestBody RefAttribut RefAttributDetails) throws Exception{
        RefAttribut RefAttribut = RefAttributService.getRefAttributById(RefAttributId);

        RefAttribut.setValeur(RefAttributDetails.getValeur());



        final RefAttribut updatedRefAttribut = RefAttributService.addRefAttribut(RefAttribut);
        return ResponseEntity.ok(updatedRefAttribut);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "refAttribut/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteRefAttribut(@PathVariable("id") Long id) {
        RefAttributService.deleteRefAttribut(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "refAttribut/getByValeur/{valeur}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public RefAttribut getRefAttributByValeur(@PathVariable("valeur") String valeur)
    {

        return  RefAttributService.getRefAttributByValeur(valeur);
    }


    @GetMapping(value = "/refAttribut/{id}/listRefValeurAttribut")
    public ResponseEntity<Collection<RefValeurAttribut>> getListByRefValeur(@PathVariable("id") Long id)
    {
        Collection<RefValeurAttribut> refValeurAttributs = RefAttributService.getListByRefAttribut(id);
        return  new ResponseEntity<Collection<RefValeurAttribut>>(refValeurAttributs,HttpStatus.OK);
    }





}
