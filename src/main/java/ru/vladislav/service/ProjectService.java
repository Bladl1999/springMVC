package ru.vladislav.service;

import ru.vladislav.models.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project update(Project project);

    List<Project> getAll();

    Project getById(long id);

    Project delete(long id);

}
