package ru.vladislav.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.vladislav.models.Customer;
import ru.vladislav.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class CustomerDAO {

    public Customer findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public Customer save(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
        return findById(customer.getId());
    }

    public Customer update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
        return findById(customer.getId());
    }

    public Customer delete(Long id) {
        Customer customer = findById(id);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
        return customer;
    }

    public List<Customer> getAll() {
        List<Customer> customers = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select u from Customer u", Customer.class).getResultList();
        return customers;
    }

}
