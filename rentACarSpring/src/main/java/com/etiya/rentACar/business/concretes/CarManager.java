package com.etiya.rentACar.business.concretes;

import java.util.ArrayList; 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstrackts.CarService;
import com.etiya.rentACar.business.dtos.CarSearchListDto;
import com.etiya.rentACar.business.requests.CreateCarRequest;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.entities.Car;

@Service
public class CarManager implements CarService {
	
	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService mapperService) {
		super();
		this.carDao = carDao;
		this.modelMapperService = mapperService;
	}

	@Override
	public List<CarSearchListDto> getAll() {
		List<Car> result = this.carDao.findAll();
		
		List<CarSearchListDto> response = result.stream().map(car->modelMapperService.forDto()
				.map(car,CarSearchListDto.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void save(CreateCarRequest createCarRequest) {
		
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		
	}

	

}
