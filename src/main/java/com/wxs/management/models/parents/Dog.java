package com.wxs.management.models.parents;

import java.util.Date;

public class Dog {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getKennelId() {
		return kennelId;
	}
	public void setKennelId(String kennelId) {
		this.kennelId = kennelId;
	}
	public Date getEpDate() {
		return epDate;
	}
	public void setEpDate(Date epDate) {
		this.epDate = epDate;
	}
	public String getChipId() {
		return chipId;
	}
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}
	public String getEarId() {
		return earId;
	}
	public void setEarId(String earId) {
		this.earId = earId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String id;
	private String name;
	private Date birthday;
	private String kennelId;
	private Date epDate;
	private String chipId;
	private String earId;
	private String companyCode;
	private String remarks;
	private String type;
}
