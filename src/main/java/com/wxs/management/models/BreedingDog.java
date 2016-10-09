package com.wxs.management.models;

import java.util.Date;

import com.wxs.management.models.parents.Dog;

public class BreedingDog extends Dog {
	public Date getMatingDate() {
		return matingDate;
	}
	public void setMatingDate(Date matingDate) {
		this.matingDate = matingDate;
	}
	public Date getPuppyBirthday() {
		return puppyBirthday;
	}
	public void setPuppyBirthday(Date puppyBirthday) {
		this.puppyBirthday = puppyBirthday;
	}
	public String getFeeder() {
		return feeder;
	}
	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getReadyForSell() {
		return readyForSell;
	}
	public void setReadyForSell(int readyForSell) {
		this.readyForSell = readyForSell;
	}
	public int getPuppyAccount() {
		return puppyAccount;
	}
	public void setPuppyAccount(int puppyAccount) {
		this.puppyAccount = puppyAccount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private Date matingDate;
	private Date puppyBirthday;
	private String feeder;
	private float price;
	private int readyForSell;
	private int puppyAccount;
	private String category;
}
