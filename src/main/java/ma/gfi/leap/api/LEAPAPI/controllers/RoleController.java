package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.models.Role;
import ma.gfi.leap.api.LEAPAPI.core.services.IProfileService;
import ma.gfi.leap.api.LEAPAPI.core.services.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api")
public class RoleController {
    
    @Autowired
    private IRoleService roleService;

    @Autowired
    private IProfileService profileService;

    //Fetches Role by id
    @GetMapping(value= "/role/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Long id) {
        Role ob = new Role();
        BeanUtils.copyProperties(roleService.getRoleById(id), ob);
        return new ResponseEntity<Role>(ob, HttpStatus.OK);
    }


    //Fetches all Roles
    @GetMapping(value= "/roles", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Role>> getAllRoles() {
        Collection<Role> RoleList = roleService.getAllRoles();

        return new ResponseEntity<>(RoleList, HttpStatus.OK);
    }


    //Creates a new Role
    @PostMapping(value= "/role/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Role addRole(@RequestBody Role Role, UriComponentsBuilder builder) {
        Role Role1 = roleService.addRole(Role);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Role/{id}").buildAndExpand(Role1.getId()).toUri());
        return Role1;
    }


    //Updates evenmement
    @PutMapping("/role/edit/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long RoleId,
                                           @Valid @RequestBody Role RoleDetails) throws Exception{
        Role Role = roleService.getRoleById(RoleId);

        Role.setName(RoleDetails.getName());



        final Role updatedRole = roleService.addRole(Role);
        return ResponseEntity.ok(updatedRole);
    }


    //Deletes evenemnt by id
    @DeleteMapping(value= "/role/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



   
    @GetMapping(value= "/roleByName/{name}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Role>> getRoleByName(@PathVariable(value = "name") String name) {
       Optional<Role> role = roleService.getRoleByName(name);

        return new ResponseEntity<>(role, HttpStatus.OK);
    }



    //Fetches Profile by id
    @GetMapping(value= "/profile/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id) {
        Profile ob = new Profile();
        BeanUtils.copyProperties(profileService.getProfileById(id), ob);
        return new ResponseEntity<Profile>(ob, HttpStatus.OK);
    }


    //Fetches all Profiles
    @GetMapping(value= "/profiles", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Profile>> getAllProfiles() {
        Collection<Profile> ProfileList = profileService.getAllProfiles();

        return new ResponseEntity<>(ProfileList, HttpStatus.OK);
    }


    //Creates a new Profile
    @PostMapping(value= "/profile/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Profile addProfile(@RequestBody Profile Profile, UriComponentsBuilder builder) {
        Profile Profile1 = profileService.addProfile(Profile);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Profile/{id}").buildAndExpand(Profile1.getId()).toUri());
        return Profile1;
    }


    //Updates evenmement
    @PutMapping("/profile/edit/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long ProfileId,
                                                 @Valid @RequestBody Profile ProfileDetails) throws Exception{
        Profile Profile = profileService.getProfileById(ProfileId);

        Profile.setName(ProfileDetails.getName());



        final Profile updatedProfile = profileService.addProfile(Profile);
        return ResponseEntity.ok(updatedProfile);
    }


    //Deletes evenemnt by id
    @DeleteMapping(value= "/profile/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }



}
