package com.etiya.rentACarSpring.entities.complexTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetail {
	
	private int id;
	
	private String brandName; //Brand'den gelen
	
	private String colorName; //Color'dan gelen
	
	private int dailyPrice;
	
	private int modelYear;
	
	private String description;
	
}
