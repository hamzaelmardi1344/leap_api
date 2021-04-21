package ma.gfi.leap.api.LEAPAPI.core.services;

import ma.gfi.leap.api.LEAPAPI.core.dao.models.Profile;

import java.util.Collection;

public interface IProfileService {

    Collection<Profile> getAllProfiles();
    Profile getProfileById(Long ProfileId);
    Profile addProfile(Profile Profile);
    void updateProfile(Profile Profile);
    void deleteProfile(Long ProfileId);
}
