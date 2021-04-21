package ma.gfi.leap.api.LEAPAPI.controllers;


import ma.gfi.leap.api.LEAPAPI.config.security.jwt.JwtUtils;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.UtilisateurRepository;
import ma.gfi.leap.api.LEAPAPI.core.services.IUtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class UtilisateurController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private IUtilisateurService utilisateurService;
    public static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);


    //Fetches Utilisateur by id
    @GetMapping(value = "/utilisateur/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        Utilisateur ob = new Utilisateur();
        BeanUtils.copyProperties(utilisateurService.getUtilisateurById(id), ob);
        return new ResponseEntity<Utilisateur>(ob, HttpStatus.OK);
    }


    //Fetches all Utilisateurs
    @GetMapping(value = "/utilisateurs", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Utilisateur>> getAllUtilisateurs() {
        Collection<Utilisateur> UtilisateurList = utilisateurService.getAllUtilisateurs();

        return new ResponseEntity<>(UtilisateurList, HttpStatus.OK);
    }

    //Creates a new Utilisateur
    @PostMapping(value = "/utilisateur/creation", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Utilisateur addUtilisateur(@RequestBody Utilisateur Utilisateur, UriComponentsBuilder builder) {
        Utilisateur Utilisateur1 = utilisateurService.addUtilisateur(Utilisateur);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Utilisateur/{id}").buildAndExpand(Utilisateur1.getId()).toUri());
        return Utilisateur1;
    }


    //Updates
    @PutMapping("/utilisateur/edit/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long UtilisateurId,
                                                                   @Valid @RequestBody Utilisateur UtilisateurDetails) throws Exception {
        Utilisateur Utilisateur = utilisateurService.getUtilisateurById(UtilisateurId);

        Utilisateur.setUsername(UtilisateurDetails.getUsername());
        Utilisateur.setPassword(UtilisateurDetails.getPassword());
        Utilisateur.setConfirmPassword(UtilisateurDetails.getConfirmPassword());
        Utilisateur.setEmail(UtilisateurDetails.getEmail());
        Utilisateur.setNomComplet(UtilisateurDetails.getNomComplet());
        Utilisateur.setFonction(UtilisateurDetails.getFonction());
        Utilisateur.setObservations(UtilisateurDetails.getObservations());
        Utilisateur.setProfils(UtilisateurDetails.getProfils());
        Utilisateur.setDomaines(UtilisateurDetails.getDomaines());
        Utilisateur.setDomaine(UtilisateurDetails.getDomaine());
        Utilisateur.setIdeas(UtilisateurDetails.getIdeas());
        Utilisateur.setStatut(UtilisateurDetails.getStatut());


        final Utilisateur updatedUtilisateur = utilisateurService.addUtilisateur(Utilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }


    //Delete
    @DeleteMapping(value = "/utilisateur/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") Long id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/utilisateur/{username}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Utilisateur> getUtilisateurByUsernameAndPassword(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        Utilisateur utilisateur = utilisateurService.findByUsernameAndPassword(username, password);

        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);

    }

    @GetMapping(value = "/utilisateur/getUsername/{username}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Utilisateur>> getUtilisateurByUsername(@PathVariable(value = "username") String username) {
        Optional<Utilisateur> utilisateur = utilisateurService.findByUsername(username);

        return new ResponseEntity<Optional<Utilisateur>>(utilisateur, HttpStatus.OK);

    }
    @GetMapping(value = "/utilisateur/getPassword/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Utilisateur> getUtilisateurByPassword(@PathVariable(value = "password") String password) {
        Utilisateur utilisateur = utilisateurService.findByPassword(password);

        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);

    }

    @PutMapping("/utilisateur/reset-password/{newPassword}/{id}")
    public String resetPassword(
            @PathVariable(name = "newPassword") String newPassword, @PathVariable(name = "id")  Long id, @Valid @RequestBody Utilisateur UtilisateurDetails) {

        return utilisateurService.resetPassword(newPassword,id,UtilisateurDetails);
    }


    @GetMapping("/utilisateur/checkPassword/{oldPassword}/{username}")
    boolean checkPassword(@PathVariable(name = "oldPassword") String oldPassword, @PathVariable(name = "username") String username)
    {

        return utilisateurService.checkPassword(oldPassword,username);
    }



    @GetMapping(value = "/utilisateur/{id}/profils")
    public ResponseEntity<Collection<Profile>> getListProfileByUserID(@PathVariable("id") Long id)
    {
        Collection<Profile> profiles = utilisateurService.getProfilesByUser(id);
        return  new ResponseEntity<Collection<Profile>>(profiles,HttpStatus.OK);
    }


    @GetMapping(value = "/utilisateur/{id}/ideas")
    public ResponseEntity<Collection<Idea>> getListIdeaByUserID(@PathVariable("id") Long id)
    {
        Collection<Idea> ideas = utilisateurService.getIdeaByUserId(id);
        return  new ResponseEntity<Collection<Idea>>(ideas,HttpStatus.OK);
    }


    @GetMapping(value = "/users/{role}")
    public ResponseEntity<Collection<Utilisateur>> getUsersByRole(@PathVariable("role") String role)
    {
        Collection<Utilisateur> utilisateurs = utilisateurService.getUserByRole(role);
        return  new ResponseEntity<Collection<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }

    @GetMapping(value = "/users/{role}/{domaine}")
    public ResponseEntity<Collection<Utilisateur>> getUsersByRoleAndDomaine(@PathVariable("role") String role,@PathVariable("domaine") String domaine)
    {
        Collection<Utilisateur> utilisateurs = utilisateurService.getUserByRoleAndDomaine(role,domaine);
        return  new ResponseEntity<Collection<Utilisateur>>(utilisateurs,HttpStatus.OK);
    }

}
