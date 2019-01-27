package by.normalian.springboot.sample.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.normalian.springboot.sample.model.Customer;
import by.normalian.springboot.sample.repository.CustomerRepository;
import by.normalian.springboot.sample.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveOrUpdate(Customer customer) {
		LOGGER.info("@@ Create new customer: " + customer);
		customerRepository.save(customer);
		return customer;
	}
}
