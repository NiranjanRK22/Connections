package com.user.service;

import com.user.model.Profile;
import com.user.repository.IProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements IProfileService{

    private IProfileRepository profileRepository;

    
    @Override
    public Profile addProfile(Profile profile) {
        return null;
    }

    @Override
    public void updateProfile(Profile profile) {

    }

    @Override
    public void deleteProfile(int profileId) {

    }

    @Override
    public Profile getById(int profileId) {
        return null;
    }

    @Override
    public List<Profile> getAll() {
        return null;
    }
}
