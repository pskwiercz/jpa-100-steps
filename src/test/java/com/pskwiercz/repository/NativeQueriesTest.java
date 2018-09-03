package com.pskwiercz.repository;

import com.pskwiercz.Jpa100StepsApplication;
import com.pskwiercz.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Jpa100StepsApplication.class)
public class NativeQueriesTest {

    @Autowired
    EntityManager em;

    @Test
    public void findAllTest() {
        List courses = em.createNativeQuery("select * from Course").getResultList();
        courses.stream().forEach(System.out::println);
    }

    @Test
    public void findAllTypedTest() {
        List<Course> courses = em
                .createNativeQuery("select * from Course", Course.class)
                .getResultList();
        courses.stream().forEach(System.out::println);
    }

    @Test
    public void whereParameterPositionTest() {
        Query query = em.createNativeQuery("select * from COURSE where id = ?", Course.class);
        query.setParameter(1, 10002L);
        List<Course> courses = query.getResultList();
        courses.stream().forEach(System.out::println);
    }

    @Test
    public void whereParameterNameTest() {
        Query query = em.createNativeQuery("select * from COURSE where id = :id", Course.class);
        query.setParameter("id", 10003L);
        List<Course> courses = query.getResultList();
        courses.stream().forEach(System.out::println);
    }

    @Test
    @Transactional
    public void updateTest() {
        Query query = em.createNativeQuery("update Course set last_updated_date=sysdate()", Course.class);
        int rows = query.executeUpdate();
        System.out.println("Number of updated rows: " + rows);
    }


}