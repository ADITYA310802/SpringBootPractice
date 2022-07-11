package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.user;

@SpringBootApplication
public class BootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaApplication.class, args);

		UserRepo userRepo = context.getBean(UserRepo.class);

		user use = new user();

		use.setName("Anmol");
		use.setCity("Dehradun");
		use.setStatus("Python ML");

		user use3 = new user();

		use3.setName("Aahna");
		use3.setCity("Lucknow");
		use3.setStatus("java");

		// saving multiple users

		List<user> users = List.of(use, use3);

		Iterable<user> result = userRepo.saveAll(users);

		result.forEach(useri -> {
			System.out.println(useri);
		});

		// saving a single user

		user use2 = userRepo.save(use);
		System.out.println(use2);

		user use4 = userRepo.save(use3);

		// updation

		Optional<user> optional = userRepo.findById(7);
		user ret = optional.get();

		ret.setName("Anmol Singhal");

		System.out.println(ret);

		userRepo.save(ret);

		// Reading all data

		Iterable<user> all = userRepo.findAll();

		all.forEach(useri -> {
			System.out.println(useri);
		});

		// deleting user element

		userRepo.deleteById(8);
		System.out.println("deleted successfully");

		List<user> all2 = userRepo.findByNameAndCity("Anmol Singhal", "Dehradun");
		all2.forEach(e -> System.out.println(e));

		List<user> all3 = userRepo.gettAllUser();

		all3.forEach(e -> {
			System.out.println(e);
		});

	}

}
