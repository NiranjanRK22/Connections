package com.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Set;
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
<<<<<<< HEAD
=======
@Table(name="reaction")
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
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
<<<<<<< HEAD
    List<Post> posts;
    @ManyToOne
    @JoinColumn(name="profileid")
    List<Profile> profiles;
=======
    Post post;
    @ManyToOne
    @JoinColumn(name="profileid")
    Profile profile;

    public Like(LocalDateTime likeTime) {
        this.likeTime = likeTime;
    }
>>>>>>> b9fd5c55d4a35b5f4d040cecd1fb74696920a598
}
