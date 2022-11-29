package ru.vladislav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vladislav.dao.EmploeeDAO;
import ru.vladislav.models.Emploee;
import ru.vladislav.service.EmploeeService;

import java.util.List;

@Service
public class EmploeeServiceImpl implements EmploeeService {

    private EmploeeDAO emploeeDAO;

    @Autowired
    public EmploeeServiceImpl(EmploeeDAO emploeeDAO) {
        this.emploeeDAO = emploeeDAO;
    }

    public Emploee save(Emploee emploee) {
        return emploeeDAO.save(emploee);
    }

    public Emploee update(Emploee emploee) {
        return emploeeDAO.update(emploee);
    }

    public List<Emploee> getAll() {
        return emploeeDAO.getAll();
    }

    public Emploee getById(long id) {
        return emploeeDAO.findById(id);
    }

    public Emploee delete(long id) {
        return emploeeDAO.delete(id);
    }
}
