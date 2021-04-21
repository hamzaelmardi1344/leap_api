package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.config.LEAPFileConfig;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.services.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class FichierJointController {

    @Autowired
    private IFichierJointService FichierJointService;

    @Autowired
    private IDocumentaireVFService documentaireService;



    //Fetches FichierJoint by id
    @GetMapping(value= "/fichierJoint/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<FichierJoint> getFichierJointById(@PathVariable("id") Long id) {
        FichierJoint ob = new FichierJoint();
        BeanUtils.copyProperties(FichierJointService.getFichierJointById(id), ob);
        return new ResponseEntity<FichierJoint>(ob, HttpStatus.OK);
    }



    //Fetches all FichierJoints
    @GetMapping(value= "/fichierJoint/listFichierJoint", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<FichierJoint>> getAllFichierJoints() {
        Collection<FichierJoint> fichierJointList = FichierJointService.getAllFichierJoints();

        return new ResponseEntity<>(fichierJointList, HttpStatus.OK);
    }

    //Creates a new FichierJoint
    @PostMapping(value= "/fichierJoint/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public FichierJoint addFichierJoint(@RequestBody FichierJoint FichierJoint, UriComponentsBuilder builder) {
        FichierJoint fichierJoint1 = FichierJointService.addFichierJoint(FichierJoint);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/FichierJoint/{id}").buildAndExpand(FichierJoint1.getId()).toUri());
        return fichierJoint1;
    }


  /*  //Updates evenmement
    @PutMapping("/FichierJoint/edit/{id}")
    public ResponseEntity<FichierJoint> updateFichierJoint(@PathVariable(value = "id") Long FichierJointId,
                                                 @Valid @RequestBody FichierJoint FichierJointDetails) throws Exception{
        FichierJoint FichierJoint = FichierJointService.getFichierJointById(FichierJointId);

        FichierJoint.setValeur(FichierJointDetails.getValeur());


        final FichierJoint updatedFichierJoint = FichierJointService.addFichierJoint(FichierJoint);
        return ResponseEntity.ok(updatedFichierJoint);
    }
*/
    //Deletes evenemnt by id
    @DeleteMapping(value= "/fichierJoint/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteFichierJoint(@PathVariable("id") Long id) throws IOException {
        FichierJoint fichierJoint = FichierJointService.getFichierJointById(id);
        Files.deleteIfExists(Paths.get(fichierJoint.getCheminFichier()+ fichierJoint.getOriginalName()));


        //Files.deleteIfExists(Paths.get(KhabeerConfig.PATH_REF_EVENT_GEN +fichierJoint.getValeur()));
        FichierJointService.deleteFichierJoint(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value="/fichierJoint/uploadDoc/{id}")
    public FichierJoint uploadDocumentaireFileNiveau1(MultipartFile file, @PathVariable Long id) throws IOException
    {

        DocumentaireVF documentaire =documentaireService.getDocumentaireVFById(id);
        FichierJoint fichierJoint = new FichierJoint();
        fichierJoint.setTaille(file.getSize()/1024);
        fichierJoint.setOriginalName(documentaire.getId()+"_"+file.getOriginalFilename());
        documentaire.setLabel(fichierJoint.getOriginalName());
        System.err.println(documentaire.getLabel());
        fichierJoint.setDocumentaireVF(documentaire);
        System.err.println(documentaire.getFichierJoints());
        fichierJoint.setCheminFichier("/var/www/docs/"+documentaire.getChemin()+"/");
        Files.write(Paths.get(fichierJoint.getCheminFichier()+ fichierJoint.getOriginalName()),file.getBytes());

        System.out.println(fichierJoint.getCheminFichier());
        FichierJointService.addFichierJoint(fichierJoint);
        documentaireService.addFileToDoc(fichierJoint,documentaire.getId());

        return fichierJoint;

    }

    @PostMapping(value="/fichierJoint/uploadDocForForm/{id}")
    public FichierJoint uploadDocumentaire1(MultipartFile file, @PathVariable Long id) throws IOException
    {

        DocumentaireVF documentaire =documentaireService.getDocumentaireVFById(id);
        FichierJoint fichierJoint = new FichierJoint();
        fichierJoint.setTaille(file.getSize()/1024);
        fichierJoint.setOriginalName(documentaire.getId()+"_"+file.getOriginalFilename());
        System.err.println(documentaire.getLabel());
        fichierJoint.setDocumentaireVF(documentaire);
        System.err.println(documentaire.getFichierJoints());
        fichierJoint.setCheminFichier("/var/www/docs/"+documentaire.getChemin()+"/");
        Files.write(Paths.get(fichierJoint.getCheminFichier()+ fichierJoint.getOriginalName()),file.getBytes());

        System.out.println(fichierJoint.getCheminFichier());
        FichierJointService.addFichierJoint(fichierJoint);
        documentaireService.addFileToDoc(fichierJoint,documentaire.getId());

        return fichierJoint;

    }



    @GetMapping(path = "fichierJoint/{id}",produces =MediaType.APPLICATION_PDF_VALUE)
    public byte[] getFile(@PathVariable("id") Long id) throws IOException
    {
        FichierJoint fichierJoint = FichierJointService.getFichierJointById(id);
        return Files.readAllBytes(Paths.get(fichierJoint.getCheminFichier()+ fichierJoint.getOriginalName()));

        //return Files.readAllBytes(Paths.get("/var/www/docs/"+"/uploadedFile/Evenement/DetailsEvenement/"+fichierJoint.getValeur()));
    }












}
