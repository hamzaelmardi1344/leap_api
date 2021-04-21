package ma.gfi.leap.api.LEAPAPI.core.services;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.IdeaRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements IUtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private IdeaRepository ideaRepository;


    @Autowired
    PasswordEncoder encoder;

    @Override
    public Collection<Utilisateur> getAllUtilisateurs() {
        Collection<Utilisateur> list = new ArrayList<>();
        utilisateurRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Utilisateur getUtilisateurById(Long UtilisateurId) {
        Utilisateur obj = utilisateurRepository.findById(UtilisateurId).get();
        return obj;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur Utilisateur) {
        return utilisateurRepository.save(Utilisateur);
    }

    @Override
    public void updateUtilisateur(Utilisateur Utilisateur) {


        utilisateurRepository.save(Utilisateur);
    }

    @Override
    public void deleteUtilisateur(Long UtilisateurId) {
        utilisateurRepository.delete(getUtilisateurById(UtilisateurId));
    }

    @Override
    public Utilisateur findByUsernameAndPassword(String username,String password) {
        return utilisateurRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Optional<Utilisateur> findByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    @Override
    public Utilisateur findByPassword(String password) {
        return utilisateurRepository.findByPassword(password);
    }


    @Override
        public String resetPassword(String newPassword,Long id,Utilisateur utilisateur) {

        try {
            Utilisateur user = utilisateurRepository.findById(id).get();
                //old password matching

                    //encode new password
                    user.setPassword(encoder.encode(newPassword));
                    //update
                    utilisateurRepository.save(user);


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return "password updated";
    }

    @Override
    public boolean checkPassword(String oldPassword,String username) {

        Utilisateur user = utilisateurRepository.findByUsername(username).get();

        return encoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public Collection<Profile> getProfilesByUser(Long id) {

        Utilisateur utilisateur= utilisateurRepository.findById(id).get();
        return utilisateur.getProfils();
    }

    @Override
    public Collection<Idea> getIdeaByUserId(Long id) {
        Collection<Idea> ideas = ideaRepository.findAll();
        return ideas.stream().filter(i -> i.getUtilisateurs().stream().anyMatch(u -> u.getId().equals(id))).collect(Collectors.toList());
    }


    @Override
    public Collection<Utilisateur> getUserByRole(String role) {

        Collection<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().filter(u ->  u.getProfils().stream().anyMatch(r -> r.getRoles().stream().anyMatch(c -> c.getName().contains(role)))).collect(Collectors.toList());
    }

    @Override
    public Collection<Utilisateur> getUserByRoleAndDomaine(String role, String domaine) {
        Collection<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().filter(u ->  u.getProfils().stream().anyMatch(r -> r.getRoles().stream().anyMatch(c -> c.getName().contains(role)))).filter(u -> u.getDomaines().stream().anyMatch(d -> d.getCode().equals(domaine))).collect(Collectors.toList());
    }


}
