package com.wxs.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wxs.management.models.BreedingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.impl.BreedingDogServiceImpl;


@RestController
@RequestMapping(value = "/breedingdog")
public class BreedingDogController {
	@Autowired
	public BreedingDogServiceImpl breedingDogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<BreedingDog> getAll() {
		List<BreedingDog> wdList = breedingDogService.getAll();
		return wdList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void AddDogs(@RequestBody List<BreedingDog> dogs) {
		breedingDogService.AddDogs(dogs);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
