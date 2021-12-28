package com.user;

import com.user.repository.UserRepository;
import com.user.service.IProfileService;
import com.user.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


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


//        Skills skill1= new Skills(Skill.DEVOPS.toString());
//        Skills skill3= new Skills(Skill.HIBERNATE.toString());
//
//        Set<Skills> skillsSet=new HashSet<>(Arrays.asList(skill1, skill3));
//
//        Certifications certification1= new Certifications(Certificate.PALO.toString());
//        Certifications certification2= new Certifications(Certificate.HPE.toString());
//        Certifications certification3= new Certifications(Certificate.MICROSOFT.toString());
//
//        Set<Certifications>certificationsSet=new HashSet<>(Arrays.asList(certification1, certification3));
//
//        ProfileDetails profileDetails = new ProfileDetails(OpenTo.OPENTOWORK, "MS",skillsSet, 3, certificationsSet);
//
//        Profile profile = new Profile("Navin", "navin@gmail.com", "Senior Software Engineer", "https://res.cloudinary.com/dmnrh67gl/image/upload/v1640320468/123.jpg", profileDetails);
//        profileService.addProfile(profile);
//
//        System.out.println(profileService.getProfileById(105));




    }

}
