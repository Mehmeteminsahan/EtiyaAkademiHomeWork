package com.etiya.rentACarSpring.business.requests.creates;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageRequest {
	
	@NotNull
	private int carId;
	
	@JsonIgnore
	private String imagePath;

	@JsonIgnore
	private MultipartFile file;
	
}
