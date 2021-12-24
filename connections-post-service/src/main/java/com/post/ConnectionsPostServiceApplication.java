package com.post;

import com.post.model.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionsPostServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ConnectionsPostServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Post post = new Post();
	}
}
