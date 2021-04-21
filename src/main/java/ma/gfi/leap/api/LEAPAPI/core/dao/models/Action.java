package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    @ManyToOne
    private Projet projet;

    private String code;

    @ManyToOne
    private Responsable responsable;

    @ManyToOne
    private Utilisateur utilisateur;

    private Float budgetAction;

    private String etat;

    private Float avancement;

    private Float avancementTheorique;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFin;

    private String description;

    private String alerte;

    private Boolean actionPrive;


    @OneToMany(mappedBy = "action",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Risque> risques;


    @ManyToOne
    private Programme programme;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Float getBudgetAction() {
        return budgetAction;
    }

    public void setBudgetAction(Float budgetAction) {
        this.budgetAction = budgetAction;
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

    public Collection<Risque> getRisques() {
        return risques;
    }

    public void setRisques(Collection<Risque> risques) {
        this.risques = risques;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Float getAvancementTheorique() {
        return avancementTheorique;
    }

    public void setAvancementTheorique(Float avancementTheorique) {
        this.avancementTheorique = avancementTheorique;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Boolean getActionPrive() {
        return actionPrive;
    }

    public void setActionPrive(Boolean actionPrive) {
        this.actionPrive = actionPrive;
    }
}
