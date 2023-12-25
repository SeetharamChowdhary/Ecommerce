package com.example.bookstore.service;

import java.util.List;

import com.example.bookstore.model.Admin;
import com.example.bookstore.model.User;

public interface AdminService {
	 public Admin checkadminlogin(String auname,String apwd);

	public List<User> viewUsers();
}
