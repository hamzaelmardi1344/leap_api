package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.TypeRisque;

import java.util.Collection;

public interface ITypeRisqueService {

    Collection<TypeRisque> getAllTypeRisques();
    TypeRisque getTypeRisqueById(Long TypeRisqueId);
    TypeRisque addTypeRisque(TypeRisque TypeRisque);
    void updateTypeRisque(TypeRisque TypeRisque);
    void deleteTypeRisque(Long TypeRisqueId);
}
