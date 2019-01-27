package by.normalian.springboot.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.normalian.springboot.sample.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByFirstName(String firstName);

	Customer findByLastName(String lastName);
}
