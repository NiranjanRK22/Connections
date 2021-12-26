package com.post;

import com.post.model.*;
import com.post.service.IPostService;
import com.post.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableFeignClients
public class ConnectionsPostServiceApplication implements CommandLineRunner {
    @Autowired
    IPostService postService;

    @Autowired
    IProfileService profileService;


    public static void main(String[] args) {
        SpringApplication.run(ConnectionsPostServiceApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate()  {
//        return new RestTemplate();
//    }

    @Override
    public void run(String... args) throws Exception {

//        Skills skill1 = new Skills(Skill.ANGULAR.toString());
//        Skills skill2 = new Skills(Skill.AZURE.toString());
//        Skills skill3 = new Skills(Skill.DOTNET.toString());
//
//        Set<Skills> skillsSet = new HashSet<>(Arrays.asList(skill1, skill2, skill3));
//
//        Certifications certification1 = new Certifications(Certificate.ADOBE.toString());
//        Certifications certification2 = new Certifications(Certificate.AZURE.toString());
//        Certifications certification3 = new Certifications(Certificate.AWS.toString());
//
//        Set<Certifications> certificationsSet = new HashSet<>(Arrays.asList(certification1, certification2, certification3));
//
//        ProfileDetails profileDetails = new ProfileDetails(OpenTo.OPENTOWORK, "BTech", skillsSet, 1, certificationsSet);
//
////        Profile profile =
//        Like like = new Like(LocalDateTime.now());
//        Like like1 = new Like(LocalDateTime.now());
//        Like like2 = new Like(LocalDateTime.now());
//        Like like3 = new Like(LocalDateTime.now());
//        Like like4 = new Like(LocalDateTime.now());
//        Like like5 = new Like(LocalDateTime.now());
//        Like like6 = new Like(LocalDateTime.now());
//        Set<Like> likes = new HashSet<>(Arrays.asList(like, like1, like2, like3));
//
//
//        Comments comment = new Comments("Good", LocalDateTime.now());
//        Comments comment1 = new Comments("Excellent", LocalDateTime.now());
//        Comments comment2 = new Comments("Good", LocalDateTime.now());
//        Comments comment3 = new Comments("Good", LocalDateTime.now());
//        Set<Comments> comments = new HashSet<>(Arrays.asList(comment, comment1));
//
//        Profile profile = profileService.getProfileById(101);
//
//        Post post1 = new Post("Monday motivation", "After a relaxing weekend, Monday rolls around to snap everyone back to reality. What you need, then, are these Monday motivation quotes to psych yourself up for a good work week. Start the day with these good morning quotes, too—you’ll be ready to take on the world one day at a time. Now, reclaim your Mondays with these uplifting quotes, and self-love quotes as well.",
//                "motivation", likes, comments, profile);
//
//        Post post2 = new Post("How to get a job in the tech industry", "We spend hundreds and thousands of rupees in getting a degree with the aim to earn a livelihood. Anyone who passes out from the college wants to get on the job as soon as possible. ",
//                "job", likes, comments, profile);
//
//
//        postService.addPost(post1);

    }
}
