package com.mdb.Animdb;

import com.mdb.Animdb.model.fakeDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimdbApplication {

 public	fakeDB db = new fakeDB();
	public static void main(String[] args) {
		SpringApplication.run(AnimdbApplication.class, args);
	}

}
