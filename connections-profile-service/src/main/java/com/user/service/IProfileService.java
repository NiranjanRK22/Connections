package com.user.service;

import com.user.exceptions.ProfileNotFoundException;
import com.user.model.Profile;

import java.util.List;

public interface IProfileService {
    Profile addProfile(Profile profile);
    void updateProfile(Profile profile) throws ProfileNotFoundException;
    void deleteProfile(int profileId) throws ProfileNotFoundException;

    Profile getProfileById(int profileId) throws ProfileNotFoundException;

    List<Profile> getAll();
    List<Profile> getByName(String name) throws ProfileNotFoundException;
    List<Profile> getByStatus(String openTo) throws ProfileNotFoundException;
    List<Profile> getByQualification(String qualification) throws ProfileNotFoundException;
    //List<Profile> getBySkills();
   // List<Profile> getBySkillsCertifications();
    List<Profile> getByExperience(int experience) throws ProfileNotFoundException;
}
