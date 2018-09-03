package com.pskwiercz.repository;

import com.pskwiercz.Jpa100StepsApplication;
import com.pskwiercz.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Jpa100StepsApplication.class)
public class JPQLTest {

    @Autowired
    EntityManager em;

    @Test
    public void findAllTest() {
        List courses = em.createQuery("select c from Course c").getResultList();
        courses.stream().forEach(System.out::println);

    }

    @Test
    public void findAllTypedTest() {
        List<Course> courses = em.createQuery("select c from Course c", Course.class).getResultList();
        courses.stream().forEach(System.out::println);

    }

    @Test
    public void whereTest() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where name like '%updated'", Course.class);
        List<Course> courses = query.getResultList();
        courses.stream().forEach(System.out::println);

    }
}