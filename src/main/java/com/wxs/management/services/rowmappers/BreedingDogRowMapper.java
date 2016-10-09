package com.wxs.management.services.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wxs.management.models.BreedingDog;

public class BreedingDogRowMapper implements RowMapper<BreedingDog> {

	@Override
	public BreedingDog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BreedingDog bd = new BreedingDog();
		bd.setBirthday(rs.getDate("birthday"));
		bd.setCategory(rs.getString("category"));
		bd.setChipId(rs.getString("chipid"));
		bd.setEarId(rs.getString("earid"));
		bd.setCompanyCode(rs.getString("companycode"));
		bd.setEpDate(rs.getDate("epdate"));
		bd.setFeeder(rs.getString("feeder"));
		bd.setId(rs.getString("id"));
		bd.setKennelId(rs.getString("kennelid"));
		bd.setMatingDate(rs.getDate("matingdate"));
		bd.setName(rs.getString("name"));
		bd.setPrice(rs.getFloat("price"));
		bd.setPuppyAccount(rs.getInt("puppyaccount"));
		bd.setPuppyBirthday(rs.getDate("puppybirthday"));
		bd.setReadyForSell(rs.getInt("readyforsell"));
		bd.setRemarks(rs.getString("remarks"));
		bd.setType(rs.getString("type"));
		return bd;
	}

}
