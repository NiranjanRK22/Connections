package com.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Profile {
    @Id
    @GeneratedValue(generator = "profile_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="profile_seq",sequenceName = "profile_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "profileid")
    private Integer profileId;
    private String name;
    private String email;
    private String bio;
    @Column(name="profileimage")
    private String profileImage;
    @OneToOne(cascade = CascadeType.ALL)
<<<<<<< HEAD
    @JoinColumn(name="profiledetails")
    private ProfileDetails profileDetails;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="profileid")
    private List<Post> posts;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="profileid")
    private List<Comments> commentsList;

    public Profile(String name, String email, String bio, String profileImage, ProfileDetails profileDetails, List<Post> posts, List<Comments> commentsList) {
=======
    @JoinColumn(name="profiledetailsid")
    private ProfileDetails profileDetails;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="profileid")
    private Set<Post> posts;


    public Profile(String name, String email, String bio, String profileImage, ProfileDetails profileDetails) {
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.profileImage = profileImage;
        this.profileDetails = profileDetails;
<<<<<<< HEAD
        this.posts = posts;
        this.commentsList = commentsList;
=======

>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
    }
}
