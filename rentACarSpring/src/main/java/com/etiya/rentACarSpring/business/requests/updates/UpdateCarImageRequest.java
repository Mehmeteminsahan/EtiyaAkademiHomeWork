package com.etiya.rentACarSpring.business.requests.updates;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarImageRequest {

	@NotNull
	private int carImageId;
	
	
	@JsonIgnore
	private int carId;
	
	private String imagePath;
	
	@NotNull
	@JsonIgnore
	private MultipartFile file;
	
}
