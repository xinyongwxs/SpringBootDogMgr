package com.wxs.management.services;

import java.util.List;

public interface DogService<T> {
	public List<T> getAll();
	
	public void AddDogs(List<T> dogs);
	
	public void UpdateDogs(T dogs);
}
