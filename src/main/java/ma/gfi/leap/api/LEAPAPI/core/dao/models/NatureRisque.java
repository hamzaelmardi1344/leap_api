package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class NatureRisque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String valeur;

    @OneToMany(mappedBy = "natureRisque",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Risque> risques;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Collection<Risque> getRisques() {
        return risques;
    }

    public void setRisques(Collection<Risque> risques) {
        this.risques = risques;
    }
}
