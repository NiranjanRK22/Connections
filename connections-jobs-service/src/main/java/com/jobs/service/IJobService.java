package com.jobs.service;

import com.jobs.exceptions.JobNotFoundException;
import com.jobs.model.Company;
import com.jobs.model.Job;

import java.util.List;

public interface IJobService {

    Job addJob(Job job) throws JobNotFoundException;

    void updateJob(Job job) throws JobNotFoundException;

    void deleteJob(int jobId) throws JobNotFoundException;

    List<Job> getAll();

    Job getByJobId(int jobId) throws JobNotFoundException;

    List<Job> getByTitle(String title) throws JobNotFoundException;

    List<Job> getByEmploymentType(String employmentType) throws JobNotFoundException;

    List<Job> getByIndustryType(String industryType) throws JobNotFoundException;

    List<Job> getByFoundedYear(int foundedYear) throws JobNotFoundException;

    List<Job> getByLocation(String location) throws JobNotFoundException;

    List<Job> getByCompany(String company) throws JobNotFoundException;

    Company getByCompanyName(String companyName) throws JobNotFoundException;

    List<Job> getByTypeAndLocation(String employmentType, String location) throws JobNotFoundException;

    List<Job> getByCompanyAndLocation(String company, String location) throws JobNotFoundException;

    List<Job> getByTypeAndCompany(String employmentType, String company) throws JobNotFoundException;

    List<Job> getByIndustryAndEmploymentType(String industryType, String employmentType) throws JobNotFoundException;

    List<Job> getByIndustryAndLocation(String industryType, String location) throws JobNotFoundException;

    List<Job> getByFoundedYearAndLocation(int foundedYear, String location) throws JobNotFoundException;

    List<Job> getByExperience(double experience) throws JobNotFoundException;

    List<Job> getBySalaryRange(double minSalary, double maxSalary) throws JobNotFoundException;

    List<Job> getByVacancy(int vacancies) throws JobNotFoundException;

    List<Job> getByExperienceAndSalary(double experience, double minSalary, double maxSalary) throws JobNotFoundException;
}
