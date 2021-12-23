package com.user;

import com.user.model.*;
import com.user.repository.UserRepository;
import com.user.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ConnectionsProfileServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsProfileServiceApplication.class, args);
	}

    @Autowired
    private IProfileService profileService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Skills skill1= new Skills(Skill.ANGULAR.toString());
		Skills skill2= new Skills(Skill.AZURE.toString());
		Skills skill3= new Skills(Skill.DOTNET.toString());

		Set<Skills>skillsSet=new HashSet<>(Arrays.asList(skill1,skill2,skill3));

		Certifications certification1= new Certifications(Certificate.ADOBE.toString());
		Certifications certification2= new Certifications(Certificate.AZURE.toString());
		Certifications certification3= new Certifications(Certificate.AWS.toString());

		Set<Certifications>certificationsSet=new HashSet<>(Arrays.asList(certification1,certification2,certification3));

		ProfileDetails profileDetails = new ProfileDetails(OpenTo.OPENTOWORK, "BTech",skillsSet, 1, certificationsSet);

		Profile profile = new Profile("Amit", "amit@gmail.com", "Software engineer", "https://www.freepik.com/free-vector/businessman-character-avatar-isolated_6769264.htm#query=profile&position=2&from_view=search", profileDetails);
		profileService.addProfile(profile);

		User user = new User();
		user.setUserName("amit@123");
		user.setPassword(passwordEncoder.encode("amit"));
		user.setActive(1);
		user.setRoles("user");
		userRepository.save(user);



	}
}
