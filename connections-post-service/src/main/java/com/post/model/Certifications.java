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
public class Certifications {
    @Id
    @GeneratedValue(generator = "certification_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="certification_seq",sequenceName = "certification_sequence",initialValue = 101,allocationSize = 1)
    @Column(name = "certificationsid")
    private Integer certificationsId;
    private String certificationName;

    public Certifications() {
    }

    public Certifications(String certificationName) {
        this.certificationName = certificationName;
    }

}
