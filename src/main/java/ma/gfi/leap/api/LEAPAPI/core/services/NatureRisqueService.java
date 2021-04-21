package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.NatureRisque;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.NatureRisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class NatureRisqueService implements INatureRisqueService {

    @Autowired
    private NatureRisqueRepository NatureRisqueRepository;

    @Override
    public Collection<NatureRisque> getAllNatureRisques() {
        Collection<NatureRisque> list = new ArrayList<>();
        NatureRisqueRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public NatureRisque getNatureRisqueById(Long NatureRisqueId) {
        NatureRisque NatureRisque = NatureRisqueRepository.findById(NatureRisqueId).get();
        return NatureRisque;
    }

    @Override
    public NatureRisque addNatureRisque(NatureRisque NatureRisque) {
        return NatureRisqueRepository.save(NatureRisque);
    }

    @Override
    public void updateNatureRisque(NatureRisque NatureRisque) {
        NatureRisqueRepository.save(NatureRisque);
    }

    @Override
    public void deleteNatureRisque(Long NatureRisqueId) {
        NatureRisqueRepository.delete(getNatureRisqueById(NatureRisqueId));
    }
}
