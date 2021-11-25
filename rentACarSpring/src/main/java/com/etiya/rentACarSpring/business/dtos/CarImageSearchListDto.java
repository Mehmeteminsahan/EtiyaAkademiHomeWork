package com.etiya.rentACarSpring.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageSearchListDto {

	private int carId;
	
	private String imagePath;
	
	private LocalDate date;
	
}
