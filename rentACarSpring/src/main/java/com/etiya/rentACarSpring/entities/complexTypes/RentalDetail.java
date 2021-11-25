package com.etiya.rentACarSpring.entities.complexTypes;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDetail {
	private int rentalId;
	//private int carId;
	private LocalDate rentDate;
	private LocalDate returnDate;
}
