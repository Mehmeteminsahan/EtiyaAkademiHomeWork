package com.etiya.rentACarSpring.business.requests.creates;

import java.time.LocalDate; 

import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

	@JsonIgnore
	private int rentalId;
	
	
	@NotNull
	private int carId;
	
	
	@NotNull
	private int individualCustomerId;
	
	@NotNull
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate rentDate;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnDate;
}
