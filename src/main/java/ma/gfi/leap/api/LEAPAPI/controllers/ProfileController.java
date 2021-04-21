package ma.gfi.leap.api.LEAPAPI.controllers;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.services.IProfileService;
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
public class ProfileController {
    
    @Autowired
    private IProfileService ProfileService;

  /*  //Fetches Profile by id
    @GetMapping(value= "/profile/get/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id) {
        Profile ob = new Profile();
        BeanUtils.copyProperties(ProfileService.getProfileById(id), ob);
        return new ResponseEntity<Profile>(ob, HttpStatus.OK);
    }


    //Fetches all Profiles
    @GetMapping(value= "/profiles", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<Profile>> getAllProfiles() {
        Collection<Profile> ProfileList = ProfileService.getAllProfiles();

        return new ResponseEntity<>(ProfileList, HttpStatus.OK);
    }


    //Creates a new Profile
    @PostMapping(value= "/profile/creation", produces= { MediaType.APPLICATION_JSON_VALUE })
    public Profile addProfile(@RequestBody Profile Profile, UriComponentsBuilder builder) {
        Profile Profile1 = ProfileService.addProfile(Profile);
        //  HttpHeaders headers = new HttpHeaders();
        //  headers.setLocation(builder.path("/Profile/{id}").buildAndExpand(Profile1.getId()).toUri());
        return Profile1;
    }


    //Updates evenmement
    @PutMapping("/profile/edit/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long ProfileId,
                                           @Valid @RequestBody Profile ProfileDetails) throws Exception{
        Profile Profile = ProfileService.getProfileById(ProfileId);

        Profile.setName(ProfileDetails.getName());



        final Profile updatedProfile = ProfileService.addProfile(Profile);
        return ResponseEntity.ok(updatedProfile);
    }


    //Deletes evenemnt by id
    @DeleteMapping(value= "/profile/delete/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id) {
        ProfileService.deleteProfile(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


*/


}
