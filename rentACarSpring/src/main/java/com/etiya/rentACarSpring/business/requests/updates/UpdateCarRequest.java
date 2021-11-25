package com.etiya.rentACarSpring.business.requests.updates;

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
public class UpdateCarRequest {


	@NotNull
	@Min(1)
	private int id;

	@NotNull
	@Min(1)
	private int brandId;

	@NotNull
	@Min(1)
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
