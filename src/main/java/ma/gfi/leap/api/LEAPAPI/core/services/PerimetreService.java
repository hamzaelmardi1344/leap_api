package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Perimetre;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.PerimetreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PerimetreService implements IPerimetreService {

    @Autowired
    private PerimetreRepository PerimetreRepository;

    @Override
    public Collection<Perimetre> getAllPerimetres() {
        Collection<Perimetre> list = new ArrayList<>();
        PerimetreRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Perimetre getPerimetreById(Long PerimetreId) {
        Perimetre Perimetre = PerimetreRepository.findById(PerimetreId).get();
        return Perimetre;
    }

    @Override
    public Perimetre addPerimetre(Perimetre Perimetre) {
        return PerimetreRepository.save(Perimetre);
    }

    @Override
    public void updatePerimetre(Perimetre Perimetre) {
        PerimetreRepository.save(Perimetre);
    }

    @Override
    public void deletePerimetre(Long PerimetreId) {
        PerimetreRepository.delete(getPerimetreById(PerimetreId));
    }
}
