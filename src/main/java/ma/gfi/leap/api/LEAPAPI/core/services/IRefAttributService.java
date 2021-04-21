package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;

import java.util.Collection;

public interface IRefAttributService {

    Collection<RefAttribut> getAllRefAttributs();
    RefAttribut getRefAttributById(Long RefAttributId);
    RefAttribut addRefAttribut(RefAttribut RefAttribut);
    void updateRefAttribut(RefAttribut RefAttribut);
    void deleteRefAttribut(Long RefAttributId);

    RefAttribut getRefAttributByValeur(String valeur);

    Collection<RefValeurAttribut> getListByRefAttribut(Long id);


}
