package by.normalian.springboot.sample;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import by.normalian.springboot.sample.model.Customer;
import by.normalian.springboot.sample.service.CustomerService;


@SpringBootApplication
public class Application {
	private final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	private final CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() throws Exception {
		LOGGER.info("@@@ Insert sample records into customer table");
		customerService.saveOrUpdate(new Customer(1, "Daichi", "Isami"));
		customerService.saveOrUpdate(new Customer(2, "Yoichi", "Kawasaki"));
	}

	public Application(CustomerService customerService) {
		this.customerService = customerService;
	}
}