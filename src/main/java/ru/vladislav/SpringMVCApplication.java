package ru.vladislav;

import org.hibernate.SessionFactory;
import ru.vladislav.utils.HibernateSessionFactoryUtil;

public class SpringMVCApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        sessionFactory.close();
    }
}
