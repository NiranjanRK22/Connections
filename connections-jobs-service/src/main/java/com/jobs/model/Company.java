package com.jobs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity

@Getter
@Setter
@ToString

public class Company {
    @Id
    @GeneratedValue(generator = "company_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "company_seq", sequenceName = "company_sequence", initialValue = 501, allocationSize = 1)
    @Column(name = "companyid")
    private Integer companyId;

    @Column(name = "companyname", length = 50)
    private String companyName;

    private String logo;

    @Column(name = "headquarters", length = 30)
    private String headQuarters;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private IndustryType industryType;

    private int foundedYear;

    @OneToMany( fetch = FetchType.EAGER)

    private Set<Job> jobs;

    public Company() {
    }

    public Company(String companyName, String logo, String headQuarters, IndustryType industryType, int foundedYear) {
        this.companyName = companyName;
        this.logo = logo;
        this.headQuarters = headQuarters;
        this.industryType = industryType;
        this.foundedYear = foundedYear;
    }
}
