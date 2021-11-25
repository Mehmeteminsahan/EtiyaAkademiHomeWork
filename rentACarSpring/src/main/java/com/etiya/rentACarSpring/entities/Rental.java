package com.etiya.rentACarSpring.entities;

import java.time.LocalDate; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int rentalId;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="individual_customer_id")
	private IndividualCustomer individualCustomer;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="rent_date")
	private LocalDate rentDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="return_date")
	private LocalDate returnDate;
	
}
