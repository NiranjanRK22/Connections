package com.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter

@ToString
@Entity

public class Skills {
    @Id
    @GeneratedValue(generator = "skills_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="skills_seq",sequenceName = "skills_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "skillsid")
    private Integer skillsId;
    private String skillName;

    public Skills() {
    }

    public Skills(String skillName) {
        this.skillName = skillName;
    }

}
