package com.webservice.redis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.redis.model.CreditAmountLimit;
import com.webservice.redis.repo.CustomerRepository;



@RestController
@RequestMapping("/Redis")
public class WebController {

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody CreditAmountLimit amountLimit) {
		// save a single Customer
		customerRepository.save(new CreditAmountLimit(amountLimit.getMobileNo(), amountLimit.getCreditAmountLimit()));

		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Map<Long, CreditAmountLimit> customers = customerRepository.findAll();

		for (CreditAmountLimit customer : customers.values()) {
			result += "Customer Mobile No " + customer.getMobileNo() + "customer credit limit amout"
					+ customer.getCreditAmountLimit() + "<br>";
		}

		return result;
	}

	@RequestMapping("/find")
	public String findById(@RequestParam("id") Long id) {
		String result = "";
		result = customerRepository.find(id).toString();
		return result;
	}

	@RequestMapping(value = "/updateAmount")
	public String postCustomer(@RequestBody CreditAmountLimit amountLimit) {
		CreditAmountLimit customer = customerRepository.find(amountLimit.getMobileNo());
		if (customer != null) {
			customer.setCreditAmountLimit(customer.getCreditAmountLimit() - amountLimit.getCreditAmountLimit());
			customerRepository.update(customer);
		} else {
			return "mobile no not found";
		}
		return "Done";
	}

	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		customerRepository.delete(id);

		return "Done";
	}
}

