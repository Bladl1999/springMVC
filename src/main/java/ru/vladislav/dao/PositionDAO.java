package ru.vladislav.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.vladislav.models.Position;
import ru.vladislav.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class PositionDAO {

    public Position findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Position.class, id);
    }

    public Position save(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(position);
        tx1.commit();
        session.close();
        return findById(position.getId());
    }

    public Position update(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(position);
        tx1.commit();
        session.close();
        return findById(position.getId());
    }

    public Position delete(long id) {
        Position position = findById(id);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(position);
        tx1.commit();
        session.close();
        return position;
    }


    public List<Position> getAll() {
        List<Position> positions = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select p from Position p", Position.class).getResultList();
        return positions;
    }


}
