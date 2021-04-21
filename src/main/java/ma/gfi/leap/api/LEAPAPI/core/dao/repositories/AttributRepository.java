package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Attribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributRepository extends JpaRepository<Attribut,Long> {
}
