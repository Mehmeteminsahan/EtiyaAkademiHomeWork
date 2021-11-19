package com.etiya.rentACar.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstrackts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;
import com.etiya.rentACar.business.requests.CreateCarRequest;
import com.etiya.rentACar.entities.Car;

@RestController
@RequestMapping("api/cars")
public class CarsController {
	private CarService carService;
	
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("check")
	public String check() {
		return "API up";
	}
	
	@GetMapping("all")
	public List<CarSearchListDto> getAll(){
		return carService.getAll();
		
	}
	@PostMapping("add")
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.save(createCarRequest);
	}
}
