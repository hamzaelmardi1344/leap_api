package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Criticite;

import java.util.Collection;

public interface ICriticiteService {

    Collection<Criticite> getAllCriticites();
    Criticite getCriticiteById(Long CriticiteId);
    Criticite addCriticite(Criticite Criticite);
    void updateCriticite(Criticite Criticite);
    void deleteCriticite(Long CriticiteId);
}
