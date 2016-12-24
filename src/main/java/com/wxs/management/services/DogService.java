package com.wxs.management.services;

import java.util.List;
import java.util.Map;

public interface DogService<T> {
	public List<T> getAll();
	
	public void AddDogs(List<T> dogs);

	public void UpdateDogs(Map<String, Object> dogProps);
}
