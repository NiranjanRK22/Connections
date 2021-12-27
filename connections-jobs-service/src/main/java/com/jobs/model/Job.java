package com.jobs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Setter
@Getter
@NoArgsConstructor

public class Job {
    @Id
    @GeneratedValue(generator = "job_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "job_seq", sequenceName = "job_sequence", initialValue = 101, allocationSize = 1)
    @Column(name = "jobid")
    private Integer jobId;

    @Column(length = 50)
    private String title;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    private String description;

    @Column(length = 30)
    private String location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyid")
    Company company;

    @OneToOne(cascade = CascadeType.ALL)
    JobDetails jobDetails;

    public Job(String title, EmploymentType employmentType, String description, String location,  JobDetails jobDetails,Company company) {
        this.title = title;
        this.employmentType = employmentType;
        this.description = description;
        this.location = location;
        this.company = company;
        this.jobDetails = jobDetails;
    }
}
