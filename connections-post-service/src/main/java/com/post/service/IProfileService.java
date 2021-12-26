package com.post.service;

import com.post.model.Profile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "PROFILE-SERVICE")
public interface IProfileService {
    @GetMapping("/profile-api/profiles/id/{profileId}")
    Profile getProfileById(@PathVariable("profileId") int profileId);
}
