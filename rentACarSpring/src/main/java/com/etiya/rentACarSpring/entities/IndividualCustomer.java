package com.etiya.rentACarSpring.entities;

import java.time.LocalDate; 
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="individual_customers")
public class IndividualCustomer extends User{

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private int individualCustomerId;
	
//	@OneToOne
//	@JoinColumn(name="user_id")
//	private User user;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birthday")
	private LocalDate birthday;
	
	@JsonIgnore
	@OneToMany(mappedBy = "individualCustomer")
	private List<Rental> rentals;
	
	
}
