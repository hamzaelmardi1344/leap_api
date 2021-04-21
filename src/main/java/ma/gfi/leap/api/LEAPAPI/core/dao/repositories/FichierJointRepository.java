package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.FichierJoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichierJointRepository extends JpaRepository<FichierJoint,Long> {
}
