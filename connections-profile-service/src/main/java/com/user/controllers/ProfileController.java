package com.user.controllers;

import com.user.model.Profile;
import com.user.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
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

    @Autowired
    public void setProfileService(IProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profiles")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new profile");
        Profile nProfile = profileService.addProfile(profile);
        return  ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nProfile);
    }

    @PutMapping("/profiles")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a profile");
        profileService.updateProfile(profile);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/profiles/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable("profileId") int profileId)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a profile");
        profileService.deleteProfile(profileId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/profiles/id/{profileId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("profileId") int profileId)  {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting profile by Id");
        Profile profile = profileService.getProfileById(profileId);
        return ResponseEntity.ok().headers(headers).body(profile);
    }

    @GetMapping("/profiles")
    ResponseEntity<List<Profile>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all profiles");
        List<Profile> profiles = profileService.getAll();
        ResponseEntity<List<Profile>> profileResponse = new ResponseEntity(profiles, headers, HttpStatus.OK);
        return profileResponse;
    }


}
