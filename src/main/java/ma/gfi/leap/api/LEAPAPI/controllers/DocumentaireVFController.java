package ma.gfi.leap.api.LEAPAPI.controllers;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;
import ma.gfi.leap.api.LEAPAPI.core.services.IDocumentaireVFService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class DocumentaireVFController {

    @Autowired
    private IDocumentaireVFService DocumentaireVFService;



    //Fetches DocumentaireVF by id
    @GetMapping(value= "/documentaireVF/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DocumentaireVF> getDocumentaireVFById(@PathVariable("id") Long id) {
        DocumentaireVF ob = new DocumentaireVF();
        BeanUtils.copyProperties(DocumentaireVFService.getDocumentaireVFById(id), ob);
        return new ResponseEntity<DocumentaireVF>(ob, HttpStatus.OK);
    }



    //Fetches all DocumentaireVFs
    @GetMapping(value= "/documentaireVF/listDocumentaireVF", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<DocumentaireVF>> getAllDocumentaireVFs() {
        Collection<DocumentaireVF> DocumentaireVFList = DocumentaireVFService.getAllDocumentaireVFs();



        return new ResponseEntity<Collection<DocumentaireVF>>(DocumentaireVFList, HttpStatus.OK);
    }

    //Fetches all DocumentaireVFs
    @GetMapping(value= "/documentaireVF/listDocumentaireVFWithParentID", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<DocumentaireVF>> getAllDocumentaireVFWithNullParents() {
        Collection<DocumentaireVF> DocumentaireVFList = DocumentaireVFService.getDocListByParentId();
        return new ResponseEntity<Collection<DocumentaireVF>>(DocumentaireVFList, HttpStatus.OK);
    }

    //Creates a new DocumentaireVF
    @PostMapping(value= "/documentaireVF/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public DocumentaireVF addDocumentaireVF(@RequestBody DocumentaireVF DocumentaireVF, UriComponentsBuilder builder) {
        DocumentaireVF DocumentaireVF1 = DocumentaireVFService.addDocumentaireVF(DocumentaireVF);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/DocumentaireVF/{id}").buildAndExpand(DocumentaireVF1.getId()).toUri());
        return DocumentaireVF1;
    }


    //Updates evenmement
    @PutMapping("/documentaireVF/edit/{id}")
    public ResponseEntity<DocumentaireVF> updateDocumentaireVF(@PathVariable(value = "id") Long DocumentaireVFId,
                                                 @Valid @RequestBody DocumentaireVF DocumentaireVFDetails) throws Exception{
        DocumentaireVF DocumentaireVF = DocumentaireVFService.getDocumentaireVFById(DocumentaireVFId);

        try {

            Path sourcePath = Paths.get("/var/www/docs/"+DocumentaireVF.getChemin()+"/");
            DocumentaireVF.setLabel(DocumentaireVFDetails.getLabel());
            DocumentaireVF.setCode(DocumentaireVFDetails.getCode());
            DocumentaireVF.setDocumentaireVF(DocumentaireVFDetails.getDocumentaireVF());
            DocumentaireVF.setChildren(DocumentaireVFDetails.getChildren());
            DocumentaireVF.setIdParent(DocumentaireVFDetails.getIdParent());
            DocumentaireVF.setType(DocumentaireVFDetails.getType());
            DocumentaireVF.setFichierJoints(DocumentaireVFDetails.getFichierJoints());
            DocumentaireVF.setChemin(DocumentaireVFDetails.getChemin());
            Path targetPath = Paths.get("/var/www/docs/"+DocumentaireVFDetails.getChemin()+"/");
            Files.move(sourcePath,targetPath);
            System.out.println("Directory updated!");
            DocumentaireVFService.updateDocumentaireVF(DocumentaireVF);

            //Files.createDirectory(path);



        } catch (IOException e) {
            System.err.println("Failed to update directory!" + e.getMessage());
        }



     //   DocumentaireVF.setNom(DocumentaireVFDetails.getNom());




        final DocumentaireVF updatedDocumentaireVF = DocumentaireVFService.addDocumentaireVF(DocumentaireVF);
        return ResponseEntity.ok(updatedDocumentaireVF);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "/documentaireVF/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteDocumentaireVF(@PathVariable("id") Long id) throws IOException {
        //Files.deleteIfExists(Paths.get(KhabeerConfig.PATH_REF_EVENT_GEN +DocumentaireVF.getValeur()));
        DocumentaireVFService.deleteDocumentaireVF(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



    @GetMapping(value = "/documentaireVF/{id}/fichierJoints")
    public ResponseEntity<Collection<FichierJoint>> getListFichierJointByProjetID(@PathVariable("id") Long id)
    {
        Collection<FichierJoint> FichierJoints = DocumentaireVFService.getFileByDocumentID(id);
        return  new ResponseEntity<Collection<FichierJoint>>(FichierJoints,HttpStatus.OK);
    }



    @GetMapping(value = "/documentaireVF/{id}/children")
    public ResponseEntity<Collection<DocumentaireVF>> getChildByParent(@PathVariable("id") Long id)
    {
        Collection<DocumentaireVF> children = DocumentaireVFService.getChildByDocumentParentID(id);
        return  new ResponseEntity<Collection<DocumentaireVF>>(children,HttpStatus.OK);
    }


    @GetMapping(value = "/documentaireVF/list/{niveau}")
    public ResponseEntity<Collection<DocumentaireVF>> getByNiveau(@PathVariable("niveau") String niveau)
    {
        Collection<DocumentaireVF> documentaireVFS = DocumentaireVFService.getByNiveau(niveau);
        return  new ResponseEntity<Collection<DocumentaireVF>>(documentaireVFS,HttpStatus.OK);
    }

    @GetMapping(value = "/documentaireVF/list/{niveau}/{id}")
    public ResponseEntity<Collection<DocumentaireVF>> getByNiveauAndIdParent(@PathVariable("niveau") String niveau,@PathVariable("id") Long id)
    {
        Collection<DocumentaireVF> documentaireVFS = DocumentaireVFService.getByNiveauAndIdParent(niveau,id);
        return  new ResponseEntity<Collection<DocumentaireVF>>(documentaireVFS,HttpStatus.OK);
    }





    @PostMapping(value = "/documentaireVF/add/{id}/children")
    public boolean addDocChildren(@PathVariable("id") Long id,@RequestBody DocumentaireVF DocumentaireVF)
    {
        return  DocumentaireVFService.addDocChildren(DocumentaireVF,id);
    }


    @PostMapping(value = "/documentaireVF/add/{id}/fichierJoint")
    public boolean addFileToDoc(@PathVariable("id") Long id,@RequestBody FichierJoint fichierJoint)
    {
        return  DocumentaireVFService.addFileToDoc(fichierJoint,id);
    }


    @GetMapping(value = "/documentaireVF/getByLabel/{label}")
    public DocumentaireVF getDocByLabel(@PathVariable(name = "label") String label)
    {
        DocumentaireVF documentaireVF = DocumentaireVFService.getDocByLabel(label);

        return documentaireVF;
    }


    //Fetches all DocumentaireVFs
    @GetMapping(value= "/documentaireVF/listDocumentaireVFFiles", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<DocumentaireVF>> getAllDocumentaireVFFiles() {
        Collection<DocumentaireVF> DocumentaireVFList = DocumentaireVFService.getAllDocumentaireVFFiles();
        return new ResponseEntity<Collection<DocumentaireVF>>(DocumentaireVFList, HttpStatus.OK);
    }


}
