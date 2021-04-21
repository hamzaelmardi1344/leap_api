package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import javax.persistence.*;

@Entity
public class Indicateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String indicateur;

    private Integer realisation;

    private Integer cible;

    @ManyToOne
    private Projet projet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(String indicateur) {
        this.indicateur = indicateur;
    }

    public Integer getRealisation() {
        return realisation;
    }

    public void setRealisation(Integer realisation) {
        this.realisation = realisation;
    }

    public Integer getCible() {
        return cible;
    }

    public void setCible(Integer cible) {
        this.cible = cible;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
