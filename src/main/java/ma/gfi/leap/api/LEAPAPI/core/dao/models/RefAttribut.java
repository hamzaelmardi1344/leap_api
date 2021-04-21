package ma.gfi.leap.api.LEAPAPI.core.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RefAttribut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valeur;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "refAttribut")
    @JsonIgnore
    private Collection<RefValeurAttribut> refValeurAttributs;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Collection<RefValeurAttribut> getRefValeurAttributs() {
        return refValeurAttributs;
    }

    public void setRefValeurAttributs(Collection<RefValeurAttribut> refValeurAttributs) {
        this.refValeurAttributs = refValeurAttributs;
    }
}
