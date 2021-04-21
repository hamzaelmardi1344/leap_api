package ma.gfi.leap.api.LEAPAPI.core.dao.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.gfi.leap.api.LEAPAPI.core.commun.Auditable;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class Utilisateur extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 8567309825873343725L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String confirmPassword;

    private String token;


    private String email;

    private String statut;

    private String nomComplet;

    private String fonction;


     private String observations;


    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Idea> ideas;

    private String domaine;



    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Action> actions;

    @ManyToMany
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Collection<Profile> profils;

    @ManyToMany
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Collection<Domaine> domaines;

/*    @OneToMany(mappedBy = "utilisateurMAECI",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Notification> notifications;*/

    public Utilisateur()
    {}

   public Utilisateur(String username , String email, String nomComplet, List<Profile> profiles, String password, String fonction, String observations,List<Domaine> domaines ,String statut)
   {
       this.username = username;
       this.email = email;
       this.nomComplet = nomComplet;
       this.profils = profiles;
       this.password = password;
       this.fonction=fonction;
       this.observations=observations;
       this.domaines = domaines;
       this.statut = statut;

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<Profile> getProfils() {
        return profils;
    }

    public void setProfils(Collection<Profile> profils) {
        this.profils = profils;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<Action> getActions() {
        return actions;
    }

    public void setActions(Collection<Action> actions) {
        this.actions = actions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Collection<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(Collection<Idea> ideas) {
        this.ideas = ideas;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Collection<Domaine> getDomaines() {
        return domaines;
    }

    public void setDomaines(Collection<Domaine> domaines) {
        this.domaines = domaines;
    }
}

