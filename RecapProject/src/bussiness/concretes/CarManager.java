package bussiness.concretes;

import java.util.List;

import bussiness.abstracts.CarService;
import core.utilities.result.DataResult;
import core.utilities.result.ErrorDataResult;
import core.utilities.result.ErrorResult;
import core.utilities.result.Result;
import core.utilities.result.SuccessDataResult;
import core.utilities.result.SuccessResult;
import dataAccess.abstracts.CarRepository;
import entities.concretes.Car;

public class CarManager implements CarService{
	private CarRepository carRepository;
	public CarManager(CarRepository carRepository) {
		this.carRepository=carRepository;
	}
	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(this.carRepository.getAll());
	}
	@Override
	public Result add(Car car) {
		this.carRepository.add(car);
		return new SuccessResult("Eklendi");
		
	}
	@Override
	public Result delete(int id) {
		int counter=0;
		for (Car car : this.carRepository.getAll()) {
			if(car.getId()==id) {
				this.carRepository.delete(counter);
				return new SuccessResult("Silindi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
		
	}
	@Override
	public Result update(int id, Car car) {
		int counter=0;
		for (Car item : this.carRepository.getAll()) {
			if(item.getId()==id) {
				this.carRepository.update(counter,car);
				return new SuccessResult("Güncellendi.");
			}
		
			counter++;
			
		}
		return new ErrorResult("Böyle bir id yok");
		
	}
	@Override
	public DataResult<Car> getById(int id) {
		int counter=0;
		for (Car item : this.carRepository.getAll()) {
			if(item.getId()==id) {
				return new SuccessDataResult<Car>(this.carRepository.getAll().get(counter));
			}
			
			counter++;
			
			
		}
		return null;
		
	}
	
}
