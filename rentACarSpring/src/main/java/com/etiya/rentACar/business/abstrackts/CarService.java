package com.etiya.rentACar.business.abstrackts;

import java.util.List; 

import com.etiya.rentACar.business.dtos.CarSearchListDto;
import com.etiya.rentACar.business.requests.CreateCarRequest;


public interface CarService {
	
	List<CarSearchListDto> getAll();
	
	void save(CreateCarRequest createCarRequest);
}
