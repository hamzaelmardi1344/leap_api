package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.gfi.leap.api.LEAPAPI.core.commun.Auditable;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Idea extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String titre;

    @ManyToOne
    private Domaine domaine;

    private String idea;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fichierJoint_id", referencedColumnName = "id")
    private FichierJoint fichierJoint;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idea")
    @JsonIgnore
    private Collection<DocumentaireVF> documentaireVFS;

    private String statut;

    private String proprietaire;

    private String soumissionaire;

    private String decisionModeration;

    private String commModeration;

    private String moderePar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date modereLe;

    private String decisionValidateur;

    private String commValidateur;

    private String validePar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date valideLe;

    private String commConversion;

    private String convertiPar;

    @ManyToOne
    private Utilisateur utilisateur;

    private Boolean moderated;

    private Boolean createdIdea;

    private Boolean validated;

    private Boolean converted;

    private Integer numeroEtape;



    @ManyToMany
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Collection<Utilisateur> utilisateurs;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date convertiLe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public FichierJoint getFichierJoint() {
        return fichierJoint;
    }

    public void setFichierJoint(FichierJoint fichierJoint) {
        this.fichierJoint = fichierJoint;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getDecisionModeration() {
        return decisionModeration;
    }

    public void setDecisionModeration(String decisionModeration) {
        this.decisionModeration = decisionModeration;
    }

    public String getCommModeration() {
        return commModeration;
    }

    public void setCommModeration(String commModeration) {
        this.commModeration = commModeration;
    }

    public String getModerePar() {
        return moderePar;
    }

    public void setModerePar(String moderePar) {
        this.moderePar = moderePar;
    }

    public Date getModereLe() {
        return modereLe;
    }

    public void setModereLe(Date modereLe) {
        this.modereLe = modereLe;
    }

    public String getDecisionValidateur() {
        return decisionValidateur;
    }

    public void setDecisionValidateur(String decisionValidateur) {
        this.decisionValidateur = decisionValidateur;
    }

    public String getCommValidateur() {
        return commValidateur;
    }

    public void setCommValidateur(String commValidateur) {
        this.commValidateur = commValidateur;
    }

    public String getValidePar() {
        return validePar;
    }

    public void setValidePar(String validePar) {
        this.validePar = validePar;
    }

    public Date getValideLe() {
        return valideLe;
    }

    public void setValideLe(Date valideLe) {
        this.valideLe = valideLe;
    }

    public String getCommConversion() {
        return commConversion;
    }

    public void setCommConversion(String commConversion) {
        this.commConversion = commConversion;
    }

    public String getConvertiPar() {
        return convertiPar;
    }

    public void setConvertiPar(String convertiPar) {
        this.convertiPar = convertiPar;
    }

    public Date getConvertiLe() {
        return convertiLe;
    }

    public void setConvertiLe(Date convertiLe) {
        this.convertiLe = convertiLe;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getSoumissionaire() {
        return soumissionaire;
    }

    public void setSoumissionaire(String soumissionaire) {
        this.soumissionaire = soumissionaire;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Boolean getModerated() {
        return moderated;
    }

    public void setModerated(Boolean moderated) {
        this.moderated = moderated;
    }

    public Boolean getCreatedIdea() {
        return createdIdea;
    }

    public void setCreatedIdea(Boolean createdIdea) {
        this.createdIdea = createdIdea;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getConverted() {
        return converted;
    }

    public void setConverted(Boolean converted) {
        this.converted = converted;
    }

    public Integer getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(Integer numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    public Collection<DocumentaireVF> getDocumentaireVFS() {
        return documentaireVFS;
    }

    public void setDocumentaireVFS(Collection<DocumentaireVF> documentaireVFS) {
        this.documentaireVFS = documentaireVFS;
    }
}
