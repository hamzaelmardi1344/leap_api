package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;

import java.util.Collection;

public interface IRisqueService {

    Collection<Risque> getAllRisques();
    Risque getRisqueById(Long RisqueId);
    Risque addRisque(Risque Risque);
    void updateRisque(Risque Risque);
    void deleteRisque(Long RisqueId);
}
