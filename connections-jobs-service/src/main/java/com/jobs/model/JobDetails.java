package com.jobs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "jobdetails")
public class JobDetails {
    @Id
    @GeneratedValue(generator = "jobdetails_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="jobdetails_seq",sequenceName = "jobdetails_sequence",initialValue = 201,allocationSize = 1)
    @Column(name = "jobdetailsid")
    private Integer jobDetailsId;

    private double experience;

    private int vacancies;

    private double salary;

    private double rating;

    public JobDetails(double experience, int vacancies, double salary, double rating) {
        this.experience = experience;
        this.vacancies = vacancies;
        this.salary = salary;
        this.rating = rating;
    }

    public JobDetails() {
    }
}
