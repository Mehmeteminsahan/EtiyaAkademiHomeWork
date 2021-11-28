package com.etiya.RentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.RentACar.business.dtos.MaintenanceDto;
import com.etiya.RentACar.entites.Maintenance;

public interface MaintenanceDao extends JpaRepository<Maintenance, Integer> {

	
	@Query("Select new com.etiya.RentACar.business.dtos.MaintenanceDto"
			+ "(c.id, m.returnDate) " 
			+ 	"From Car c Inner Join c.maintenances m Where c.id=:carId and m.returnDate is null")
	MaintenanceDto getByCarIdWhereReturnDateIsNull(int carId);
	
}
