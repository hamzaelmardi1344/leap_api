package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import javax.persistence.*;

@Entity
public class RefValeurAttribut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valeur;

    @ManyToOne
    private RefAttribut refAttribut;

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

    public RefAttribut getRefAttribut() {
        return refAttribut;
    }

    public void setRefAttribut(RefAttribut refAttribut) {
        this.refAttribut = refAttribut;
    }
}
