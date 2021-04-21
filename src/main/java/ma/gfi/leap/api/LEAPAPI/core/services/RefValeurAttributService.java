package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RefValeurAttributRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RefValeurAttributService implements IRefValeurAttributService {

    @Autowired
    private RefValeurAttributRepository RefValeurAttributRepository;

    @Override
    public Collection<RefValeurAttribut> getAllRefValeurAttributs() {
        Collection<RefValeurAttribut> list = new ArrayList<>();
        RefValeurAttributRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public RefValeurAttribut getRefValeurAttributById(Long RefValeurAttributId) {
        RefValeurAttribut RefValeurAttribut = RefValeurAttributRepository.findById(RefValeurAttributId).get();
        return RefValeurAttribut;
    }

    @Override
    public RefValeurAttribut addRefValeurAttribut(RefValeurAttribut RefValeurAttribut) {
        return RefValeurAttributRepository.save(RefValeurAttribut);
    }

    @Override
    public void updateRefValeurAttribut(RefValeurAttribut RefValeurAttribut) {
        RefValeurAttributRepository.save(RefValeurAttribut);
    }

    @Override
    public void deleteRefValeurAttribut(Long RefValeurAttributId) {
        RefValeurAttributRepository.delete(getRefValeurAttributById(RefValeurAttributId));
    }

    @Override
    public RefValeurAttribut getRefValeurAttributByValeur(String valeur) {
        return RefValeurAttributRepository.findByValeur(valeur);
    }
}
