package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Categorie;
import ma.gfi.leap.api.LEAPAPI.core.services.ICategorieService;
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
public class CategorieController {

    @Autowired
    private ICategorieService CategorieService;



    //Fetches Categorie by id
    @GetMapping(value= "/categorie/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") Long id) {
        Categorie ob = new Categorie();
        BeanUtils.copyProperties(CategorieService.getCategorieById(id), ob);
        return new ResponseEntity<Categorie>(ob, HttpStatus.OK);
    }



    //Fetches all Categories
    @GetMapping(value= "/categorie/listCategorie", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Categorie>> getAllCategories() {
        Collection<Categorie> CategorieList = CategorieService.getAllCategories();

        return new ResponseEntity<>(CategorieList, HttpStatus.OK);
    }

    //Creates a new Categorie
    @PostMapping(value= "/categorie/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Categorie addCategorie(@RequestBody Categorie Categorie, UriComponentsBuilder builder) {
        Categorie Categorie1 = CategorieService.addCategorie(Categorie);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Categorie/{id}").buildAndExpand(Categorie1.getId()).toUri());
        return Categorie1;
    }


  /*  //Updates evenmement
    @PutMapping("/Categorie/edit/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long CategorieId,
                                                 @Valid @RequestBody Categorie CategorieDetails) throws Exception{
        Categorie Categorie = CategorieService.getCategorieById(CategorieId);

        Categorie.setValeur(CategorieDetails.getValeur());


        final Categorie updatedCategorie = CategorieService.addCategorie(Categorie);
        return ResponseEntity.ok(updatedCategorie);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/categorie/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteCategorie(@PathVariable("id") Long id) {
        CategorieService.deleteCategorie(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    


 


}
