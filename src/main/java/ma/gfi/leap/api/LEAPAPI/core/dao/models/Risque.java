package ma.gfi.leap.api.LEAPAPI.core.dao.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Risque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TypeRisque typeRisque;

    @ManyToOne
    private Perimetre perimetre;

    private String risque;

    @ManyToOne
    private Criticite criticite;

    @ManyToOne
    private Utilisateur responsable;

    private String actionMitigation;

    @ManyToOne
    private NatureRisque natureRisque;

    @ManyToOne
    private Action action;

    @ManyToOne
    private Programme programme;
    
    @ManyToOne
    private Projet projet;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateRisque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeRisque getTypeRisque() {
        return typeRisque;
    }

    public void setTypeRisque(TypeRisque typeRisque) {
        this.typeRisque = typeRisque;
    }

    public Perimetre getPerimetre() {
        return perimetre;
    }

    public void setPerimetre(Perimetre perimetre) {
        this.perimetre = perimetre;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public Criticite getCriticite() {
        return criticite;
    }

    public void setCriticite(Criticite criticite) {
        this.criticite = criticite;
    }

    public String getActionMitigation() {
        return actionMitigation;
    }

    public void setActionMitigation(String actionMitigation) {
        this.actionMitigation = actionMitigation;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }

    public Date getDateRisque() {
        return dateRisque;
    }

    public void setDateRisque(Date dateRisque) {
        this.dateRisque = dateRisque;
    }

    public NatureRisque getNatureRisque() {
        return natureRisque;
    }

    public void setNatureRisque(NatureRisque natureRisque) {
        this.natureRisque = natureRisque;
    }

}
