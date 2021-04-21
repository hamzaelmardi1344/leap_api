package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Criticite;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<Idea,Long> {
}
