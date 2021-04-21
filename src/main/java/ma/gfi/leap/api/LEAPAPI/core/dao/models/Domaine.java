package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valeur;

    private String code;


    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "domaine")
    @JsonIgnore
    private Collection<Idea> ideas;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Collection<Idea> ideas) {
        this.ideas = ideas;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
