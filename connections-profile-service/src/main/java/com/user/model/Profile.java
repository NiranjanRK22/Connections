package com.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
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
    @JoinColumn(name="profiledetailsid")
    private ProfileDetails profileDetails;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="profileid")
    @JsonIgnore
    private Set<Post> posts;
//    @JsonIgnore
    private String password;

    public Profile() {
    }

    public Profile(String name, String email, String bio, String profileImage, ProfileDetails profileDetails,String password) {
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.profileImage = profileImage;
        this.profileDetails = profileDetails;
        this.password=password;

    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", profileDetails=" + profileDetails +
                ", posts=" + posts +
                ", password='" + password + '\'' +
                '}';
    }
}
