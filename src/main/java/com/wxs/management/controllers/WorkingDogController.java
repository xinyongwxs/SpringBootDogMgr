package com.wxs.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxs.management.models.WorkingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.impl.WorkingDogServiceImpl;

@Controller
@RequestMapping(value = "/workingdog")
public class WorkingDogController {
	@Autowired
	public WorkingDogServiceImpl workingDogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<WorkingDog> getAll() {
		List<WorkingDog> wdList = workingDogService.getAll();
		return wdList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void AddDogs(@RequestBody List<WorkingDog> dogs) {
		workingDogService.AddDogs(dogs);
	}
}
