package com.user.service;

import com.user.exceptions.ProfileNotFoundException;
import com.user.model.Profile;
import com.user.repository.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements IProfileService{

    private IProfileRepository profileRepository;

    @Autowired
    public void setProfileRepository(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(int profileId) {
        profileRepository.deleteById(profileId);
    }

    @Override
    public Profile getById(int profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Invalid id"));
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }
}
