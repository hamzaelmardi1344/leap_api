package ma.gfi.leap.api.LEAPAPI.controllers;


import ma.gfi.leap.api.LEAPAPI.config.security.jwt.JwtUtils;
import ma.gfi.leap.api.LEAPAPI.config.security.services.UserDetailsImpl;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Idea;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Utilisateur;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.RoleRepository;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.UtilisateurRepository;
import ma.gfi.leap.api.LEAPAPI.core.services.IUtilisateurService;
import ma.gfi.leap.api.LEAPAPI.payload.request.LoginRequest;
import ma.gfi.leap.api.LEAPAPI.payload.request.SignupRequest;
import ma.gfi.leap.api.LEAPAPI.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth", method = { RequestMethod.GET, RequestMethod.POST })

public class AuthController {

	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	UtilisateurRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getPassword(),
				userDetails.getEmail(),
				userDetails.getNomComplet(),
				(List<Idea>) userDetails.getIdeas(),
				userDetails.getStatut(),
				roles));
	}

	@PostMapping("/signup")
	public Utilisateur registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		// Create new user's account
		Utilisateur user = new Utilisateur(signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				signUpRequest.getNomComplet(),
				signUpRequest.getProfils(),
				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getFonction(),
				signUpRequest.getObservations(),
				signUpRequest.getDomaines(),
				signUpRequest.getStatut()
		);
		userRepository.save(user);

		return user;
	}
}

