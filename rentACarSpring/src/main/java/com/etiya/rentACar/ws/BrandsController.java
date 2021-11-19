package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.entities.Brand;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
	
	@GetMapping("check")
	public String check() {
		return "API up";
	}
	
	@GetMapping("all")
	public List<Brand> getAll(){
		
		return null;	
	}

}
