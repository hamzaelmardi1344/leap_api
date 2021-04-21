package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.NatureRisque;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.TypeRisque;

import java.util.Collection;

public interface INatureRisqueService {

    Collection<NatureRisque> getAllNatureRisques();
    NatureRisque getNatureRisqueById(Long natureRisqueId);
    NatureRisque addNatureRisque(NatureRisque natureRisque);
    void updateNatureRisque(NatureRisque natureRisque);
    void deleteNatureRisque(Long natureRisqueId);
}
