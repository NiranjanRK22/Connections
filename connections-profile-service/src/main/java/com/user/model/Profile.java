package com.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name="profiledetails")
    private ProfileDetails profileDetails;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="profileid")
    private Set<Post> posts;


    public Profile(String name, String email, String bio, String profileImage, ProfileDetails profileDetails) {
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.profileImage = profileImage;
        this.profileDetails = profileDetails;

    }
}
