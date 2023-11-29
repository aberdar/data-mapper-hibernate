package ru.ac.uniyar.testingcourse;

import org.hibernate.SessionFactory;
import ru.ac.uniyar.testingcourse.dao.CourseDao;
import ru.ac.uniyar.testingcourse.dao.Dao;
import ru.ac.uniyar.testingcourse.dao.StudentDao;
import ru.ac.uniyar.testingcourse.entity.Course;
import ru.ac.uniyar.testingcourse.util.HibernateUtil;

public class Main {
    private static final Dao dao = new Dao();
    private static final StudentDao studentDao = new StudentDao();
    private static final CourseDao courseDao = new CourseDao();

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Course course = new Course(10);

        courseDao.saveCourse(course);
        studentDao.addStudent("Test1");

        dao.enrollStudent(course, 1);
    }
}
