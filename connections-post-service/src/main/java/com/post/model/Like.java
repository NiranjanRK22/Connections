package com.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;



@Table(name="reaction")
@Entity
public class Like {
    @Id
    @GeneratedValue(generator = "like_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="like_seq",sequenceName = "like_sequence",initialValue = 401,allocationSize = 1)
    @Column(name = "likeid")
    private Integer likeId;
    @Column(name="liketime")
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalDateTime likeTime;
    @ManyToOne
    @JoinColumn(name="postid")
    @JsonIgnore
    Post post;
    @ManyToOne
    @JoinColumn(name="profileid")
    @JsonIgnore
    Profile profile;

    public Like() {
    }

    public Like(LocalDateTime likeTime) {
        this.likeTime = likeTime;

    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public void setLikeTime(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public LocalDateTime getLikeTime() {
        return likeTime;
    }

    public Post getPost() {
        return post;
    }

    public Profile getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "Like{" +"likeTime=" + likeTime +'}';
    }
}
