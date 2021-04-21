package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RefAttributRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RefAttributService implements IRefAttributService {

    @Autowired
    private RefAttributRepository RefAttributRepository;

    @Override
    public Collection<RefAttribut> getAllRefAttributs() {
        Collection<RefAttribut> list = new ArrayList<>();
        RefAttributRepository.findAll().forEach(e -> list.add(e));
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public RefAttribut getRefAttributById(Long RefAttributId) {
        RefAttribut RefAttribut = RefAttributRepository.findById(RefAttributId).get();
        return RefAttribut;
    }

    @Override
    public RefAttribut addRefAttribut(RefAttribut RefAttribut) {
        return RefAttributRepository.save(RefAttribut);
    }

    @Override
    public void updateRefAttribut(RefAttribut RefAttribut) {
        RefAttributRepository.save(RefAttribut);
    }

    @Override
    public void deleteRefAttribut(Long RefAttributId) {
        RefAttributRepository.delete(getRefAttributById(RefAttributId));
    }

    @Override
    public RefAttribut getRefAttributByValeur(String valeur) {
        return RefAttributRepository.findByValeur(valeur);
    }

    @Override
    public Collection<RefValeurAttribut> getListByRefAttribut(Long id) {
        RefAttribut refAttribut = RefAttributRepository.findById(id).get();
        return refAttribut.getRefValeurAttributs();
    }
}
