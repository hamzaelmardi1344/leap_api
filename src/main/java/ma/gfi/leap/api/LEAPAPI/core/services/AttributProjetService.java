package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.AttributProjet;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.AttributProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AttributProjetService implements IAttributProjetService {

    @Autowired
    private AttributProjetRepository AttributProjetRepository;

    @Override
    public Collection<AttributProjet> getAllAttributProjets() {
        Collection<AttributProjet> list = new ArrayList<>();
        AttributProjetRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public AttributProjet getAttributProjetById(Long AttributProjetId) {
        AttributProjet AttributProjet = AttributProjetRepository.findById(AttributProjetId).get();
        return AttributProjet;
    }

    @Override
    public AttributProjet addAttributProjet(AttributProjet AttributProjet) {
        return AttributProjetRepository.save(AttributProjet);
    }

    @Override
    public void updateAttributProjet(AttributProjet AttributProjet) {
        AttributProjetRepository.save(AttributProjet);
    }

    @Override
    public void deleteAttributProjet(Long AttributProjetId) {
        AttributProjetRepository.delete(getAttributProjetById(AttributProjetId));
    }
}
