package com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.domain.Car;
import com.fullstack.backend.springboot.react.fullstackbackendspringbootrecat.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping("/cars")
	Iterable<Car> getCars(){
		
		return carRepository.findAll();
		
	}

}
