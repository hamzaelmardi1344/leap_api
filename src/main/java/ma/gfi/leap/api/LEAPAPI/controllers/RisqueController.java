package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;
import ma.gfi.leap.api.LEAPAPI.core.services.IRisqueService;
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
public class RisqueController {

    @Autowired
    private IRisqueService RisqueService;



    //Fetches Risque by id
    @GetMapping(value= "/risque/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Risque> getRisqueById(@PathVariable("id") Long id) {
        Risque ob = new Risque();
        BeanUtils.copyProperties(RisqueService.getRisqueById(id), ob);
        return new ResponseEntity<Risque>(ob, HttpStatus.OK);
    }



    //Fetches all Risques
    @GetMapping(value= "/risque/listRisque", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Risque>> getAllRisques() {
        Collection<Risque> RisqueList = RisqueService.getAllRisques();

        return new ResponseEntity<>(RisqueList, HttpStatus.OK);
    }

    //Creates a new Risque
    @PostMapping(value= "/risque/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Risque addRisque(@RequestBody Risque Risque, UriComponentsBuilder builder) {
        Risque Risque1 = RisqueService.addRisque(Risque);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Risque/{id}").buildAndExpand(Risque1.getId()).toUri());
        return Risque1;
    }


  /*  //Updates evenmement
    @PutMapping("/Risque/edit/{id}")
    public ResponseEntity<Risque> updateRisque(@PathVariable(value = "id") Long RisqueId,
                                                 @Valid @RequestBody Risque RisqueDetails) throws Exception{
        Risque Risque = RisqueService.getRisqueById(RisqueId);

        Risque.setValeur(RisqueDetails.getValeur());


        final Risque updatedRisque = RisqueService.addRisque(Risque);
        return ResponseEntity.ok(updatedRisque);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/risque/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteRisque(@PathVariable("id") Long id) {
        RisqueService.deleteRisque(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
