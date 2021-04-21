package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.TypeRisque;
import ma.gfi.leap.api.LEAPAPI.core.services.ITypeRisqueService;
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
public class TypeRisqueController {

    @Autowired
    private ITypeRisqueService TypeRisqueService;



    //Fetches TypeRisque by id
    @GetMapping(value= "/typeRisque/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<TypeRisque> getTypeRisqueById(@PathVariable("id") Long id) {
        TypeRisque ob = new TypeRisque();
        BeanUtils.copyProperties(TypeRisqueService.getTypeRisqueById(id), ob);
        return new ResponseEntity<TypeRisque>(ob, HttpStatus.OK);
    }



    //Fetches all TypeRisques
    @GetMapping(value= "/typeRisque/listTypeRisque", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<TypeRisque>> getAllTypeRisques() {
        Collection<TypeRisque> TypeRisqueList = TypeRisqueService.getAllTypeRisques();

        return new ResponseEntity<>(TypeRisqueList, HttpStatus.OK);
    }

    //Creates a new TypeRisque
    @PostMapping(value= "/typeRisque/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public TypeRisque addTypeRisque(@RequestBody TypeRisque TypeRisque, UriComponentsBuilder builder) {
        TypeRisque TypeRisque1 = TypeRisqueService.addTypeRisque(TypeRisque);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/TypeRisque/{id}").buildAndExpand(TypeRisque1.getId()).toUri());
        return TypeRisque1;
    }



    @PutMapping("/typeRisque/edit/{id}")
    public ResponseEntity<TypeRisque> updateTypeRisque(@PathVariable(value = "id") Long TypeRisqueId,
                                                  @RequestBody TypeRisque TypeRisqueDetails) throws Exception{
        TypeRisque TypeRisque = TypeRisqueService.getTypeRisqueById(TypeRisqueId);

        TypeRisque.setValeur(TypeRisqueDetails.getValeur());
        TypeRisque.setCode(TypeRisqueDetails.getCode());


        final TypeRisque updatedTypeRisque = TypeRisqueService.addTypeRisque(TypeRisque);
        return ResponseEntity.ok(updatedTypeRisque);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "typeRisque/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteTypeRisque(@PathVariable("id") Long id) {
        TypeRisqueService.deleteTypeRisque(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
