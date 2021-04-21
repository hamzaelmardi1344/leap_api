package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.TypeRisque;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.TypeRisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class TypeRisqueService implements ITypeRisqueService {

    @Autowired
    private TypeRisqueRepository TypeRisqueRepository;

    @Override
    public Collection<TypeRisque> getAllTypeRisques() {
        Collection<TypeRisque> list = new ArrayList<>();
        TypeRisqueRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public TypeRisque getTypeRisqueById(Long TypeRisqueId) {
        TypeRisque TypeRisque = TypeRisqueRepository.findById(TypeRisqueId).get();
        return TypeRisque;
    }

    @Override
    public TypeRisque addTypeRisque(TypeRisque TypeRisque) {
        return TypeRisqueRepository.save(TypeRisque);
    }

    @Override
    public void updateTypeRisque(TypeRisque TypeRisque) {
        TypeRisqueRepository.save(TypeRisque);
    }

    @Override
    public void deleteTypeRisque(Long TypeRisqueId) {
        TypeRisqueRepository.delete(getTypeRisqueById(TypeRisqueId));
    }
}
