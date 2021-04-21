package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Domaine;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DomaineService implements IDomaineService {

    @Autowired
    private DomaineRepository DomaineRepository;

    @Override
    public Collection<Domaine> getAllDomaines() {
        Collection<Domaine> list = new ArrayList<>();
        DomaineRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Domaine getDomaineById(Long DomaineId) {
        Domaine Domaine = DomaineRepository.findById(DomaineId).get();
        return Domaine;
    }

    @Override
    public Domaine addDomaine(Domaine Domaine) {
        return DomaineRepository.save(Domaine);
    }

    @Override
    public void updateDomaine(Domaine Domaine) {
        DomaineRepository.save(Domaine);
    }

    @Override
    public void deleteDomaine(Long DomaineId) {
        DomaineRepository.delete(getDomaineById(DomaineId));
    }
}
