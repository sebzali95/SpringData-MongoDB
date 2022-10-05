package com.example.customerservice.service;

import com.example.customerservice.exception.EntityAlreadyExistsException;
import com.example.customerservice.exception.EntityNotFoundException;
import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private static final String ALREADY_EXISTS_MESSAGE = "Customer with firstname: %s and lastname: %s is already existing";

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer not found with id: %s", id)));
    }

    public Customer createCustomer(Customer customer) {
        checkExistingCustomer(customer);
        customerRepository.save(customer);
        return customer;
    }

    private void checkExistingCustomer(Customer customer) {
        customerRepository.findByFirstNameAndLastName(customer.getFirstName(), customer.getLastName())
                .ifPresent(customer1 -> {
                    throw new EntityAlreadyExistsException(String.format(ALREADY_EXISTS_MESSAGE, customer.getFirstName(), customer.getLastName()));
                });
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
