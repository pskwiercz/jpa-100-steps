package com.pskwiercz.repository;

import com.pskwiercz.Jpa100StepsApplication;
import com.pskwiercz.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Jpa100StepsApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repo;

    @Test
    public void findByIdTest() {
        Course course = repo.findById(10001L);
        assertNotNull(course);
        assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    public void removeByIdTest() {
        Course course = repo.findById(10002L);
        assertNotNull(course);
        repo.removeById(10002L);
        course = repo.findById(10002L);
        assertNull(course);
    }

    @Test
    public void saveTest() {
        Course course = repo.findById(10003L);
        assertEquals("Spring in 50 steps", course.getName());

        course.setName("Spring in 50 steps - updated");
        repo.save(course);

        Course course1 = repo.findById(10003L);
        assertEquals("Spring in 50 steps - updated", course1.getName());
    }
}