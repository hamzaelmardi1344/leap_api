package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;

import java.util.Collection;

public interface IRefValeurAttributService {

    Collection<RefValeurAttribut> getAllRefValeurAttributs();
    RefValeurAttribut getRefValeurAttributById(Long RefValeurAttributId);
    RefValeurAttribut addRefValeurAttribut(RefValeurAttribut RefValeurAttribut);
    void updateRefValeurAttribut(RefValeurAttribut RefValeurAttribut);
    void deleteRefValeurAttribut(Long RefValeurAttributId);

    RefValeurAttribut getRefValeurAttributByValeur(String valeur);



}
