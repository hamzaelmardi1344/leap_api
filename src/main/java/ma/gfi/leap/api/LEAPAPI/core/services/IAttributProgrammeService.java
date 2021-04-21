package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;

import java.util.Collection;

public interface IAttributProgrammeService {

    Collection<AttributProgramme> getAllAttributProgrammes();
    AttributProgramme getAttributProgrammeById(Long AttributProgrammeId);
    AttributProgramme addAttributProgramme(AttributProgramme AttributProgramme);
    void updateAttributProgramme(AttributProgramme AttributProgramme);
    void deleteAttributProgramme(Long AttributProgrammeId);
    AttributProgramme findByValeur(String valeur);
    Collection<AttributProgramme> findAllByValeur(String valeur);
}
