package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.Reatiler;
import com.example.bookstore.repository.ReatilerRepository;
@Service
public class ReatilerServiceImpl implements ReatilerService {

	@Autowired
	private ReatilerRepository reatilerRepository;
	@Override
	public String insertReatiler(Reatiler r) {
		reatilerRepository.save(r);
		return "deatils saved";
	}
	@Override
	public Reatiler checkreatiler(String email, String pwd) {
		return reatilerRepository.checkreatiler(email,pwd);
	
	}

}
