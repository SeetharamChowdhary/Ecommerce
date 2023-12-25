package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.Admin;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.AdminRepository;
import com.example.bookstore.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
	@Override
	public Admin checkadminlogin(String auname, String apwd) {
		return adminRepository.checkadminlogin(auname,apwd);
		
	}
	@Override
	public List<User> viewUsers() {
		
		return customerRepository.findAll();
	}
	
}