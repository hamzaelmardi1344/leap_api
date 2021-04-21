package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.*;
import ma.gfi.leap.api.LEAPAPI.core.services.IProgrammeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class ProgrammeController {

    @Autowired
    private IProgrammeService ProgrammeService;



    //Fetches Programme by id
    @GetMapping(value= "/programme/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Programme> getProgrammeById(@PathVariable("id") Long id) {
        Programme ob = new Programme();
        BeanUtils.copyProperties(ProgrammeService.getProgrammeById(id), ob);
        return new ResponseEntity<Programme>(ob, HttpStatus.OK);
    }



    //Fetches all Programmes
    @GetMapping(value= "/programme/listProgramme", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Programme>> getAllProgrammes() {
        Collection<Programme> ProgrammeList = ProgrammeService.getAllProgrammes();

        return new ResponseEntity<>(ProgrammeList, HttpStatus.OK);
    }

    //Creates a new Programme
    @PostMapping(value= "/programme/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Programme addProgramme(@RequestBody Programme Programme, UriComponentsBuilder builder) {
        Programme Programme1 = ProgrammeService.addProgramme(Programme);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Programme/{id}").buildAndExpand(Programme1.getId()).toUri());
        return Programme1;
    }


   //Updates evenmement
    @PutMapping("/programme/edit/{id}")
    public ResponseEntity<Programme> updateProgramme(@PathVariable(value = "id") Long ProgrammeId,
                                                 @Valid @RequestBody Programme ProgrammeDetails) throws Exception{
        Programme Programme = ProgrammeService.getProgrammeById(ProgrammeId);

        Programme.setLastModifieddate(ProgrammeDetails.getLastModifieddate());
        Programme.setLastmodifieBy(ProgrammeDetails.getLastmodifieBy());
        Programme.setCreatedBy(ProgrammeDetails.getCreatedBy());
        Programme.setCreatedate(ProgrammeDetails.getCreatedate());
        Programme.setRisques(ProgrammeDetails.getRisques());
        Programme.setProjets(ProgrammeDetails.getProjets());
        Programme.setNom(ProgrammeDetails.getNom());
        Programme.setListValeurAttribut2(ProgrammeDetails.getListValeurAttribut2());
        Programme.setAlerte(ProgrammeDetails.getAlerte());
        Programme.setEtat(ProgrammeDetails.getEtat());
        Programme.setDescription(ProgrammeDetails.getDescription());
        Programme.setAvancementTheorique(ProgrammeDetails.getAvancementTheorique());
        Programme.setAttributs(ProgrammeDetails.getAttributs());
        Programme.setAvancement(ProgrammeDetails.getAvancement());
        Programme.setProgrammePrive(ProgrammeDetails.getProgrammePrive());



        final Programme updatedProgramme = ProgrammeService.addProgramme(Programme);
        return ResponseEntity.ok(updatedProgramme);
    }

    //Deletes evenemnt by id
    @DeleteMapping(value= "/programme/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteProgramme(@PathVariable("id") Long id) {
        ProgrammeService.deleteProgramme(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



    @GetMapping(value = "/programme/{id}/attributs")
    public ResponseEntity<Collection<Attribut>> getListAttributByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<Attribut> Attributs = ProgrammeService.getListAttributeByProgramme(id);
        return  new ResponseEntity<Collection<Attribut>>(Attributs,HttpStatus.OK);
    }


    @GetMapping(value = "/programme/{id}/attributProgrammes")
    public ResponseEntity<Collection<AttributProgramme>> getListAttributProgrammeByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<AttributProgramme> Attributs = ProgrammeService.getListAttributeProgrammeByProgramme(id);
        return  new ResponseEntity<Collection<AttributProgramme>>(Attributs,HttpStatus.OK);
    }

    @GetMapping(value = "/programme/{id}/projets")
    public ResponseEntity<Collection<Projet>> getListProjetByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<Projet> projets = ProgrammeService.getListProjetByProgramme(id);
        return  new ResponseEntity<Collection<Projet>>(projets,HttpStatus.OK);
    }


    @GetMapping(value = "/programme/{id}/documentaireVFs")
    public ResponseEntity<Collection<DocumentaireVF>> getListDocByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<DocumentaireVF> documentaireVFS = ProgrammeService.getListDocByProgramme(id);
        return  new ResponseEntity<Collection<DocumentaireVF>>(documentaireVFS,HttpStatus.OK);
    }


    @GetMapping(value = "/programme/{id}/fichierJoints")
    public ResponseEntity<Collection<FichierJoint>> getFichierJointByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<FichierJoint> fichierJoints = ProgrammeService.getFichierJointByProgramme(id);
        return  new ResponseEntity<Collection<FichierJoint>>(fichierJoints,HttpStatus.OK);
    }

    @GetMapping(value = "/programme/{id}/actions")
    public ResponseEntity<Collection<Action>> getListActionByProgrammeID(@PathVariable("id") Long id)
    {
            Collection<Action> actions = ProgrammeService.getListActionByProgramme(id);
        return  new ResponseEntity<Collection<Action>>(actions,HttpStatus.OK);
    }

    @GetMapping(value = "/programme/{id}/risques")
    public ResponseEntity<Collection<Risque>> getListRisqueByProgrammeID(@PathVariable("id") Long id)
    {
        Collection<Risque> risques = ProgrammeService.getListRisqueByProgramme(id);
        return  new ResponseEntity<Collection<Risque>>(risques,HttpStatus.OK);
    }




    @PostMapping(value = "/programme/add/{id}/documentaires")
    public boolean addDocToProgramme(@PathVariable("id") Long id,@RequestBody DocumentaireVF DocumentaireVF)
    {
        return  ProgrammeService.addDocToProgramme(DocumentaireVF,id);
    }


    @GetMapping(value = "/programmes/byAccess")
    public Collection<Programme> findProgByAccess()
    {
        return  ProgrammeService.findProgByPublicAccess();
    }





}
