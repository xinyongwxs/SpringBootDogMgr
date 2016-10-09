package com.wxs.management.models;

import com.wxs.management.models.parents.Dog;

public class WorkingDog extends Dog {
	public int getTrainingLevel() {
		return trainingLevel;
	}
	public void setTrainingLevel(int trainingLevel) {
		this.trainingLevel = trainingLevel;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public int getReadyForWorking() {
		return readyForWorking;
	}
	public void setReadyForWorking(int readyForWorking) {
		this.readyForWorking = readyForWorking;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private int trainingLevel;
	private String trainer;
	private int readyForWorking;
	private float price;
	private String category;
}
