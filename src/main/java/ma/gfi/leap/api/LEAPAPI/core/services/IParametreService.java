package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Parametre;

import java.util.Collection;

public interface IParametreService {

    Collection<Parametre> getAllParametres();
    Parametre getParametreById(Long ParametreId);
    Parametre addParametre(Parametre Parametre);
    void updateParametre(Parametre Parametre);
    void deleteParametre(Long ParametreId);
}
