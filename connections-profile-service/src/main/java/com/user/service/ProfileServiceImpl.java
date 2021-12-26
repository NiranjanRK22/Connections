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
        return profileRepository.findByName(name);
    }

    @Override
    public List<Profile> getByBio(String bio) throws ProfileNotFoundException {
        return profileRepository.findByBio(bio);
    }

    @Override
    public List<Profile> getByStatus(String openTo) throws ProfileNotFoundException {
        return profileRepository.findByStatus(OpenTo.valueOf(openTo));
    }

    @Override
    public List<Profile> getByQualification(String qualification) throws ProfileNotFoundException {
        return profileRepository.findByQualification(qualification);
    }

    @Override
    public List<Profile> getBySkills(String skillName) throws ProfileNotFoundException{
        return profileRepository.findBySkills(skillName);
    }

    @Override
    public List<Profile> getByCertifications(String certificationName) throws ProfileNotFoundException {
        return profileRepository.findByCertifications(certificationName);
    }

    @Override
    public List<Profile> getByCertifiedSkills(String skillName, String certificationName) throws ProfileNotFoundException {
        return profileRepository.findByCertifiedSkills(skillName, certificationName);
    }

    @Override
    public List<Profile> getByExperience(int experience) throws ProfileNotFoundException {
        return profileRepository.findByExperience(experience);
    }
}
