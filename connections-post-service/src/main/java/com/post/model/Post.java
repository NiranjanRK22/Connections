package com.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

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
    Set<Like> likes;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postid")
    Set<Comments> comments;
    @ManyToOne
    @JoinColumn(name="profileid")
    Profile profile;

    public Post(String title, String description, String topic, Set<Like> likes, Set<Comments> comments, Profile profile) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.likes = likes;
        this.comments = comments;
        this.profile = profile;
    }
}
