package com.wxs.management.models;

import com.wxs.management.models.parents.Dog;

public class PetDog extends Dog {
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
	public String getApperance() {
		return apperance;
	}
	public void setApperance(String apperance) {
		this.apperance = apperance;
	}
	public int getReadyForSell() {
		return readyForSell;
	}
	public void setReadyForSell(int readyForSell) {
		this.readyForSell = readyForSell;
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
	public String getBreeder() {
		return breeder;
	}
	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}
	private int trainingLevel;
	private String trainer;
	private String apperance;
	private int readyForSell;
	private float price;
	private String category;
	private String breeder;
}
