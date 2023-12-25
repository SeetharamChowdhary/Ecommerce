package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.Reatiler;
@Repository
public interface ReatilerRepository extends JpaRepository<Reatiler, Integer> {
	@Query("select u from Reatiler u where email=?1 and password=?2")
	public Reatiler checkreatiler(String email, String pwd);

}
