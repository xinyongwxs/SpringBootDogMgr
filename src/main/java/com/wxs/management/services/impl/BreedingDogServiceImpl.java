package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wxs.management.models.BreedingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.BreedingDogRowMapper;
import java.util.UUID;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Service
public class BreedingDogServiceImpl implements DogService<BreedingDog> {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BreedingDog> getAll() {
		List<BreedingDog> bDogList = new ArrayList<BreedingDog>();
		bDogList = jdbcTemplate.query("select * from breedingdog", new BreedingDogRowMapper());
		return bDogList;
	}
	

	@Override
	public void AddDogs(List<BreedingDog> dogs) {
		String sql = "insert into breedingdog values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				BreedingDog dog = dogs.get(i);
				ps.setString(1, dog.getId());
				if (dog.getMatingDate() == null) {
					dog.setMatingDate(new Date());
				}
				if (dog.getPuppyBirthday() == null) {
					dog.setPuppyBirthday(new Date());
				}
				if (dog.getEpDate() == null) {
					dog.setEpDate(new Date());
				}
				if (dog.getBirthday() == null) {
					dog.setBirthday(new Date());
				}
				if (dog.getCategory() == null) {
					dog.setCategory("");
				}
				if (dog.getChipId() == null) {
					dog.setChipId("");
				}
				if (dog.getCompanyCode() == null) {
					dog.setCompanyCode("");
				}
				if (dog.getEarId() == null) {
					dog.setEarId("");
				}
				if (dog.getKennelId() == null) {
					dog.setKennelId("");
				}
				if (dog.getFeeder() == null) {
					dog.setFeeder("");
				}
				if (dog.getName() == null) {
					dog.setName("");
				}
				if (dog.getType() == null) {
					dog.setType("");
				}
				if (dog.getRemarks() == null) {
					dog.setRemarks("");
				}
				ps.setDate(2, new java.sql.Date(dog.getMatingDate().getTime()));
				ps.setDate(3, new java.sql.Date(dog.getPuppyBirthday().getTime()));
				ps.setDate(4, new java.sql.Date(dog.getEpDate().getTime()));
				ps.setString(5, dog.getFeeder());
				ps.setInt(6, dog.getReadyForSell());
				ps.setFloat(7, dog.getPrice());
				ps.setString(8, dog.getChipId());
				ps.setString(9, dog.getEarId());
				ps.setString(10, dog.getType());
				ps.setInt(11, dog.getPuppyAccount());
				ps.setString(12, dog.getKennelId());
				ps.setString(13, dog.getCategory());
				ps.setString(14, dog.getCompanyCode());
				ps.setString(15, dog.getRemarks());
				ps.setString(16, dog.getName());
				ps.setDate(17, new java.sql.Date(dog.getBirthday().getTime()));
			}

			@Override
			public int getBatchSize() {
				return dogs.size();
			}
			
		});
	}


	@Override
	public void UpdateDogs(Map<String, Object> dogProps) {
		String sqlHead = "update breedingdog set ";
		List<String> params = new ArrayList<String>();
		if (!dogProps.isEmpty()) {
			for (Map.Entry<String, Object> entry : dogProps.entrySet()) {
				if (!entry.getKey().equals("id")) {
					sqlHead = sqlHead.concat(entry.getKey() + "=?,");
					params.add(entry.getValue().toString());
				}
			}
			
			sqlHead = sqlHead.substring(0, sqlHead.length() - 1);
			
			params.add(dogProps.get("id").toString());
		}
		
		String sql = sqlHead + " where id=?";
		
		jdbcTemplate.update(sql, params.toArray());
		
	}

}
