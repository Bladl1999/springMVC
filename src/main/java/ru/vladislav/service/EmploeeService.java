package ru.vladislav.service;

import ru.vladislav.models.Customer;
import ru.vladislav.models.Emploee;

import java.util.List;

public interface EmploeeService {

    Emploee save(Emploee emploee);

    Emploee update(Emploee emploee);

    List<Emploee> getAll();

    Emploee getById(long id);

    Emploee delete(long id);

}
