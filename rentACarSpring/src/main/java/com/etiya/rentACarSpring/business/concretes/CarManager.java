package com.etiya.rentACarSpring.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.rentACarSpring.business.abstracts.CarService;
import com.etiya.rentACarSpring.business.dtos.CarSearchListDto;
import com.etiya.rentACarSpring.business.requests.creates.CreateCarRequest;
import com.etiya.rentACarSpring.business.requests.deletes.DeleteCarRequest;
import com.etiya.rentACarSpring.business.requests.updates.UpdateCarRequest;
import com.etiya.rentACarSpring.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACarSpring.core.utilities.results.DataResult;
import com.etiya.rentACarSpring.core.utilities.results.Result;
import com.etiya.rentACarSpring.core.utilities.results.SuccessDataResult;
import com.etiya.rentACarSpring.core.utilities.results.SuccessResult;
import com.etiya.rentACarSpring.dataAccess.abstracts.CarDao;
import com.etiya.rentACarSpring.entities.Car;
import com.etiya.rentACarSpring.entities.complexTypes.CarDetail;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		List<Car> result = this.carDao.findAll();
		
		//Veri tablosundaki veriyi ilgili dto'ya mapledik.
		List<CarSearchListDto> response = result.stream().map(car -> modelMapperService.forDto()
				.map(car, CarSearchListDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<CarSearchListDto>>(response, "The vehicles are listed.");
		
	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("The vehicle has been added.");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {
		Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult("The vehicle has been updated.");
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {
		//Delete map'e gerek yok
		//Car car = modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		//this.carDao.delete(car);
		this.carDao.deleteById(deleteCarRequest.getId());
		return new SuccessResult("The vehicle has been deleted.");
	}

	@Override
	public DataResult<List<CarDetail>> getCarWithBrandAndColorDetails() {
		List<CarDetail> result = this.carDao.getCarWithBrandAndColorDetails();
		return new SuccessDataResult<List<CarDetail>>(result);
	}

	/*@Override
	public DataResult<List<CarDetail>> getByBrandName(String brandName) {
		List<CarDetail> result = this.carDao.getByBrandName(brandName);
		
		return new SuccessDataResult<List<CarDetail>>(result);
	}*/
	
	

}
