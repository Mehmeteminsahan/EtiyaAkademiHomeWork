package com.etiya.rentACarSpring.business.requests.creates;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	//Veritabanı id otomatik ekliyor, O yüzden Id eklemeyiz.
	
	@NotNull
	private int brandId;
	
	@NotNull
	private int colorId;
	
	@NotNull
	@Min(2000)
	@Max(2022)
	private int modelYear;
	
	@NotNull
	@Min(1)
	private int dailyPrice;
	
	@NotNull
	@Size(min=2, max=50)
	private String description;
}
