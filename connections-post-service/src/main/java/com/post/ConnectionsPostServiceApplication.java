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
import java.util.List;
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


    @Override
    public void run(String... args) throws Exception {

        Like like = new Like(LocalDateTime.now());
        Like like1 = new Like(LocalDateTime.now());
        Like like2 = new Like(LocalDateTime.now());
        Like like3 = new Like(LocalDateTime.now());
//        Like like4 = new Like(LocalDateTime.now());
//        Like like5 = new Like(LocalDateTime.now());

        Comments comment = new Comments("Good", LocalDateTime.now());
        Comments comment1 = new Comments("Excellent", LocalDateTime.now());
        Comments comment2 = new Comments("Good", LocalDateTime.now());
        Comments comment3 = new Comments("Very Good", LocalDateTime.now());
        Comments comment4 = new Comments("Insightful", LocalDateTime.now());
        Comments comment5 = new Comments("Love this", LocalDateTime.now());
        Comments comment6 = new Comments("Motivational", LocalDateTime.now());


        Profile profile = profileService.getProfileById(101); // the person who created the post
        Profile profile1 = profileService.getProfileById(102); //the person who commenteed and liked
        Profile profile2 = profileService.getProfileById(103); //the person who commenteed and liked
        Profile profile3 = profileService.getProfileById(104); //the person who commenteed and liked
        Profile profile4 = profileService.getProfileById(105);
        Profile profile5 = profileService.getProfileById(106);

//        comment2.setProfile(profile4);
        comment6.setProfile(profile5);
        comment4.setProfile(profile2);
        Set<Comments> comments = new HashSet<>(List.of(comment4,comment6));


//        like.setProfile(profile1);
//        like1.setProfile(profile5);
//        System.out.println(like3);
//        System.out.println(comment3.getProfile());

        like2.setProfile(profile2);
        like3.setProfile(profile3);
        Set<Like> likes = new HashSet<>(List.of(like2,like3));

//
        Post post1 = new Post("Monday motivation", "After a relaxing weekend, Monday rolls around to snap everyone back to reality.",
                "motivation", likes, comments, profile1);

        Post post2 = new Post("How to get a job in the tech industry", "We spend hundreds and thousands of rupees in getting a degree with the aim to earn a livelihood. Anyone who passes out from the college wants to get on the job as soon as possible. ",
                "job", likes, comments, profile2);

        Post post3 = new Post("The two shutdowns could signal a broader pullback from ephemeral video products among social media companies.", "However, it seems unlikely that Snapchat or Instagram will be giving up on their Stories products anytime soon", "social media",
                likes, comments, profile3);

        Post post4 = new Post("Many of life’s failures ", "Many of life’s failures are people who did not realize how close they were to success when they gave up.Many of life’s failures are people who did not realize how close they were to success when they gave up.", "Quotes",
                likes, comments, profile4);
//
        Post post5 = new Post("Time", "Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking.", "Quote",
                likes, comments, profile5);

//
//        postService.addPost(post1);
//        postService.addPost(post2);
//        postService.addPost(post3);
        postService.addPost(post4);

    }
}
