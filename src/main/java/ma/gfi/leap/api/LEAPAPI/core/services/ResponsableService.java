package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Responsable;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ResponsableService implements IResponsableService {

    @Autowired
    private ResponsableRepository ResponsableRepository;

    @Override
    public Collection<Responsable> getAllResponsables() {
        Collection<Responsable> list = new ArrayList<>();
        ResponsableRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Responsable getResponsableById(Long ResponsableId) {
        Responsable Responsable = ResponsableRepository.findById(ResponsableId).get();
        return Responsable;
    }

    @Override
    public Responsable addResponsable(Responsable Responsable) {
        return ResponsableRepository.save(Responsable);
    }

    @Override
    public void updateResponsable(Responsable Responsable) {
        ResponsableRepository.save(Responsable);
    }

    @Override
    public void deleteResponsable(Long ResponsableId) {
        ResponsableRepository.delete(getResponsableById(ResponsableId));
    }
}
