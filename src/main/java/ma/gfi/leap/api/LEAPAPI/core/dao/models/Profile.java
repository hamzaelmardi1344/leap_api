package ma.gfi.leap.api.LEAPAPI.core.dao.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private String description;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "PROFIL_ROLE", joinColumns = @JoinColumn(name = "PROFIL_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<Role>();

    private Boolean admin=false;

    private Boolean consultationProgramme=false;
    private Boolean creationProgramme=false;
    private Boolean modificationProgramme=false;
    private Boolean suppressionProgramme=false;



    private Boolean consultationProjet=false;
    private Boolean creationProjet=false;
    private Boolean modificationProjet=false;
    private Boolean suppressionProjet=false;



    private Boolean consultationAction=false;
    private Boolean creationAction=false;
    private Boolean modificationAction=false;
    private Boolean suppressionAction=false;



    private Boolean consultationRisque=false;
    private Boolean creationRisque=false;
    private Boolean modificationRisque=false;
    private Boolean suppressionRisque=false;


    private Boolean moderateurIdee;


    private Boolean validateurIdee;

    private String listRole;

    private Boolean programmePrive;
    private Boolean projetPrive;
    private Boolean actionPrive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getConsultationProgramme() {
        return consultationProgramme;
    }

    public void setConsultationProgramme(Boolean consultationProgramme) {
        this.consultationProgramme = consultationProgramme;
    }

    public Boolean getCreationProgramme() {
        return creationProgramme;
    }

    public void setCreationProgramme(Boolean creationProgramme) {
        this.creationProgramme = creationProgramme;
    }

    public Boolean getModificationProgramme() {
        return modificationProgramme;
    }

    public void setModificationProgramme(Boolean modificationProgramme) {
        this.modificationProgramme = modificationProgramme;
    }

    public Boolean getSuppressionProgramme() {
        return suppressionProgramme;
    }

    public void setSuppressionProgramme(Boolean suppressionProgramme) {
        this.suppressionProgramme = suppressionProgramme;
    }

    public Boolean getConsultationProjet() {
        return consultationProjet;
    }

    public void setConsultationProjet(Boolean consultationProjet) {
        this.consultationProjet = consultationProjet;
    }

    public Boolean getCreationProjet() {
        return creationProjet;
    }

    public void setCreationProjet(Boolean creationProjet) {
        this.creationProjet = creationProjet;
    }

    public Boolean getModificationProjet() {
        return modificationProjet;
    }

    public void setModificationProjet(Boolean modificationProjet) {
        this.modificationProjet = modificationProjet;
    }

    public Boolean getSuppressionProjet() {
        return suppressionProjet;
    }

    public void setSuppressionProjet(Boolean suppressionProjet) {
        this.suppressionProjet = suppressionProjet;
    }

    public Boolean getConsultationAction() {
        return consultationAction;
    }

    public void setConsultationAction(Boolean consultationAction) {
        this.consultationAction = consultationAction;
    }

    public Boolean getCreationAction() {
        return creationAction;
    }

    public void setCreationAction(Boolean creationAction) {
        this.creationAction = creationAction;
    }

    public Boolean getModificationAction() {
        return modificationAction;
    }

    public void setModificationAction(Boolean modificationAction) {
        this.modificationAction = modificationAction;
    }

    public Boolean getSuppressionAction() {
        return suppressionAction;
    }

    public void setSuppressionAction(Boolean suppressionAction) {
        this.suppressionAction = suppressionAction;
    }

    public Boolean getConsultationRisque() {
        return consultationRisque;
    }

    public void setConsultationRisque(Boolean consultationRisque) {
        this.consultationRisque = consultationRisque;
    }

    public Boolean getCreationRisque() {
        return creationRisque;
    }

    public void setCreationRisque(Boolean creationRisque) {
        this.creationRisque = creationRisque;
    }

    public Boolean getModificationRisque() {
        return modificationRisque;
    }

    public void setModificationRisque(Boolean modificationRisque) {
        this.modificationRisque = modificationRisque;
    }

    public Boolean getSuppressionRisque() {
        return suppressionRisque;
    }

    public void setSuppressionRisque(Boolean suppressionRisque) {
        this.suppressionRisque = suppressionRisque;
    }

    public Boolean getModerateurIdee() {
        return moderateurIdee;
    }

    public void setModerateurIdee(Boolean moderateurIdee) {
        this.moderateurIdee = moderateurIdee;
    }

    public Boolean getValidateurIdee() {
        return validateurIdee;
    }

    public void setValidateurIdee(Boolean validateurIdee) {
        this.validateurIdee = validateurIdee;
    }

    public String getListRole() {
        return listRole;
    }

    public void setListRole(String listRole) {
        this.listRole = listRole;
    }

    public Boolean getProgrammePrive() {
        return programmePrive;
    }

    public void setProgrammePrive(Boolean programmePrive) {
        this.programmePrive = programmePrive;
    }

    public Boolean getProjetPrive() {
        return projetPrive;
    }

    public void setProjetPrive(Boolean projetPrive) {
        this.projetPrive = projetPrive;
    }

    public Boolean getActionPrive() {
        return actionPrive;
    }

    public void setActionPrive(Boolean actionPrive) {
        this.actionPrive = actionPrive;
    }
}
