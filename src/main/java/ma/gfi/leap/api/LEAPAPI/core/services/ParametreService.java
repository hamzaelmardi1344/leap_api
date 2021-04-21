package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Parametre;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ParametreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ParametreService implements IParametreService {
    
    @Autowired
    private ParametreRepository parametreRepository;


    @Override
    public Collection<Parametre> getAllParametres() {
        Collection<Parametre> list = new ArrayList<>();
        parametreRepository.findAll().forEach(e -> list.add(e));
        return list.stream().sorted(Comparator.comparing(Parametre::getValeur)).collect(Collectors.toList());
    }

    @Override
    public Parametre getParametreById(Long ParametreId) {
        Parametre obj = parametreRepository.findById(ParametreId).get();
        return obj;
    }

    @Override
    public Parametre addParametre(Parametre Parametre) {
        return parametreRepository.save(Parametre);
    }

    @Override
    public void updateParametre(Parametre Parametre) {
            parametreRepository.save(Parametre);
    }

    @Override
    public void deleteParametre(Long ParametreId) {
            parametreRepository.delete(getParametreById(ParametreId));
    }
}
