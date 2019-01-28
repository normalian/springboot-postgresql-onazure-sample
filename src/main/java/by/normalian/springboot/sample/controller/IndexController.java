package by.normalian.springboot.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;

import by.normalian.springboot.sample.model.Customer;
import by.normalian.springboot.sample.service.CustomerService;

@Controller
public class IndexController {
	private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	private final CustomerService customerService;

	@Autowired
	public IndexController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/")
	public RedirectView redirectToIndex(RedirectAttributes attributes) {
		// redirect to /index path
		return new RedirectView("index");
	}

	@GetMapping("/index")
	public Model index(Model model) {
		model.addAttribute("message", "Passed index methond as get");
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return model;
	}

	@PostMapping("/index")
	public Model index(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		Customer customer = new Customer(0, firstName, lastName);
		if (StringUtils.isEmptyOrWhitespace(firstName) == false && StringUtils.isEmptyOrWhitespace(lastName) == false) {
			LOGGER.debug("@@ input param: " + customer);
			customerService.saveOrUpdate(customer);
		}
		this.index(model);

		// override message attribute
		if (StringUtils.isEmptyOrWhitespace(firstName) == false && StringUtils.isEmptyOrWhitespace(lastName) == false) {
			model.addAttribute("message", "Passed index methond as post successfully");
		} else {
			model.addAttribute("message",
					"Passed index methond as post, but you input firstname or lastname as blank ");
		}
		return model;
	}
}
