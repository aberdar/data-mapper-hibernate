package ru.ac.uniyar.testingcourse.dao;

import org.hibernate.Session;
import ru.ac.uniyar.testingcourse.entity.Student;
import ru.ac.uniyar.testingcourse.util.HibernateUtil;

public class StudentDao {
    public void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public Student getStudentById(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, studentId);
        }
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        saveStudent(student);
    }
}
