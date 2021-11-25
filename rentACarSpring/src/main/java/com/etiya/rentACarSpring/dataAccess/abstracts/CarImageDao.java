package com.etiya.rentACarSpring.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACarSpring.entities.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer> {
	
	int countCarImageByCar_Id(int carId);
	
	//boolean existsByCar_CarId(int carId);
	
	List<CarImage> getByCar_Id(int carId);
	

}
