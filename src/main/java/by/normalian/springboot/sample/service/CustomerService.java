package by.normalian.springboot.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import by.normalian.springboot.sample.model.Customer;

@Service
public interface CustomerService {
	List<Customer> findAll();

	Customer saveOrUpdate(Customer customer);
}
