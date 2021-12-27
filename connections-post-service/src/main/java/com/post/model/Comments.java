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


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(generator = "comment_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="comment_seq",sequenceName = "comment_sequence",initialValue = 501,allocationSize = 1)
    @Column(name = "commentid")
    private Integer commentId;
    private String comment;
    @Column(name="commenttime")
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalDateTime commentTime;
    @ManyToOne
    @JoinColumn(name="postid")
    @JsonIgnore
    private Post post;
    @ManyToOne
    @JoinColumn(name="profileid")
    @JsonIgnore
    private Profile profile;

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
