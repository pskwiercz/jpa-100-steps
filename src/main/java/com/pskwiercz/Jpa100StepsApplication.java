package com.pskwiercz;

import com.pskwiercz.repository.CourseRepository;
import com.pskwiercz.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class Jpa100StepsApplication implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger("App");

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    StudentRepository studentRepo;

    public static void main(String[] args) {
        SpringApplication.run(Jpa100StepsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        courseRepo.playWithEntityManager();
//        courseRepo.findAll().stream().forEach(x -> log.info(x.toString()));

        studentRepo.saveStudentWithPassword();
//        studentRepo.findAll().stream().forEach(x -> log.info(x.toString()));
    }
}
