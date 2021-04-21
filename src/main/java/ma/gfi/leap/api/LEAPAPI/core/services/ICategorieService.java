package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Categorie;

import java.util.Collection;

public interface ICategorieService {

    Collection<Categorie> getAllCategories();
    Categorie getCategorieById(Long CategorieId);
    Categorie addCategorie(Categorie Categorie);
    void updateCategorie(Categorie Categorie);
    void deleteCategorie(Long CategorieId);
}
