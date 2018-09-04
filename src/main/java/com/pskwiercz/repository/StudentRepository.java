package com.pskwiercz.repository;

import com.pskwiercz.entity.Passport;
import com.pskwiercz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public List<Student> findAll() {
        TypedQuery<Student> find_all_students =
                em.createNamedQuery("find_all_students", Student.class);
        return find_all_students.getResultList();
    }

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        System.out.println(student);
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void removeById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassword() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Barbara");
        student.setPassport(passport);
        em.persist(student);
    }
}
