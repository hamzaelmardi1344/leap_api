package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.DocumentaireVF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DocumentaireVFRepository extends JpaRepository<DocumentaireVF,Long> {

    @Query(value = "select d  from DocumentaireVF d  where d.idParent.id is NULL")
    Collection<DocumentaireVF> findAllByIdParent();

    Collection<DocumentaireVF> findAllByNiveau(String niveau);

    DocumentaireVF findByLabel(String label);

    @Query(value = "select d  from DocumentaireVF d  where d.niveau = :niveau AND d.idParent.id = :id")
    Collection<DocumentaireVF> findAllByNiveauAndIdParent(String niveau,Long id);

}
