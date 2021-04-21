package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Attribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;

import java.util.Collection;

public interface IAttributService {

    Collection<Attribut> getAllAttributs();
    Attribut getAttributById(Long AttributId);
    Attribut addAttribut(Attribut Attribut);
    void updateAttribut(Attribut Attribut);
    void deleteAttribut(Long AttributId);
    Collection<AttributProgramme> getAttributProgrammeByAttribut(Long id);
}
