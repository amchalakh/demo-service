package com.example.demoservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoservice.exception.CustomerNotFoundException;
import com.example.demoservice.model.Bank;
import com.example.demoservice.repository.BankRepository;

@Service
public class DemoTestService {
	
	List<String> list = new ArrayList<String>();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BankRepository bankRepository;
	
	public DemoTestService(){
		list.add("Test1");
		list.add("Test2");
	}

	public List<String> getList() {
		return list;
	}

	public String addString(String text) {
		list.add(text);
		return "Text added successfully";
	}

	public String deleteString(int id) {
		
		list.remove(id);
		
		return "Text deleted successfully";
	}

	public String updateList(int id, String text) {
		/*list.remove(id);
		list.add(id, text);*/
		logger.info(id+" "+text);
		list.set(id, text);
		return "list updated successfully";
	}

	public String addCustomer(Bank bank) {
		bankRepository.save(bank);
		logger.info(bank.toString());
		logger.info("Record inserted successfully");
		return "Record inserted successfully";
	}

	public List<Bank> getCustomers() {
		
		return bankRepository.findAll();
	}

	public Optional<Bank> getCustomer(int accountNo) {
		
		return bankRepository.findById(accountNo);
		
	}

	public List<Bank> getCustomerByCity(String city) {
		
		return bankRepository.findByCity(city);
	}

	public String updateCustomer(Bank bank) {
		bankRepository.save(bank);
		return "Record updated successfully";
	}

	public String deleteCustomer(int accountNo) {
		try{
		bankRepository.deleteById(accountNo);
		
		}catch(Exception e){
			logger.error("Exception:",e);
			throw new CustomerNotFoundException();
		
		}
		return "Record deleted successfully"; 
	}

}
