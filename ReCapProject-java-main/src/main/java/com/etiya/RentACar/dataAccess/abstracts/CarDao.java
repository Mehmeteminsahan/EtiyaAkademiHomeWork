package com.etiya.RentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACar.business.dtos.CarSearchListDto;
import com.etiya.RentACar.entites.Car;
import com.etiya.RentACar.entites.CarImage;
import com.etiya.RentACar.entites.ComplexTypes.CarDetail;

public interface CarDao extends JpaRepository<Car, Integer> {

	
	/*@Query(value = "Select new com.etiya.RentACar.entites.ComplexTypes.CarDetail"
			+ "(c.id,b.brandName,cl.colorName,c.modelYear,c.dailyPrice,c.description) "
			+ "From Car c Inner Join c.brand b Inner Join c.color cl ", nativeQuery = true)
	List<CarDetail> getCarsWithBrandAndColorDetails();*/
		
	@Query("Select new com.etiya.RentACar.entites.ComplexTypes.CarDetail"
            + "(c.id,b.brandName,cl.colorName,c.modelYear,c.dailyPrice,c.description) "
            + "From Car c Inner Join c.brand b Inner Join c.color cl")
    List<CarDetail> getCarWithBrandAndColorDetails();
	
	List<Car> getByBrand_brandId(int brandId);
	List<Car> getByColor_colorId(int colorId);
	
	@Query("Select new com.etiya.RentACar.business.dtos.CarSearchListDto"
			+ "(c.id, c.modelYear, c.dailyPrice, c.description, c.minFindeksSCore)"
			+ "From Car c Inner Join c.maintenances m Where m.car.id=c.id and m.returnDate is null "
			)
	List<CarSearchListDto> getCarsMaintenanceReturnDateIsNull();
	
	
}
