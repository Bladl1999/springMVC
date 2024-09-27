package ru.vladislav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vladislav.dao.ProjectDAO;
import ru.vladislav.models.Project;
import ru.vladislav.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Project save(Project project) {
        return projectDAO.save(project);
    }

    public Project update(Project project) {
        return projectDAO.update(project);
    }

    public List<Project> getAll() {
        return projectDAO.getAll();
    }

    public Project getById(long id) {
        return projectDAO.findById(id);
    }

    public Project delete(long id) {
        return projectDAO.delete(id);
    }
}
