package ru.vladislav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vladislav.dao.CustomerDAO;
import ru.vladislav.models.Customer;
import ru.vladislav.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    public Customer update(Customer customer) {
        return customerDAO.update(customer);
    }

    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    public Customer getById(long id) {
        return customerDAO.findById(id);
    }

    public Customer delete(long id) {
        return customerDAO.delete(id);
    }
}
