package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {

    @Query(value = "select l from Log l  where l.date > :dateDebut AND l.date < :dateFin")
    Collection<Log> findAllByDate(Date dateDebut,Date dateFin);
}
