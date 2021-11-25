package com.etiya.rentACarSpring.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etiya.rentACarSpring.business.dtos.RentalSearchListDto;
import com.etiya.rentACarSpring.entities.Rental;
import com.etiya.rentACarSpring.entities.complexTypes.RentalDetail;

public interface RentalDao extends JpaRepository<Rental, Integer>{
	
	
	@Query("Select new com.etiya.rentACarSpring.entities.complexTypes.RentalDetail"
			+"(r.id,r.rentDate,r.returnDate)"
			+"From Rental r Inner Join r.car c Where r.id=:rentalId")
	 RentalDetail getRentalDetails(int rentalId);
	
	
	//List<Rental> getByCar_Id(int carId);
	@Query("Select new com.etiya.rentACarSpring.business.dtos.RentalSearchListDto"
            + "(r.id,c.id, r.rentDate, r.returnDate) " 
            +     "From Car c Inner Join c.rentals r where c.id=:carId and r.returnDate is null")
    RentalSearchListDto getByCarIdWhereReturnDateIsNull(int carId);
	
}
