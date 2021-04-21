package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {


    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Utilisateur findByUsernameAndPassword(String username,String password);
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur findByPassword(String password);
    Utilisateur findByEmail(String email);
    Utilisateur findByToken(String token);


}
