package com.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Comments {
    @Id
    @GeneratedValue(generator = "comment_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="comment_seq",sequenceName = "comment_sequence",initialValue = 501,allocationSize = 1)
    @Column(name = "commentid")
    private Integer commentId;
    private String comment;
    @Column(name="commenttime")
    private LocalDateTime commentTime;
    @ManyToOne
    @JoinColumn(name="postid")
    private List<Post> posts;
    @ManyToOne
    @JoinColumn(name="profileid")
    private List<Profile> profiles;

    public Comments(String comment, LocalDateTime commentTime, List<Post> posts, List<Profile> profiles) {
        this.comment = comment;
        this.commentTime = commentTime;
        this.posts = posts;
        this.profiles = profiles;
    }
}
