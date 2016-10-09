package com.wxs.management.services.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wxs.management.models.TrainingDog;

public class TrainingDogRowMapper implements RowMapper<TrainingDog> {

	@Override
	public TrainingDog mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrainingDog td = new TrainingDog();
		td.setId(rs.getString("id"));
		td.setType(rs.getString("type"));
		td.setName(rs.getString("name"));
		td.setEpDate(rs.getDate("epdate"));
		td.setBirthday(rs.getDate("birthday"));
		td.setKennelId(rs.getString("kennelid"));
		td.setChipId(rs.getString("chipid"));
		td.setEarId(rs.getString("earid"));
		td.setCompanyCode(rs.getString("companycode"));
		td.setRemarks(rs.getString("remarks"));
		
		td.setOwnerId(rs.getString("ownerid"));
		td.setOwnerPhone(rs.getString("ownerphone"));
		td.setCourses(rs.getString("courses"));
		td.setStartDate(rs.getDate("startdate"));
		td.setEndDate(rs.getDate("enddate"));
		td.setGender(rs.getString("gender"));
		return td;
	}

}
