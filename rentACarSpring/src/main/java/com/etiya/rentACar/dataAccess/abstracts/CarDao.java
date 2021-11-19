package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACar.entities.Car;

public interface CarDao extends JpaRepository<Car, Integer>{

}
