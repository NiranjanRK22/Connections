package com.user;

import com.user.model.*;
import com.user.repository.UserRepository;
import com.user.service.IProfileService;
import com.user.service.ISkillService;
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
	private ISkillService skillService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
//		Skills skill1= new Skills(Skill.BLOCKCHAIN.toString());
//		Skills skill2= skillService.getSkillById(101);
//		Skills skill3= new Skills(Skill.GOOGLING.toString());
//
//		Set<Skills> skillsSet=new HashSet<>(Arrays.asList(skill1));
//
//		Certifications certification1= new Certifications(Certificate.PALO.toString());
//		Certifications certification2= new Certifications(Certificate.DELLEMC.toString());
//		Certifications certification3= new Certifications(Certificate.AWS.toString());
//
//		Set<Certifications>certificationsSet=new HashSet<>(Arrays.asList(certification1));
//
//		ProfileDetails profileDetails = new ProfileDetails(OpenTo.OPENTOWORK, "MS",skillsSet, 2, certificationsSet);
//
//		Profile profile = new Profile("Raaj", "raaj@gmail.com", "Software Engineer", "https://res.cloudinary.com/dmnrh67gl/image/upload/v1640320468/123.jpg", profileDetails);
//		profileService.addProfile(profile);

//		User user = new User();
//		user.setUserName("amit@123");
//		user.setPassword(passwordEncoder.encode("amit"));
//		user.setActive(1);
//		user.setRoles("user");
//		userRepository.save(user);



	}

}
