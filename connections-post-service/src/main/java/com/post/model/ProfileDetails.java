package com.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="profiledetails")
public class ProfileDetails {
    @Id
    @GeneratedValue(generator = "profiledetails_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="profiledetails_seq",sequenceName = "profiledetails_sequence",initialValue = 151,allocationSize = 1)
    @Column(name = "detailsid")
    private Integer detailsId;
    @Column(length=30)
    @Enumerated(EnumType.STRING)
    private OpenTo openTo;
    @Column(length=30)
    private String qualification;
    @Column(length=30)
    @JoinColumn(name = "profiledetailsid")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Skills> skills;
    private int experience;
    @Column(length=30)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "profiledetailsid")
    private Set<Certifications> certifications;

    public ProfileDetails(OpenTo openTo, String qualification, Set<Skills> skills, int experience, Set<Certifications> certifications) {
        this.openTo = openTo;
        this.qualification = qualification;
        this.skills = skills;
        this.experience = experience;
        this.certifications = certifications;
    }
}
