package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.gfi.leap.api.LEAPAPI.core.commun.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Projet extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Programme programme;

    private String code;
    
    private String projet;
    
    private String etat;

    private Float avancement;

    private Float avancementTheorique;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFin;

    private String description;

    private String alerte;

    private Boolean projetPrive;




    @Column(name = "valeur_attribut_projet",length = 5000)
    private String listValeurAttribut;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<AttributProjet> attributProjets;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<AttributProgramme> attributProgrammes;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "projet")
    @JsonIgnore
    private Collection<DocumentaireVF> documentaireVFS;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "projet")
    @JsonIgnore
    private Collection<FichierJoint> fichierJoints;


    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Risque> risques;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Action> actionProjets;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<RevisionProjet> revisionProjets;


    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Indicateur> indicateurs;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

    public Collection<AttributProjet> getAttributProjets() {
        return attributProjets;
    }

    public void setAttributProjets(Collection<AttributProjet> attributProjets) {
        this.attributProjets = attributProjets;
    }

    public Collection<Risque> getRisques() {
        return risques;
    }

    public void setRisques(Collection<Risque> risques) {
        this.risques = risques;
    }

    public Collection<Action> getActionProjets() {
        return actionProjets;
    }

    public void setActionProjets(Collection<Action> actionProjets) {
        this.actionProjets = actionProjets;
    }

    public Collection<AttributProgramme> getAttributProgrammes() {
        return attributProgrammes;
    }

    public void setAttributProgrammes(Collection<AttributProgramme> attributProgrammes) {
        this.attributProgrammes = attributProgrammes;
    }

    public Collection<RevisionProjet> getRevisionProjets() {
        return revisionProjets;
    }

    public void setRevisionProjets(Collection<RevisionProjet> revisionProjets) {
        this.revisionProjets = revisionProjets;
    }

    public Float getAvancementTheorique() {
        return avancementTheorique;
    }

    public void setAvancementTheorique(Float avancementTheorique) {
        this.avancementTheorique = avancementTheorique;
    }

    public String getListValeurAttribut() {
        return listValeurAttribut;
    }

    public void setListValeurAttribut(String listValeurAttribut) {
        this.listValeurAttribut = listValeurAttribut;
    }

    public Boolean getProjetPrive() {
        return projetPrive;
    }

    public void setProjetPrive(Boolean projetPrive) {
        this.projetPrive = projetPrive;
    }

    public Collection<DocumentaireVF> getDocumentaireVFS() {
        return documentaireVFS;
    }

    public void setDocumentaireVFS(Collection<DocumentaireVF> documentaireVFS) {
        this.documentaireVFS = documentaireVFS;
    }

    public Collection<FichierJoint> getFichierJoints() {
        return fichierJoints;
    }

    public void setFichierJoints(Collection<FichierJoint> fichierJoints) {
        this.fichierJoints = fichierJoints;
    }

    public Collection<Indicateur> getIndicateurs() {
        return indicateurs;
    }

    public void setIndicateurs(Collection<Indicateur> indicateurs) {
        this.indicateurs = indicateurs;
    }
}
