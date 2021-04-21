package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "documentaire_vf_v1")
public class DocumentaireVF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private DocumentaireVF idParent;

    @OneToMany(mappedBy = "documentaireVF",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<DocumentaireVF> children;

    @ManyToOne
    private DocumentaireVF documentaireVF;

    private String  type;

    private String label;


    private String expandedIcon;

    private String collapsedIcon;

    private String niveau;

    private String chemin;


    @OneToMany(mappedBy = "documentaireVF",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<FichierJoint> fichierJoints;


    private Boolean expanded;


    @ManyToOne
    private Idea idea;

    @ManyToOne
    private Programme programme;

    @ManyToOne
    private Projet projet;




    private String code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentaireVF getIdParent() {
        return idParent;
    }

    public void setIdParent(DocumentaireVF idParent) {
        this.idParent = idParent;
    }

    public Collection<DocumentaireVF> getChildren() {
        return children;
    }

    public void setChildren(Collection<DocumentaireVF> children) {
        this.children = children;
    }

    public DocumentaireVF getDocumentaireVF() {
        return documentaireVF;
    }

    public void setDocumentaireVF(DocumentaireVF documentaireVF) {
        this.documentaireVF = documentaireVF;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Collection<FichierJoint> getFichierJoints() {
        return fichierJoints;
    }

    public void setFichierJoints(Collection<FichierJoint> fichierJoints) {
        this.fichierJoints = fichierJoints;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getExpandedIcon() {
        return expandedIcon;
    }

    public void setExpandedIcon(String expandedIcon) {
        this.expandedIcon = expandedIcon;
    }

    public String getCollapsedIcon() {
        return collapsedIcon;
    }

    public void setCollapsedIcon(String collapsedIcon) {
        this.collapsedIcon = collapsedIcon;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
