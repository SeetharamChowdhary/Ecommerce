package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.User;
import com.example.bookstore.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	@Override
	public String insercustomer(User c) {
		
		 customerRepository.save(c);
		 return null;
	}
	@Override
	public User checkuserlogin(String name, String pwd) {
		
		return customerRepository.checkuserlogin(name,pwd);
	}

}
