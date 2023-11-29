package ru.ac.uniyar.testingcourse.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
