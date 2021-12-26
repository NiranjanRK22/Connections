package com.user.controllers;

import com.user.model.Profile;
import com.user.service.IProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("profile-api")
@RestController
public class ProfileController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @PreAuthorize("hasAnyRole('USER')")
//    @GetMapping("/secured/all")
//    public String firstPage() {
//        return "welcome";
//    }

    private IProfileService profileService;

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    public void setProfileService(IProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile)  {
        logger.debug("inside add profile");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new profile");
        Profile nProfile = profileService.addProfile(profile);
        logger.info("Adding profile " +nProfile);
        return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nProfile);
    }

    @PutMapping("/profiles")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile)  {
        logger.debug("inside update profile");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a profile");
        profileService.updateProfile(profile);
        logger.info("Updating profile " +profile);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/profiles/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable("profileId") int profileId)  {
        logger.debug("inside delete profile");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a profile");
        profileService.deleteProfile(profileId);
        logger.info("Deleting a profile " +profileId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/profiles/id/{profileId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("profileId") int profileId)  {
        logger.debug("inside get profile by id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profile by Id");
        Profile profile = profileService.getProfileById(profileId);
        logger.info("Got one profile " +profile);
        return ResponseEntity.ok().headers(headers).body(profile);
    }

    @GetMapping("/profiles")
    ResponseEntity<List<Profile>> getAll() {
        logger.debug("inside get all profiles");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all profiles");
        List<Profile> profiles = profileService.getAll();
        logger.info("Got all profiles " +profiles);
        ResponseEntity<List<Profile>> profileResponse = new ResponseEntity(profiles, headers, HttpStatus.OK);
        return profileResponse;
    }

    @GetMapping("/profiles/name/{name}")
    ResponseEntity<List<Profile>> getByName(@PathVariable("name") String name)  {
        logger.debug("inside get profiles by name");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by name");
        List<Profile> profiles = profileService.getByName(name);
        logger.info("Got profiles by name" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/bio/{bio}")
    ResponseEntity<List<Profile>> getByBio(@PathVariable("bio") String bio)  {
        logger.debug("inside get profiles by bio");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by bio");
        List<Profile> profiles = profileService.getByBio(bio);
        logger.info("Got profiles by bio" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/status/{openTo}")
    ResponseEntity<List<Profile>> getByStatus(@PathVariable("openTo") String openTo)  {
        logger.debug("inside get profiles by status");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by status");
        List<Profile> profiles = profileService.getByStatus(openTo);
        logger.info("Got profiles by status" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/qualification/{qualification}")
    ResponseEntity<List<Profile>> getByQualification(@PathVariable("qualification") String qualification)  {
        logger.debug("inside get profiles by qualification");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by qualification");
        List<Profile> profiles = profileService.getByQualification(qualification);
        logger.info("Got profiles by qualification" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("profiles/experience/{experience}")
    ResponseEntity<List<Profile>> getByExperience(@PathVariable("experience") int experience)  {
        logger.debug("inside get profiles by experience");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by experience");
        List<Profile> profiles = profileService.getByExperience(experience);
        logger.info("Got profiles by experience" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/skills/{skillName}")
    ResponseEntity<List<Profile>> getBySkills(@PathVariable("skillName") String skillName)  {
        logger.debug("inside get profiles by skills");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by skills");
        List<Profile> profiles = profileService.getBySkills(skillName);
        logger.info("Got profiles by skills" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/certifications/{certificationName}")
    ResponseEntity<List<Profile>> getByCertifications(@PathVariable("certificationName") String certificationName)  {
        logger.debug("inside get profiles by certifications");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by certifications");
        List<Profile> profiles = profileService.getByCertifications(certificationName);
        logger.info("Got profiles by certifications" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }

    @GetMapping("/profiles/skills/{skillName}/certifications/{certificationName}")
    ResponseEntity<List<Profile>> getByCertifiedSkills(@PathVariable("skillName") String skillName, @PathVariable("certificationName") String certificationName)  {
        logger.debug("inside get profiles by certifications and skills");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profiles by skills and certifications");
        List<Profile> profiles = profileService.getByCertifiedSkills(skillName, certificationName);
        logger.info("Got profiles by certifications and skills" +profiles);
        return ResponseEntity.ok().headers(headers).body(profiles);
    }
}
