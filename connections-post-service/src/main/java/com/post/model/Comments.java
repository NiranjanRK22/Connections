package com.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Comments {
    @Id
    @GeneratedValue(generator = "comment_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_sequence", initialValue = 501, allocationSize = 1)
    @Column(name = "commentid")
    private Integer commentId;
    private String comment;
    @Column(name = "commenttime")
//    @JsonSerialize(using = LocalTimeSerializer.class)
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private LocalDateTime commentTime;
    @ManyToOne
    @JoinColumn(name = "postid")

    private Post post;
    @ManyToOne
    @JoinColumn(name = "profileid")

    private Profile profile;

    public Comments() {
    }

    public Comments(String comment, LocalDateTime commentTime) {
        this.comment = comment;
        this.commentTime = commentTime;

    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment='" + comment + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
