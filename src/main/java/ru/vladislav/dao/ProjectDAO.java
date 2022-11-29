package ru.vladislav.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.vladislav.models.Project;
import ru.vladislav.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class ProjectDAO {

    public Project findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Project.class, id);
    }

    public Project save(Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(project);
        tx1.commit();
        session.close();
        return findById(project.getId());
    }

    public Project update(Project project) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(project);
        tx1.commit();
        session.close();
        return findById(project.getId());
    }

    public Project delete(long id) {
        Project project = findById(id);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(project);
        tx1.commit();
        session.close();
        return project;
    }

    public List<Project> getAll() {
        List<Project> projects = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select p from Project p", Project.class).getResultList();
        return projects;
    }
}
