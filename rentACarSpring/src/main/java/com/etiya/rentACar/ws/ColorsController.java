package com.etiya.rentACar.ws;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.entities.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	
	@GetMapping("check")
	public String check() {
		return "API up";
	}
	
	public List<Color> getAll() {
		return null;
	}

}
