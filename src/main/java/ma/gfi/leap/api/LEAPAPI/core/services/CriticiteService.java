package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Criticite;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.CriticiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CriticiteService implements ICriticiteService {

    @Autowired
    private CriticiteRepository CriticiteRepository;

    @Override
    public Collection<Criticite> getAllCriticites() {
        Collection<Criticite> list = new ArrayList<>();
        CriticiteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Criticite getCriticiteById(Long CriticiteId) {
        Criticite Criticite = CriticiteRepository.findById(CriticiteId).get();
        return Criticite;
    }

    @Override
    public Criticite addCriticite(Criticite Criticite) {
        return CriticiteRepository.save(Criticite);
    }

    @Override
    public void updateCriticite(Criticite Criticite) {
        CriticiteRepository.save(Criticite);
    }

    @Override
    public void deleteCriticite(Long CriticiteId) {
        CriticiteRepository.delete(getCriticiteById(CriticiteId));
    }
}
