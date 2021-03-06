package com.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private LocalDateTime commentTime;
    @ManyToOne
    @JoinColumn(name = "postid")
    @JsonIgnore

    private Post post;
    @ManyToOne
    @JoinColumn(name = "profileid")
    @JsonIgnore

    private Profile profile;

    public Comments() {
    }

    public Comments(String comment, LocalDateTime commentTime) {
        this.comment = comment;
        this.commentTime = commentTime;

    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment='" + comment + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
