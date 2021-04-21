package ma.gfi.leap.api.LEAPAPI.core.dao.repositories;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefAttribut;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.RefValeurAttribut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefValeurAttributRepository extends JpaRepository<RefValeurAttribut,Long> {

    RefValeurAttribut findByValeur(String valeur);
}
