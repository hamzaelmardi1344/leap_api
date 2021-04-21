package ma.gfi.leap.api.LEAPAPI.config.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.lang.Collections;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Role;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	private String nomComplet;


	private Collection<Idea> ideas;

	@JsonIgnore
	private String password;

	private String statut;

	private static List<GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password, String nomComplet, Collection<Idea> ideas, String statut,
						   List<GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nomComplet=nomComplet;
		this.ideas = ideas;
		this.statut = statut;
		this.authorities = authorities;

		//this.notifications=notifications;
	}

	public static UserDetailsImpl build(Utilisateur user) {
		if (!Collections.isEmpty((user.getProfils()))) {
			UserDetailsImpl.authorities = new ArrayList<GrantedAuthority>();
			for(Profile profil:user.getProfils()) {
				for (Role role:profil.getRoles()) {
					UserDetailsImpl.authorities.add(new SimpleGrantedAuthority(role.getName()));
				}
			}
		}

		return new UserDetailsImpl(
				user.getId(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getNomComplet(),

					user.getIdeas(),
					user.getStatut(),
			//	user.getNotifications(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}


	public String getNomComplet() {
		return nomComplet;
	}

	public Collection<Idea> getIdeas() {
		return ideas;
	}

	public String getStatut() {
		return statut;
	}
}
