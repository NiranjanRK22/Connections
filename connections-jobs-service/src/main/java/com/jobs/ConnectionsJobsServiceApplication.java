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

		Company company = new Company("Amazon","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Amazon_logo.svg/263px-Amazon_logo.svg.png",
				"Seatle", IndustryType.ECOMMERCE,1994);
		JobDetails jobDetails= new JobDetails(2,3,500000,3.4);

		Job job= new Job("Software development manager", EmploymentType.FULLTIME,"3+ years of people management experience, managing engineers\n" +
				"· Experience in partnering with product and program management teams","hyderabad",jobDetails,company);

	//	jobService.addJob(job);
	}
}
