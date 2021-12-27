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
@NoArgsConstructor
@Table(name="reaction")
@Entity
public class Like {
    @Id
    @GeneratedValue(generator = "like_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="like_seq",sequenceName = "like_sequence",initialValue = 401,allocationSize = 1)
    @Column(name = "likeid")
    private Integer likeId;
    @Column(name="liketime")
    private LocalDateTime likeTime;
    @ManyToOne
    @JoinColumn(name="postid")
    @JsonIgnore
    Post post;
    @ManyToOne
    @JoinColumn(name="profileid")
    @JsonIgnore

    Profile profile;

    public Like(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeTime=" + likeTime +
                '}';
    }
}
