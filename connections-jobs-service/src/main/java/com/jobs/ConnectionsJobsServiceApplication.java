package com.jobs;

import com.jobs.model.*;
import com.jobs.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConnectionsJobsServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsJobsServiceApplication.class, args);
	}

	@Autowired
	private IJobService jobService;

	@Override
	public void run(String... args) throws Exception {

		Company company = new Company("Google","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/375px-Google_2015_logo.svg.png",
				"California", IndustryType.INFORMATIONSECURITY,1998);
		JobDetails jobDetails= new JobDetails(2,1,1000000,1.0);

		Job job= new Job("Customer Engineer", EmploymentType.PARTTIME,"Experience in web application development/integration and with software development platforms/solutions.\n" +
				"Experience in data and information management, as it relates to Big Data trends and issues within businesses.","hyderabad",jobDetails,company);

		jobService.addJob(job);
	}
}
