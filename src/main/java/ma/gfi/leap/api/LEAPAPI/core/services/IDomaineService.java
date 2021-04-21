package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Domaine;

import java.util.Collection;

public interface IDomaineService {

    Collection<Domaine> getAllDomaines();
    Domaine getDomaineById(Long DomaineId);
    Domaine addDomaine(Domaine Domaine);
    void updateDomaine(Domaine Domaine);
    void deleteDomaine(Long DomaineId);
}
