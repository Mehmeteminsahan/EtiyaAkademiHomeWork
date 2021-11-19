package com.etiya.rentACar.business.requests;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	private int colorId;

	private int brandId;

	private int modelYear;

	private int dailyPrice;

	private String description;
	
}
