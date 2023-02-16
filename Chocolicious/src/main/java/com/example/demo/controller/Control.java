package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.demo;
import com.example.demo.repository.ChocoRepository;
import com.example.demo.service.Chocoservice;

@RestController
public class Control {
	
	@Autowired
	Chocoservice cs;
	@Autowired
	ChocoRepository cr;
	
    @GetMapping("/getdata/{field}")
    public Iterable<demo> chocoSort(@PathVariable("field") String field)
    {
    	return cs.sortChocolates(field);
    }
    @PostMapping("/addChocos")
    public demo saveChocos(@RequestBody demo coco)
    {
    	return cs.saveChoco(coco);
    }
 
    
    @GetMapping(value = "/pChocos/{pageNo}/{pageSize}")
    Page<demo> ChocoPaging(@PathVariable("pageNo") int pageno, @PathVariable("pageSize") int pageSize) {
    	return cs.pagingChocos(pageno, pageSize);
    	
    }
    
    
    @GetMapping(value = "/psChocos/{pageNo}/{pageSize}/{field}")
    Page<demo> employeesPagingAndSorting(@PathVariable("pageNo") int pageno, @PathVariable("pageSize") int pageSize,
    		@PathVariable("field") String field) {
    	return cs.pagingAndSortingChocos(pageno, pageSize, field);
    	
    }
    
    @GetMapping("/scbp/{prefix}")
    public List<demo>findChocolatesPrefix(@PathVariable("prefix")String prefix)
    {
    	return cs.getChocolatesByNamePrefix(prefix);
    }
    
    @GetMapping("/scbs/{suffix}")
    public List<demo>findChocolatesSuffix(@PathVariable("suffix")String suffix)
    {
    	return cs.getChocolatesByNameSuffix(suffix);
    }
    @GetMapping("/scbb/{brand}")
    public List<demo>findChocolatesByBrand(@PathVariable("brand")String brand)
    {
    	return cs.getChocolatesByBrand(brand);
    }
	@GetMapping("/get")
	List<demo>getUsers(){
		return cr.findAll();
	}
	
	@PostMapping("/post")
    public demo create(@RequestBody demo d) {
        return cr.save(d);
    }
	
	@PutMapping("/put")
	public demo update(@RequestBody demo dd)
	{
		return cr.saveAndFlush(dd);
	}
	@DeleteMapping("/del")
	public String delete(@RequestParam int position)
	{
		cr.deleteById(position);
		return "Deleted Successfully";
	}

	
}
