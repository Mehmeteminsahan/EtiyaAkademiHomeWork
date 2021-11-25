package com.etiya.rentACarSpring.business.dtos;

import java.time.LocalDate; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerSearchListDto {

	private int individualCustomerId;

	private int userId;

	private String firstName;

	private String lastName;

	private LocalDate birthday;
}
