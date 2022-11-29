package ru.vladislav.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.vladislav.models.Emploee;
import ru.vladislav.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class EmploeeDAO {

    public Emploee findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Emploee.class, id);
    }

    public Emploee save(Emploee emploee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(emploee);
        tx1.commit();
        session.close();
        return findById(emploee.getId());
    }

    public Emploee update(Emploee emploee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(emploee);
        tx1.commit();
        session.close();
        return findById(emploee.getId());
    }

    public Emploee delete(long id) {
        Emploee emploee = findById(id);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(emploee);
        tx1.commit();
        session.close();
        return emploee;
    }

    public List<Emploee> getAll() {
        List<Emploee> emploees = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select e from Emploee e", Emploee.class).getResultList();
        return emploees;
    }
}
