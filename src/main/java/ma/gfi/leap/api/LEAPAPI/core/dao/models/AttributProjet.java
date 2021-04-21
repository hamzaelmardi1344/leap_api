package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import javax.persistence.*;

@Entity
public class AttributProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Projet projet;

    @ManyToOne
    private Attribut attribut;

    @ManyToOne
    private Programme programme;

    @ManyToOne
    private AttributProgramme attributProgramme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Attribut getAttribut() {
        return attribut;
    }

    public void setAttribut(Attribut attribut) {
        this.attribut = attribut;
    }

    public AttributProgramme getAttributProgramme() {
        return attributProgramme;
    }

    public void setAttributProgramme(AttributProgramme attributProgramme) {
        this.attributProgramme = attributProgramme;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
}
