package com.pskwiercz.repository;

import com.pskwiercz.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public List<Course> findAll() {
        TypedQuery<Course> find_all_courses =
                em.createNamedQuery("find_all_courses", Course.class);
        return find_all_courses.getResultList();
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        System.out.println(course);
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void removeById(Long id) {
        Course c = findById(id);
        em.remove(c);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);

        Course course2 = findById(10001L);
        course2.setName("JPA 50 steps - updated");
    }
}
