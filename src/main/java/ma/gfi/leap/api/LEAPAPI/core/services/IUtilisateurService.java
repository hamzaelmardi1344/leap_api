package ma.gfi.leap.api.LEAPAPI.core.services;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;

import java.util.Collection;
import java.util.Optional;

public interface IUtilisateurService {

    Collection<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurById(Long UtilisateurId);
    Utilisateur addUtilisateur(Utilisateur Utilisateur);
    void updateUtilisateur(Utilisateur Utilisateur);
    void deleteUtilisateur(Long UtilisateurId);
    Utilisateur findByUsernameAndPassword(String username,String password);
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur findByPassword(String password);
    String resetPassword(String newPassword,Long id,Utilisateur utilisateur);
    boolean checkPassword(String oldPassword,String username);
    Collection<Profile> getProfilesByUser(Long id);
    Collection<Idea> getIdeaByUserId(Long id);
    Collection<Utilisateur> getUserByRole(String role);
    Collection<Utilisateur> getUserByRoleAndDomaine(String role,String domaine);

}
