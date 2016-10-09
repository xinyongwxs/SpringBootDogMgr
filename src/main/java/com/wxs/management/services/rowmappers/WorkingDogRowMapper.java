package com.wxs.management.services.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wxs.management.models.WorkingDog;

public class WorkingDogRowMapper implements RowMapper<WorkingDog> {

	@Override
	public WorkingDog mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkingDog wd = new WorkingDog();
		wd.setId(rs.getString("id"));
		wd.setType(rs.getString("type"));
		wd.setName(rs.getString("name"));
		wd.setEpDate(rs.getDate("epdate"));
		wd.setBirthday(rs.getDate("birthday"));
		wd.setKennelId(rs.getString("kennelid"));
		wd.setChipId(rs.getString("chipid"));
		wd.setEarId(rs.getString("earid"));
		wd.setCompanyCode(rs.getString("companycode"));
		wd.setRemarks(rs.getString("remarks"));
		
		wd.setTrainer(rs.getString("trainer"));
		wd.setTrainingLevel(rs.getInt("traininglevel"));
		wd.setReadyForWorking(rs.getInt("readyforworking"));
		wd.setPrice(rs.getFloat("price"));
		wd.setCategory(rs.getString("category"));
		return wd;
	}

}
