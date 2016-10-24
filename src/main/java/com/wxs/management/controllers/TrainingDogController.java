package com.wxs.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxs.management.models.TrainingDog;
import com.wxs.management.services.impl.TrainingDogServiceImpl;

public class TrainingDogController {

	@Controller
	@RequestMapping(value = "/trainingdog")
	public class BreedingDogController {
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
	}

}
