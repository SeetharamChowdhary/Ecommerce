package com.example.bookstore.service;

import com.example.bookstore.model.Reatiler;

public interface ReatilerService {

	public String insertReatiler(Reatiler r);

	public Reatiler checkreatiler(String email, String pwd);

}
