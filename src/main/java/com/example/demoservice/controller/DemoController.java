package com.example.demoservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoservice.model.Bank;
import com.example.demoservice.service.DemoTestService;

@RestController
public class DemoController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DemoTestService testService;
	
	@GetMapping("/greetme")
	public String greetMe(){
		return "Welcome to first service";
	}
	
	
	@GetMapping("/get-customers")
	public List<Bank> getList(){
		return testService.getCustomers();
	}
	
	@GetMapping("/get-customer")
	public Optional<Bank> getCustomer(@RequestParam int accountNo){
		return testService.getCustomer(accountNo);
	}
	
	@GetMapping("/get-customer-bycity")
	public List<Bank> getCustomerByCity(@RequestParam String city){
		return testService.getCustomerByCity(city);
	}
	
	@PostMapping("/add-customer")
	public String addString(@RequestBody Bank  bank){
		logger.info(bank.toString());
		return testService.addCustomer(bank);
	}
	
	
	@DeleteMapping("/delete-customer")
	public String deleteCustomer(@RequestParam int accountNo){
		return testService.deleteCustomer(accountNo);
	}
	
	@PutMapping("/update-customer")
	public String updateCustomer(@RequestBody Bank bank){
		return testService.updateCustomer(bank);
	}

}
