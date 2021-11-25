package com.etiya.rentACarSpring.business.requests.creates;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
}
