package com.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="reaction")
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
    Post post;
    @ManyToOne
    @JoinColumn(name="profileid")
    Profile profile;

    public Like(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }
}
