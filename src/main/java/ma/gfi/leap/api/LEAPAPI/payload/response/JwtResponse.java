package ma.gfi.leap.api.LEAPAPI.payload.response;


import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;

import java.util.Collection;
import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String password;
	private String email;
	private String nomComplet;
	private List<String> roles;
	private List<Idea> ideas;
	private String statut;

	//private Collection<Notification> notifications;


	public JwtResponse(String accessToken, Long id, String username,String password, String email, String nomComplet,List<Idea> ideas, String statut,List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nomComplet=nomComplet;

		this.ideas = ideas;
		this.statut = statut;
		this.roles = roles;


		//this.notifications = notifications;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
