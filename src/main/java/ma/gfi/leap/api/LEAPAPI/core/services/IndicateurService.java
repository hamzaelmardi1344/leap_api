package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Indicateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.IndicateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class IndicateurService implements IIndicateurService {

    @Autowired
    private IndicateurRepository IndicateurRepository;

    @Override
    public Collection<Indicateur> getAllIndicateurs() {
        Collection<Indicateur> list = new ArrayList<>();
        IndicateurRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Indicateur getIndicateurById(Long IndicateurId) {
        Indicateur Indicateur = IndicateurRepository.findById(IndicateurId).get();
        return Indicateur;
    }

    @Override
    public Indicateur addIndicateur(Indicateur Indicateur) {
        return IndicateurRepository.save(Indicateur);
    }

    @Override
    public void updateIndicateur(Indicateur Indicateur) {
        IndicateurRepository.save(Indicateur);
    }

    @Override
    public void deleteIndicateur(Long IndicateurId) {
        IndicateurRepository.delete(getIndicateurById(IndicateurId));
    }
}
