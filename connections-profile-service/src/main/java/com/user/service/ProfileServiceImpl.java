package com.user.service;

import com.user.exceptions.ProfileNotFoundException;
import com.user.model.OpenTo;
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
    public void updateProfile(Profile profile) throws ProfileNotFoundException {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(int profileId) throws ProfileNotFoundException {
        profileRepository.deleteById(profileId);
    }

    @Override
    public Profile getProfileById(int profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException("Invalid id"));
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> getByName(String name) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByName(name);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found starting with this name or letter");
        return profiles;
    }

    @Override
    public List<Profile> getByBio(String bio) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByBio(bio);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this bio");
        return profiles;
    }

    @Override
    public List<Profile> getByStatus(String openTo) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByStatus(OpenTo.valueOf(openTo));
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this status");
        return profiles;
    }

    @Override
    public List<Profile> getByQualification(String qualification) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByQualification(qualification);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this qualification");
        return profiles;
    }

    @Override
    public List<Profile> getBySkills(String skillName) throws ProfileNotFoundException{
        List<Profile> profiles = profileRepository.findBySkills(skillName);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this skill");
        return profiles;
    }

    @Override
    public List<Profile> getByCertifications(String certificationName) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByCertifications(certificationName);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this certification");
        return profiles;
    }

    @Override
    public List<Profile> getByCertifiedSkills(String skillName, String certificationName) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByCertifiedSkills(skillName, certificationName);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this certification and skill");
        return profiles;
    }

    @Override
    public List<Profile> getByExperience(int experience) throws ProfileNotFoundException {
        List<Profile> profiles = profileRepository.findByExperience(experience);
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profiles not found with this experience");
        return profiles;
    }
}
