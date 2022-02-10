package com.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 *
 */

@Entity
public class Profile {
    @Id
    @GeneratedValue(generator = "profile_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "profile_seq", sequenceName = "profile_sequence", initialValue = 101, allocationSize = 1)
    @Column(name = "profileid")
    private Integer profileId;
    private String name;
    private String email;
    private String bio;
    @Column(name = "profileimage")
    private String profileImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profiledetailsid")
    private ProfileDetails profileDetails;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profileid")
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
        this.password = password;

    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
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
