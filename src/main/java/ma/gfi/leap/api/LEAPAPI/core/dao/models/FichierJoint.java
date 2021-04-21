package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import javax.persistence.*;

@Entity
public class FichierJoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String originalName;

    private String  type;

    private String cheminFichier;

    private Long taille;



    @ManyToOne
    private DocumentaireVF documentaireVF;

    @OneToOne(mappedBy = "fichierJoint")
    private Idea idea;


    @ManyToOne
    private Programme programme;

    @ManyToOne
    private Projet projet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public Long getTaille() {
        return taille;
    }

    public void setTaille(Long taille) {
        this.taille = taille;
    }



    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }


    public DocumentaireVF getDocumentaireVF() {
        return documentaireVF;
    }

    public void setDocumentaireVF(DocumentaireVF documentaireVF) {
        this.documentaireVF = documentaireVF;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
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
}
