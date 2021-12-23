package com.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Set;
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "post_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="post_seq",sequenceName = "post_sequence",initialValue = 301,allocationSize = 1)
    @Column(name = "postid")
    Integer postId;
    String title;
    String description;
    String topic;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postid")
<<<<<<< HEAD
    List<Like> likes;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postid")
    List<Comments> commentsList;
    @ManyToOne
    @JoinColumn(name="profileid")
    List<Profile> profiles;

    public Post(String title, String description, String topic, List<Like> likes, List<Comments> commentsList, List<Profile> profiles) {
=======
    Set<Like> likes;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postid")
    Set<Comments> comments;
    @ManyToOne
    @JoinColumn(name="profileid")
    Profile profile;

    public Post(String title, String description, String topic, Set<Like> likes, Set<Comments> commentsList, Profile profiles) {
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.likes = likes;
<<<<<<< HEAD
        this.commentsList = commentsList;
        this.profiles = profiles;
=======
        this.comments = commentsList;
        this.profile = profiles;
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
    }
}
