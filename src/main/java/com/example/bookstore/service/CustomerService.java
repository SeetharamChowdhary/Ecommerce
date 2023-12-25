package com.example.bookstore.service;

import com.example.bookstore.model.User;

public interface CustomerService {

	public String insercustomer(User u);
	public User checkuserlogin(String name, String pwd);

}
