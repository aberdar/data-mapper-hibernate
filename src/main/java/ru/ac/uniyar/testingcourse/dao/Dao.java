package ru.ac.uniyar.testingcourse.dao;

import org.hibernate.Session;
import ru.ac.uniyar.testingcourse.entity.Course;
import ru.ac.uniyar.testingcourse.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class Dao {
    public void enrollStudent(Course course, int studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            course = session.get(Course.class, course.getCourseId());

            if (!course.getEnrollments().contains(studentId) && !course.getWaitingList().contains(studentId)) {
                if (course.isFullyEnrolled()) {
                    course.getWaitingList().add(studentId);
                } else {
                    course.getEnrollments().add(studentId);
                }
            }

            session.getTransaction().commit();
        }
    }

    public boolean isFullyEnrolled(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, course.getCourseId());
            return course.isFullyEnrolled();
        }
    }

    public boolean hasWaitingList(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, course.getCourseId());
            return course.hasWaitingList();
        }
    }

    public List<Integer> getEnrollments(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, course.getCourseId());
            return Collections.unmodifiableList(course.getEnrollments());
        }
    }

    public List<Integer> getWaitingList(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, course.getCourseId());
            return Collections.unmodifiableList(course.getWaitingList());
        }
    }
}
