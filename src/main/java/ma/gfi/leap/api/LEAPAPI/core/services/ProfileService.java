package ma.gfi.leap.api.LEAPAPI.core.services;



import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;
import ma.gfi.leap.api.LEAPAPI.core.dao.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProfileService implements IProfileService {
    
    @Autowired
    private ProfileRepository ProfileRepository;


    @Override
    public Collection<Profile> getAllProfiles() {
        Collection<Profile> list = new ArrayList<>();
        ProfileRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Profile getProfileById(Long ProfileId) {
        Profile obj = ProfileRepository.findById(ProfileId).get();
        return obj;
    }

    @Override
    public Profile addProfile(Profile Profile) {
        return ProfileRepository.save(Profile);
    }

    @Override
    public void updateProfile(Profile Profile) {
        ProfileRepository.save(Profile);
    }

    @Override
    public void deleteProfile(Long ProfileId) {
        ProfileRepository.delete(getProfileById(ProfileId));
    }


}
