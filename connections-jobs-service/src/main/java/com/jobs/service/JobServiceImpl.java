package com.jobs.service;


import com.jobs.exceptions.JobNotFoundException;

import com.jobs.model.Company;
import com.jobs.model.EmploymentType;
import com.jobs.model.IndustryType;
import com.jobs.model.Job;
import com.jobs.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService{

    @Autowired
    private IJobRepository jobRepository;

    /**
     *
     * @param job
     * @return
     * @throws JobNotFoundException
     */
    @Override
    public Job addJob(Job job) throws JobNotFoundException {
        return jobRepository.save(job);
    }


    /**
     *
     * @param job
     * @throws JobNotFoundException
     */
    @Override
    public void updateJob(Job job) throws JobNotFoundException {
        jobRepository.save(job);
    }

    /**
     *
     * @param jobId
     * @throws JobNotFoundException
     */
    @Override
    public void deleteJob(int jobId) throws JobNotFoundException {
        jobRepository.deleteById(jobId);
    }

    /**
     *
     * @return Returns all the jobs in the database
     */
    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    /**
     *
     * @param jobId job Id in the Job
     * @return Returns a job object found in the databases
     * @throws JobNotFoundException if no job is found in the database based on the provided info
     */
    @Override
    public Job getByJobId(int jobId) throws JobNotFoundException {
        return jobRepository.findById(jobId).orElseThrow(()->{
            throw new JobNotFoundException();
        });
    }

    /**
     *
     * @param title Title in the Job
     * @return Returns a list of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByTitle(String title) throws JobNotFoundException {
       List<Job>jobs= jobRepository.findByTitle(title);
       if (jobs.isEmpty())
           throw  new JobNotFoundException("No "+title+" jobs found");
        return jobs;
    }

    /**
     *
     * @param employmentType Employment type in the Job
     * @return Return a list of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByEmploymentType(String employmentType) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByEmploymentType(EmploymentType.valueOf(employmentType));
        if(jobs.isEmpty())
            throw  new JobNotFoundException(employmentType +" jobs not found");
        return jobs;
    }

    /**
     * \
     * @param industryType Industry type in the Company
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByIndustryType(String industryType) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByIndustryType(IndustryType.valueOf(industryType));
        if(jobs.isEmpty())
            throw  new JobNotFoundException(industryType +" jobs not found");
        return jobs;
    }

    /**
     *
     * @param foundedYear Founded year in the Company
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByFoundedYear(int foundedYear) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByFoundedYear(foundedYear);
        if(jobs.isEmpty())
            throw  new JobNotFoundException( "No  jobs  found with given input");
        return jobs;
    }

    /**
     *
     * @param location Location in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByLocation(String location) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByLocation(location);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found in "+ location);
        return jobs;
    }

    @Override
    public Company getByCompanyName(String companyName) throws JobNotFoundException {
        return jobRepository.findByCompanyName(companyName);
    }

    /**
     *
     * @param company Company name in the Company
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByCompany(String company) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByCompany(company);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs posted by "+company );
        return jobs;
    }

    /**
     *
     * @param employmentType Employment type in the Job
     * @param location Location in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByTypeAndLocation(String employmentType, String location) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByTypeAndLocation(EmploymentType.valueOf(employmentType),location);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No "+ employmentType +" jobs found in " +location);
        return jobs;
    }

    /**
     *
     * @param company Company name in the Job
     * @param location Location in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByCompanyAndLocation(String company, String location) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByCompanyAndLocation(company,location);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs posted by "+company+" in " +location);
        return jobs;
    }

    /**
     *
     * @param employmentType Employment type in the Job
     * @param company Company name in the Company
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByTypeAndCompany(String employmentType, String company) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByTypeAndCompany(EmploymentType.valueOf(employmentType),company);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No "+ employmentType +" jobs posted by " +company);
        return jobs;
    }

    /**
     * ]
     * @param industryType Industry type in the Company
     * @param employmentType Employment type in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByIndustryAndEmploymentType(String industryType, String employmentType) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByIndustryAndEmploymentType(IndustryType.valueOf(industryType),EmploymentType.valueOf(employmentType));
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No "+ employmentType + "jobs found in " +industryType);
        return jobs;
    }

    /**
     *
     * @param industryType Industry type in the Company
     * @param location Location in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByIndustryAndLocation(String industryType, String location) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByIndustryAndLocation(IndustryType.valueOf(industryType),location);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No "+ industryType + "jobs found in " +location);
        return jobs;
    }

    /**
     *
     * @param foundedYear Founded year in the Company
     * @param location Location in the databases
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByFoundedYearAndLocation(int foundedYear, String location) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByFoundedYearAndLocation(foundedYear,location);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found in " +location );
        return jobs;
    }

    /**
     *
     * @param experience Experience in the Job
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByExperience(double experience) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByExperience(experience);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found for " +experience+ " experience" );
        return jobs;
    }

    /**
     *
     * @param minSalary Salary in the JobDetails
     * @param maxSalary Salary in the JobDetails
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getBySalaryRange(double minSalary, double maxSalary) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findBySalaryRange(minSalary,maxSalary);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found for " +minSalary+ " - "+maxSalary +" salary range" );
        return jobs;
    }

    /**
     *
     * @param vacancies Vacancies in the JobDetails
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByVacancy(int vacancies) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByVacancy(vacancies);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found with " +vacancies+ " vacancies" );
        return jobs;
    }

    /**
     *
     * @param experience Experience in the JobDetails
     * @param minSalary Salary in the JobDetails
     * @param maxSalary Salary in the JobDetails
     * @return Return a List of Jobs found in the databases
     * @throws JobNotFoundException If no job found in the database based on the provided info
     */
    @Override
    public List<Job> getByExperienceAndSalary(double experience,double minSalary, double maxSalary) throws JobNotFoundException {
        List<Job>jobs= jobRepository.findByExperienceAndSalary(experience,minSalary,maxSalary);
        if(jobs.isEmpty())
            throw  new JobNotFoundException("No jobs found with vacancies" );
        return jobs;
    }

}
