package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Responsable;

import java.util.Collection;

public interface IResponsableService {

    Collection<Responsable> getAllResponsables();
    Responsable getResponsableById(Long ResponsableId);
    Responsable addResponsable(Responsable Responsable);
    void updateResponsable(Responsable Responsable);
    void deleteResponsable(Long ResponsableId);
}
