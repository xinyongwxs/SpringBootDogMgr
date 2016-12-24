package com.wxs.management.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	public @ResponseBody String AddDogs(@RequestBody List<BreedingDog> dogs) {
		UUID id = UUID.randomUUID();
		if (dogs.size() > 0) {
			dogs.get(0).setId(id.toString());
			breedingDogService.AddDogs(dogs);
		}		
		return id.toString();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateDog(@RequestBody Map<String, Object> dogProps) {
		breedingDogService.UpdateDogs(dogProps);
	}
}
