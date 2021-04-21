package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Attribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProgramme;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.AttributRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AttributService implements IAttributService {

    @Autowired
    private AttributRepository AttributRepository;

    @Override
    public Collection<Attribut> getAllAttributs() {
        Collection<Attribut> list = new ArrayList<>();
        AttributRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Attribut getAttributById(Long AttributId) {
        Attribut Attribut = AttributRepository.findById(AttributId).get();
        return Attribut;
    }

    @Override
    public Attribut addAttribut(Attribut Attribut) {
        return AttributRepository.save(Attribut);
    }

    @Override
    public void updateAttribut(Attribut Attribut) {
        AttributRepository.save(Attribut);
    }

    @Override
    public void deleteAttribut(Long AttributId) {
        AttributRepository.delete(getAttributById(AttributId));
    }

    @Override
    public Collection<AttributProgramme> getAttributProgrammeByAttribut(Long id) {
        Attribut Attribut = AttributRepository.findById(id).get();
        return Attribut.getAttributProgrammes();
    }
}
