package com.etiya.rentACarSpring.business.dtos;

import java.time.LocalDate; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalSearchListDto {

	private int rentalId;

	private int carId;

	//private int userId;

	private LocalDate rentDate;

	private LocalDate returnDate;
}
