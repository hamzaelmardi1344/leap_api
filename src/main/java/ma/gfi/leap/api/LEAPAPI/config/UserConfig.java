package ma.gfi.leap.api.LEAPAPI.config;


import ma.gfi.leap.api.LEAPAPI.core.commun.AuditorAwareImpl;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class UserConfig {

    @Bean
    Utilisateur getUser() {
        return new Utilisateur();
    }
    @Bean
    public AuditorAware<String> auditorAware()
    {
        return new AuditorAwareImpl();
    }
}
