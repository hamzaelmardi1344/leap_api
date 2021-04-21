package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.NatureRisque;
import ma.gfi.leap.api.LEAPAPI.core.services.INatureRisqueService;
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
public class NatureRisqueController {

    @Autowired
    private INatureRisqueService NatureRisqueService;

    //Fetches NatureRisque by id
    @GetMapping(value= "/natureRisque/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<NatureRisque> getNatureRisqueById(@PathVariable("id") Long id) {
        NatureRisque ob = new NatureRisque();
        BeanUtils.copyProperties(NatureRisqueService.getNatureRisqueById(id), ob);
        return new ResponseEntity<NatureRisque>(ob, HttpStatus.OK);
    }



    //Fetches all NatureRisques
    @GetMapping(value= "/natureRisque/listNatureRisque", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<NatureRisque>> getAllNatureRisques() {
        Collection<NatureRisque> NatureRisqueList = NatureRisqueService.getAllNatureRisques();

        return new ResponseEntity<>(NatureRisqueList, HttpStatus.OK);
    }

    //Creates a new NatureRisque
    @PostMapping(value= "/natureRisque/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public NatureRisque addNatureRisque(@RequestBody NatureRisque NatureRisque, UriComponentsBuilder builder) {
        NatureRisque NatureRisque1 = NatureRisqueService.addNatureRisque(NatureRisque);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/NatureRisque/{id}").buildAndExpand(NatureRisque1.getId()).toUri());
        return NatureRisque1;
    }



    @PutMapping("/natureRisque/edit/{id}")
    public ResponseEntity<NatureRisque> updateNatureRisque(@PathVariable(value = "id") Long NatureRisqueId,
                                                  @RequestBody NatureRisque NatureRisqueDetails) throws Exception{
        NatureRisque NatureRisque = NatureRisqueService.getNatureRisqueById(NatureRisqueId);

        NatureRisque.setValeur(NatureRisqueDetails.getValeur());
        NatureRisque.setCode(NatureRisqueDetails.getCode());


        final NatureRisque updatedNatureRisque = NatureRisqueService.addNatureRisque(NatureRisque);
        return ResponseEntity.ok(updatedNatureRisque);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "natureRisque/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteNatureRisque(@PathVariable("id") Long id) {
        NatureRisqueService.deleteNatureRisque(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
