package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

//import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.demo.demo;
import com.example.demo.repository.ChocoRepository;
@Service
public class Chocoservice {
	
	@Autowired
	ChocoRepository chocorepo;
	
	public Iterable<demo> sortChocolates(String field) {
		
	     return chocorepo.findAll(Sort.by(field));
		}
	public demo saveChoco(demo coco)
	{
		return chocorepo.save(coco);
	}

	public Page<demo> pagingChocos(int page,int pageSize) {
		Pageable paging = PageRequest.of(page, pageSize);
			return chocorepo.findAll(paging);
		}
//	
	public Page<demo> pagingAndSortingChocos(int offset,int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			return chocorepo.findAll(paging);
		}

	public List<demo> getChocolatesByBrand(String brand) {
		return chocorepo.findAllChocosByBrand(brand);
		
	}

	public List<demo> getChocolatesByNamePrefix(String prefix) {
		return chocorepo.findBychocolatenameStartingWith(prefix);
		
	}

	public List<demo> getChocolatesByNameSuffix(String suffix) {
	return chocorepo.findBychocolatenameEndingWith(suffix);
	}
	
  }
