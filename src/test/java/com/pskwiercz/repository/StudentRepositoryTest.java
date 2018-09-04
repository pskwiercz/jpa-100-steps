package com.pskwiercz.repository;

import com.pskwiercz.Jpa100StepsApplication;
import com.pskwiercz.entity.Course;
import com.pskwiercz.entity.Passport;
import com.pskwiercz.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Jpa100StepsApplication.class)
public class StudentRepositoryTest {

    private Logger log = LoggerFactory.getLogger("StudentRepositoryTest");

    @Autowired
    StudentRepository repo;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void someTest() {
        // Hibernate: Session & SessionFactory
        // JPA: EntityManager & PersistenceContext

        // Persistence context(student)
        Student student = em.find(Student.class, 2001L);
        // Persistence context(student, passport)
        Passport passport = student.getPassport();
        // Persistence context(student, passport-updated)
        passport.setNumber("X123456");
        // Persistence context(student-updated, passport-updated)
        student.setName("Ranga - Updated");
    }

    @Test
    @Transactional
    public void retriveStudentWithPassport() {
        Student student = repo.findById(2001L);
        assertNotNull(student);
        assertEquals("Ranga", student.getName());
        log.info("=========" + student.toString());
    }
}