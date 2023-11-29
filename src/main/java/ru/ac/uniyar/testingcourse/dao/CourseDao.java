package ru.ac.uniyar.testingcourse.dao;

import org.hibernate.Session;
import ru.ac.uniyar.testingcourse.entity.Course;
import ru.ac.uniyar.testingcourse.util.HibernateUtil;

public class CourseDao {

    public void saveCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        }
    }
}
