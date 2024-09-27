package ru.vladislav.service;

import ru.vladislav.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    List<Customer> getAll();

    Customer getById(long id);

    Customer delete(long id);

}
