package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.demo.demo;


@Repository
public interface ChocoRepository extends JpaRepository<demo,Integer>,CrudRepository<demo, Integer>,
PagingAndSortingRepository<demo, Integer> {
	public List<demo> findBychocolatenameStartingWith(String prefix);

	public List<demo> findBychocolatenameEndingWith(String suffix);

	@Query("SELECT candy FROM demo candy WHERE candy.brand=?1 ")
	public List<demo> findAllChocosByBrand(String brand);


}
