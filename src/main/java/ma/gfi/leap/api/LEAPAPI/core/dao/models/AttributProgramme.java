package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class    AttributProgramme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Programme programme;
    @ManyToOne
    private Projet projet;

    @ManyToOne
    private Attribut attribut;

    private String valeur;


    @OneToMany(mappedBy = "attributProgramme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<AttributProjet> attributProjets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Attribut getAttribut() {
        return attribut;
    }

    public void setAttribut(Attribut attribut) {
        this.attribut = attribut;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }


    public Collection<AttributProjet> getAttributProjets() {
        return attributProjets;
    }

    public void setAttributProjets(Collection<AttributProjet> attributProjets) {
        this.attributProjets = attributProjets;
    }
}
