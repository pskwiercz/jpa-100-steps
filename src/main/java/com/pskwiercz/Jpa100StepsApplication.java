package com.pskwiercz;

import com.pskwiercz.entity.Course;
import com.pskwiercz.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jpa100StepsApplication implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger("App");

    @Autowired
    CourseRepository courseRepo;

    public static void main(String[] args) {
        SpringApplication.run(Jpa100StepsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        courseRepo.save(new Course("Course 1"));
        courseRepo.save(new Course("Course 2"));

        courseRepo.findAll().stream().forEach(x -> log.info(x.toString()));

        log.info("Find by id: " + courseRepo.findById(2L));

        courseRepo.removeById(1L);

        courseRepo.findAll().stream().forEach(x -> log.info(x.toString()));
    }
}
