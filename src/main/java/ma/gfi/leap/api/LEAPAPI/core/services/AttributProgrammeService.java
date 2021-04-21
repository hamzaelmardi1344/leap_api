package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.AttributProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AttributProgrammeService implements IAttributProgrammeService {

    @Autowired
    private AttributProgrammeRepository AttributProgrammeRepository;

    @Override
    public Collection<AttributProgramme> getAllAttributProgrammes() {
        Collection<AttributProgramme> list = new ArrayList<>();
        AttributProgrammeRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public AttributProgramme getAttributProgrammeById(Long AttributProgrammeId) {
        AttributProgramme AttributProgramme = AttributProgrammeRepository.findById(AttributProgrammeId).get();
        return AttributProgramme;
    }

    @Override
    public AttributProgramme addAttributProgramme(AttributProgramme AttributProgramme) {
        return AttributProgrammeRepository.save(AttributProgramme);
    }

    @Override
    public void updateAttributProgramme(AttributProgramme AttributProgramme) {
        AttributProgrammeRepository.save(AttributProgramme);
    }

    @Override
    public void deleteAttributProgramme(Long AttributProgrammeId) {
        AttributProgrammeRepository.delete(getAttributProgrammeById(AttributProgrammeId));
    }

    @Override
    public AttributProgramme findByValeur(String valeur) {
        return AttributProgrammeRepository.findByValeur(valeur);
    }

    @Override
    public Collection<AttributProgramme> findAllByValeur(String valeur) {
        return AttributProgrammeRepository.findAllByValeur(valeur);
    }
}
