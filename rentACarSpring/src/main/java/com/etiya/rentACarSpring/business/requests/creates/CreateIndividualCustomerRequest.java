package com.etiya.rentACarSpring.business.requests.creates;

import java.time.LocalDate; 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {
	
	//@JsonIgnore
	//@NotNull
	//private int individualCustomerId;

	@NotNull
	private int userId;

	@NotNull
	private String email;
	
    @NotNull
	private String password;
	
	@NotNull
	@Size(min=2, max=50)
	private String firstName;

	@NotNull
	@Size(min=2, max=50)
	private String lastName;

	@NotNull
	//@DateTimeFormat(pattern="yyyy.MM.dd")
	private LocalDate birthday;
	
}
