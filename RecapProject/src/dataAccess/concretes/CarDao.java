package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.CarRepository;
import entities.concretes.Car;


public class CarDao implements CarRepository{
	List<Car> cars;
	
	public CarDao() {
		cars=new ArrayList<Car>();
	}

	@Override
	public void add(Car entity) {
		cars.add(entity);		
	}

	@Override
	public void delete(int id) {
		cars.remove(id);
		
	}

	@Override
	public void update(int id,Car entity) {
		cars.set( id, entity);
		
	}

	@Override
	public Car getById(int id) {
		return cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		return cars;
	}
}
