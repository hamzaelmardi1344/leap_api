package ma.gfi.leap.api.LEAPAPI.core.commun;

import ma.gfi.leap.api.LEAPAPI.config.security.services.UserDetailsImpl;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Autowired
    UtilisateurRepository repository;
    UserDetailsImpl systemUser;
    @Override
    public Optional<String> getCurrentAuditor() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl principal;
        if (authentication == null || !authentication.isAuthenticated()) {
            principal = systemUser;
        } else {
            principal = (UserDetailsImpl) authentication.getPrincipal();
        }
        return Optional.of(principal.getNomComplet());
    }
}
