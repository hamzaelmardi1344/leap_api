package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.gfi.leap.api.LEAPAPI.core.commun.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Programme extends Auditable<String> implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;

    private String etat;

    private Float avancement;

    private Float avancementTheorique;
    
    private String description;

    private String alerte;

    private String listValeurAttribut;

    @Column(name = "valeur_attribut",length = 5000)
    private String listValeurAttribut2;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "programme")
    @JsonIgnore
    private Collection<DocumentaireVF> documentaireVFS;

    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Attribut> attributs;

    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<AttributProgramme> attributProgrammes;

    private Boolean programmePrive;



    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Risque> risques;



    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Action> actions;

    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Projet> projets;



    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<FichierJoint> fichierJoints;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Float getAvancement() {
        return avancement;
    }

    public void setAvancement(Float avancement) {
        this.avancement = avancement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlerte() {
        return alerte;
    }

    public void setAlerte(String alerte) {
        this.alerte = alerte;
    }

    public Collection<Attribut> getAttributs() {
        return attributs;
    }

    public void setAttributs(Collection<Attribut> attributs) {
        this.attributs = attributs;
    }

    public Collection<AttributProgramme> getAttributProgrammes() {
        return attributProgrammes;
    }

    public void setAttributProgrammes(Collection<AttributProgramme> attributProgrammes) {
        this.attributProgrammes = attributProgrammes;
    }

    public Collection<Risque> getRisques() {
        return risques;
    }

    public void setRisques(Collection<Risque> risques) {
        this.risques = risques;
    }

    public Collection<Projet> getProjets() {
        return projets;
    }

    public void setProjets(Collection<Projet> projets) {
        this.projets = projets;
    }

    public Float getAvancementTheorique() {
        return avancementTheorique;
    }

    public void setAvancementTheorique(Float avancementTheorique) {
        this.avancementTheorique = avancementTheorique;
    }

    public Collection<Action> getActions() {
        return actions;
    }

    public void setActions(Collection<Action> actions) {
        this.actions = actions;
    }

    public String getListValeurAttribut() {
        return listValeurAttribut;
    }

    public void setListValeurAttribut(String listValeurAttribut) {
        this.listValeurAttribut = listValeurAttribut;
    }

    public String getListValeurAttribut2() {
        return listValeurAttribut2;
    }

    public void setListValeurAttribut2(String listValeurAttribut2) {
        this.listValeurAttribut2 = listValeurAttribut2;
    }

    public Collection<DocumentaireVF> getDocumentaireVFS() {
        return documentaireVFS;
    }

    public void setDocumentaireVFS(Collection<DocumentaireVF> documentaireVFS) {
        this.documentaireVFS = documentaireVFS;
    }

    public Boolean getProgrammePrive() {
        return programmePrive;
    }

    public void setProgrammePrive(Boolean programmePrive) {
        this.programmePrive = programmePrive;
    }


    public Collection<FichierJoint> getFichierJoints() {
        return fichierJoints;
    }

    public void setFichierJoints(Collection<FichierJoint> fichierJoints) {
        this.fichierJoints = fichierJoints;
    }
}
