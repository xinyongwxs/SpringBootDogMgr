package com.wxs.management.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wxs.management.models.BreedingDog;
import com.wxs.management.models.TrainingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.impl.TrainingDogServiceImpl;

@RestController
@RequestMapping(value = "/trainingdog")
public class TrainingDogController {
	@Autowired
	public TrainingDogServiceImpl trainingDogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TrainingDog> getAll() {
		List<TrainingDog> wdList = trainingDogService.getAll();
		return wdList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void AddDogs(@RequestBody List<TrainingDog> dogs) {
		trainingDogService.AddDogs(dogs);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateDog(@RequestBody Map<String, Object> dogProps) {
		trainingDogService.UpdateDogs(dogProps);
	}
}
