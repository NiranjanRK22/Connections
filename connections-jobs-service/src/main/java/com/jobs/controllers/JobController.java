package com.jobs.controllers;

import com.jobs.exceptions.JobNotFoundException;
import com.jobs.model.Job;
import com.jobs.service.IJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("job-api")
public class JobController {

    @Autowired
    private IJobService jobService;

    private Logger logger = LoggerFactory.getLogger(JobController.class);

    @PostMapping("/jobs")
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        logger.debug("inside add job ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new job");
        Job njob = jobService.addJob(job);
        logger.info("adding a job "+njob);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(njob);
    }

    @PutMapping("/jobs")
    public ResponseEntity<Job> updateJob(Job job) {
        logger.debug("inside update job ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Updating a job");
        jobService.updateJob(job);
        logger.info("updating a job");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/jobs/{jobid}")
    public ResponseEntity<Job> deleteJob(int jobId) {
        logger.debug("inside delete job ");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Deleting a job");
        logger.info("deleting a job by id"+jobId);
        jobService.deleteJob(jobId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @GetMapping("/jobs")
    List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping("/jobs/id/{jobid}")
    ResponseEntity<Job> getByJobId(@PathVariable("jobid") int jobId) {
        logger.debug("inside get job by id");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting job by id");
        Job job = jobService.getByJobId(jobId);
        logger.info("getting a job by id"+job);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(job);
    }

    @GetMapping("/jobs/title/{title}")
    ResponseEntity<List<Job>> getByTitle(@PathVariable("title") String title) {
        logger.debug("inside get job by title");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by job title");
        List<Job> jobs = jobService.getByTitle(title);
        logger.info("getting a jobs by titles"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }


    @GetMapping("/jobs/employmenttype/{employmenttype}")
    ResponseEntity<List<Job>> getByEmploymentType(@PathVariable("employmenttype") String employmentType) {
        logger.debug("inside get job by employment type");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by employment type");
        List<Job> jobs = jobService.getByEmploymentType(employmentType);
        logger.info("getting a jobs by employment type"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/industrytype/{industrytype}")
    ResponseEntity<List<Job>> getByIndustryType(@PathVariable("industrytype") String industryType) {
        logger.debug("inside get job by industry type");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by employment type");
        List<Job> jobs = jobService.getByIndustryType(industryType);
        logger.info("getting a jobs by industry type"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/foundedyear/{foundedyear}")
    ResponseEntity<List<Job>> getByFoundedYear(@PathVariable("foundedyear") int getByFoundedYear) {
        logger.debug("inside get job by founding year");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by employment type");
        List<Job> jobs = jobService.getByFoundedYear(getByFoundedYear);
        logger.info("getting a jobs by founding year"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/location/{location}")
    ResponseEntity<List<Job>> getByLocation(@PathVariable("location") String location) {
        logger.debug("inside get job by location");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by location");
        List<Job> jobs = jobService.getByLocation(location);
        logger.info("getting a jobs by location"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/company/{company}")
    ResponseEntity<List<Job>> getByCompany(@PathVariable("company") String company) {
        logger.debug("inside get job by company");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by company");
        List<Job> jobs = jobService.getByCompany(company);
        logger.info("getting a jobs by company"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/employmenttype/{employmenttype}/location/{location}")
    ResponseEntity<List<Job>> getByTypeAndLocation(@PathVariable("employmenttype") String employmentType, @PathVariable("location") String location) {
        logger.debug("inside get job by employment type and location");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by employment type and location");
        List<Job> jobs = jobService.getByTypeAndLocation(employmentType, location);
        logger.info("getting a jobs by employment type and location"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("/jobs/company/{company}/location/{location}")
    ResponseEntity<List<Job>> getByCompanyAndLocation(@PathVariable("company") String company, @PathVariable("location") String location) {
        logger.debug("inside get job by company and location");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by location and company");
        List<Job> jobs = jobService.getByCompanyAndLocation(company, location);
        logger.info("getting a jobs by company and location"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/employmenttype/{employmenttype}/company/{company}")
    ResponseEntity<List<Job>> getByTypeAndCompany(@PathVariable("employmenttype") String employmentType, @PathVariable("company") String company) {
        logger.debug("inside get job by employment type and company");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by Employment type and company");
        List<Job> jobs = jobService.getByTypeAndCompany(employmentType, company);
        logger.info("getting a jobs by employment type and company"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/industrytype/{industrytype}/employmenttype/{employmenttype}")
    ResponseEntity<List<Job>> getByIndustryAndEmploymentType(@PathVariable("industrytype") String industryType, @PathVariable("employmenttype") String employmentType) {
        logger.debug("inside get job by industry type and employment type");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by Employment type and industry type");
        List<Job> jobs = jobService.getByIndustryAndEmploymentType(industryType,employmentType);
        logger.info("getting a jobs by industry type and employment type"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/industrytype/{industrytype}/location/{location}")
    ResponseEntity<List<Job>> getByIndustryAndLocation(@PathVariable("industrytype") String industryType, @PathVariable("location") String location) {
        logger.debug("inside get job by industry type and location");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by industry type and location");
        List<Job> jobs = jobService.getByIndustryAndLocation(industryType, location);
        logger.info("getting a jobs by industry type and location"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/foundedyear/{foundedyear}/location/{location}")
    ResponseEntity<List<Job>> getByFoundedYearAndLocation(@PathVariable("foundedyear") int foundedYear, @PathVariable("location") String location) {
        logger.debug("inside get job by founding year and location");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by founding year and location");
        List<Job> jobs = jobService.getByFoundedYearAndLocation(foundedYear, location);
        logger.info("getting a jobs by founding year and location"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/experience/{experience}")
    ResponseEntity<List<Job>> getByExperience(@PathVariable("experience") double experience) {
        logger.debug("inside get job by experience");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by experience");
        List<Job> jobs = jobService.getByExperience(experience);
        logger.info("getting a jobs by experience"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/minSalary/{minSalary}/maxSalary/{maxSalary}")
    ResponseEntity<List<Job>> getBySalaryRange(@PathVariable("minSalary") double minSalary, @PathVariable("maxSalary") double maxSalary) {
        logger.debug("inside get job by salary range");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by salary range");
        List<Job> jobs = jobService.getBySalaryRange(minSalary, maxSalary);
        logger.info("getting a jobs by salary range"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/vacancies/{vacancies}")
    ResponseEntity<List<Job>> getByVacancy(@PathVariable("vacancies") int vacancies) {
        logger.debug("inside get job by vacancies");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by vacancies");
        List<Job> jobs = jobService.getByVacancy(vacancies);
        logger.info(" getting jobs by vacancies"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

    @GetMapping("jobs/experience/{experience}/minSalary/{minSalary}/maxSalary/{maxSalary}")
    ResponseEntity<List<Job>> getByExperienceAndSalary(@PathVariable("experience") double experience, @PathVariable("minSalary") double minSalary, @PathVariable("maxSalary") double maxSalary) {
        logger.debug("inside get job by experience and salary range");
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting jobs by experience and salary range");
        List<Job> jobs = jobService.getByExperienceAndSalary(experience, minSalary, maxSalary);
        logger.info("getting a jobs by experience and salary range"+jobs);
        return ResponseEntity.ok().headers(headers).body(jobs);
    }

}
