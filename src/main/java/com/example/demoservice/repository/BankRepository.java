package com.example.demoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoservice.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{
	List<Bank> findByCity(String city);
}
