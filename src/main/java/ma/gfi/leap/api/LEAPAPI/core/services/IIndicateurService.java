package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Indicateur;

import java.util.Collection;

public interface IIndicateurService {

    Collection<Indicateur> getAllIndicateurs();
    Indicateur getIndicateurById(Long IndicateurId);
    Indicateur addIndicateur(Indicateur Indicateur);
    void updateIndicateur(Indicateur Indicateur);
    void deleteIndicateur(Long IndicateurId);

}
