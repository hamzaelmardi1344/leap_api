package ma.gfi.leap.api.LEAPAPI.core.services;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Categorie;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CategorieService implements ICategorieService {

    @Autowired
    private CategorieRepository CategorieRepository;

    @Override
    public Collection<Categorie> getAllCategories() {
        Collection<Categorie> list = new ArrayList<>();
        CategorieRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Categorie getCategorieById(Long CategorieId) {
        Categorie Categorie = CategorieRepository.findById(CategorieId).get();
        return Categorie;
    }

    @Override
    public Categorie addCategorie(Categorie Categorie) {
        return CategorieRepository.save(Categorie);
    }

    @Override
    public void updateCategorie(Categorie Categorie) {
        CategorieRepository.save(Categorie);
    }

    @Override
    public void deleteCategorie(Long CategorieId) {
        CategorieRepository.delete(getCategorieById(CategorieId));
    }
}
