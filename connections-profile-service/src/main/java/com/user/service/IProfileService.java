package com.user.service;

import com.user.model.Profile;

import java.util.List;

public interface IProfileService {
    Profile addProfile(Profile profile);
    void updateProfile(Profile profile);
    void deleteProfile(int profileId);

    Profile getById(int profileId);

    List<Profile> getAll();
}
