package com.etiya.rentACarSpring.ws;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.business.abstracts.CarService;
import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

@RestController
@RequestMapping("api/cars")
public class CarsController {

	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	//http://localhost:8080/api/cars/check --> ERİŞİM
	@GetMapping("check")
	public String Check() {
		return "API up";
	}
	
	//Controller'da entities ile çalışılmaz. Dto [Data Transfer Object] kullanılır.
	@GetMapping("all")
	public DataResult<List<CarSearchListDto>> getAll(){
		return this.carService.getAll();
	}
	
	@GetMapping("detailedCars")
	public DataResult<List<CarDetail>> getDetailedCars(){
		return this.carService.getCarWithBrandAndColorDetails();
	}
	
	/*@GetMapping("getByBrandName")
	public DataResult<List<CarDetail>> getByBrandName(@RequestParam("brandName") String brandName){
		return this.carService.getByBrandName(brandName);
	}*/
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}
	
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest) {
		return this.carService.delete(deleteCarRequest);
	}
	
}
