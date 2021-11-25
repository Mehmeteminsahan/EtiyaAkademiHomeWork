package com.etiya.rentACarSpring.business.requests.updates;

import java.time.LocalDate; 

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

	@NotNull
	private int rentalId;
	
	@NotNull
	private int carId;
	
	@NotNull
	private int individualCustomerId;

	
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnDate;
}
