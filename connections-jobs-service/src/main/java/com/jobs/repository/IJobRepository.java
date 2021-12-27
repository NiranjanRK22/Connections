package com.jobs.repository;

import com.jobs.exceptions.JobNotFoundException;
import com.jobs.model.EmploymentType;
import com.jobs.model.IndustryType;
import com.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepository extends JpaRepository<Job, Integer> {

    @Query("from Job j where j.title LIKE %?1%")
    List<Job> findByTitle(String title) throws JobNotFoundException;

    @Query("from Job j where j.employmentType = ?1")
    List<Job> findByEmploymentType(EmploymentType employmentType) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where c.industryType = ?1 ")
    List<Job> findByIndustryType(IndustryType industryType) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where c.foundedYear =?1 ")
    List<Job> findByFoundedYear(int foundedYear) throws JobNotFoundException;

    List<Job> findByLocation(String location) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where c.companyName LIKE %?1%")
    List<Job> findByCompany(String company) throws JobNotFoundException;

    @Query("from Job j where j.employmentType=?1 and j.location=?2")
    List<Job> findByTypeAndLocation(EmploymentType employmentType, String location) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where c.companyName LIKE %?1% and j.location=?2")
    List<Job> findByCompanyAndLocation(String company, String location) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where j.employmentType=?1 and c.companyName=?2")
    List<Job> findByTypeAndCompany(EmploymentType employmentType, String company) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where j.employmentType=?2 and c.industryType=?1")
    List<Job> findByIndustryAndEmploymentType(IndustryType industryType, EmploymentType employmentType) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where j.location=?2 and c.industryType=?1")
    List<Job> findByIndustryAndLocation(IndustryType industryType, String location) throws JobNotFoundException;

    @Query("from  Job j inner join j.company c where c.foundedYear =?1 and j.location=?2")
    List<Job> findByFoundedYearAndLocation(int foundedYear, String location) throws JobNotFoundException;

    @Query("from Job j inner join j.jobDetails jd where jd.experience<?1")
    List<Job> findByExperience(double experience) throws JobNotFoundException;

    @Query("from Job j inner join j.jobDetails jd where jd.salary between ?1 and ?2")
    List<Job> findBySalaryRange(double minSalary, double maxSalary) throws JobNotFoundException;

    @Query("from Job j inner join j.jobDetails jd where jd.vacancies <?1")
    List<Job> findByVacancy(int vacancies) throws JobNotFoundException;

    @Query("from Job j inner join j.jobDetails jd where jd.experience<?1 and (jd.salary between ?2 and ?3)")
    List<Job> findByExperienceAndSalary(double experience, double minSalary, double maxSalary) throws JobNotFoundException;


}
