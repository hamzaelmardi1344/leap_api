package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Perimetre;

import java.util.Collection;

public interface IPerimetreService {

    Collection<Perimetre> getAllPerimetres();
    Perimetre getPerimetreById(Long PerimetreId);
    Perimetre addPerimetre(Perimetre Perimetre);
    void updatePerimetre(Perimetre Perimetre);
    void deletePerimetre(Long PerimetreId);
}
