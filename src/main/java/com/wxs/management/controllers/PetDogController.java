package com.wxs.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxs.management.models.PetDog;
import com.wxs.management.services.impl.PetDogServiceImpl;

@Controller
@RequestMapping(value = "/petdog")
public class PetDogController {
	@Autowired
	public PetDogServiceImpl petDogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<PetDog> getAll() {
		List<PetDog> wdList = petDogService.getAll();
		return wdList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void AddDogs(@RequestBody List<PetDog> dogs) {
		petDogService.AddDogs(dogs);
	}
}
