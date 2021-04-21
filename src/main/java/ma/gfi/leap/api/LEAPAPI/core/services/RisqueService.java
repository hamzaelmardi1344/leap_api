package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RisqueService implements IRisqueService {

    @Autowired
    private RisqueRepository RisqueRepository;

    @Override
    public Collection<Risque> getAllRisques() {
        Collection<Risque> list = new ArrayList<>();
        RisqueRepository.findAll(Sort.by(Sort.Direction.ASC,"typeRisque")).forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Risque getRisqueById(Long RisqueId) {
        Risque Risque = RisqueRepository.findById(RisqueId).get();
        return Risque;
    }

    @Override
    public Risque addRisque(Risque Risque) {
        return RisqueRepository.save(Risque);
    }

    @Override
    public void updateRisque(Risque Risque) {
        RisqueRepository.save(Risque);
    }

    @Override
    public void deleteRisque(Long RisqueId) {
        RisqueRepository.delete(getRisqueById(RisqueId));
    }
}
