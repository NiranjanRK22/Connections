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
            @ToString.Exclude
    Set<Like> likes;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="postid")
    @ToString.Exclude

    Set<Comments> comments;
    @ManyToOne
    @JoinColumn(name="profileid")
    @ToString.Exclude

    @JsonIgnore
    Profile profile;

    public Post() {
    }

    public Post(String title, String description, String topic, Set<Like> likes, Set<Comments> comments, Profile profile) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.likes = likes;
        this.comments = comments;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Post{" +"title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
