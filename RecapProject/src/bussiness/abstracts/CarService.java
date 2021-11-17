package bussiness.abstracts;

import java.util.List;

import core.utilities.result.DataResult;
import core.utilities.result.Result;
import entities.concretes.Car;

public interface CarService {
	DataResult<List<Car>> getAll();
	Result add(Car car);
	Result delete(int id);
	Result update(int id,Car car);
	DataResult<Car> getById(int id);
}
