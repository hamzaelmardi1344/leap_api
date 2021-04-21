package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisqueRepository extends JpaRepository<Risque,Long> {
}
