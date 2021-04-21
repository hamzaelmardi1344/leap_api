package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Attribut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String attribut;

    @ManyToOne
    private Programme programme;
    @ManyToOne
    private Projet projet;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "attribut")
    @JsonIgnore
    private Collection<AttributProgramme> attributProgrammes;



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

    public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
        this.attribut = attribut;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Collection<AttributProgramme> getAttributProgrammes() {
        return attributProgrammes;
    }

    public void setAttributProgrammes(Collection<AttributProgramme> attributProgrammes) {
        this.attributProgrammes = attributProgrammes;
    }
}
