package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.wxs.management.models.TrainingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.TrainingDogRowMapper;

@Service
public class TrainingDogServiceImpl implements DogService<TrainingDog> {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TrainingDog> getAll() {
		List<TrainingDog> tdList = new ArrayList<TrainingDog>();
		tdList = jdbcTemplate.query("select * from trainingdog", new TrainingDogRowMapper());
		return tdList;
	}

	@Override
	public void AddDogs(List<TrainingDog> dogs) {
		String sql = "insert into trainingdog values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				TrainingDog dog = dogs.get(i);
				UUID id = UUID.randomUUID();
				
				if (dog.getEpDate() == null) {
					dog.setEpDate(new Date());
				}
				if (dog.getBirthday() == null) {
					dog.setBirthday(new Date());
				}
				ps.setString(1, id.toString());
				ps.setString(2, dog.getOwnerPhone());
				ps.setString(3, dog.getType());
				ps.setString(4, dog.getGender());
				ps.setString(5, dog.getKennelId());
				ps.setString(6, dog.getChipId());
				ps.setString(7, dog.getEarId());
				ps.setString(8, dog.getCourses());
				ps.setDate(9, new java.sql.Date(dog.getStartDate().getTime()));
				ps.setDate(10, new java.sql.Date(dog.getEndDate().getTime()));
				ps.setString(11, dog.getCompanyCode());
				ps.setString(12, dog.getRemarks());
				ps.setString(13, dog.getOwnerId());
				ps.setDate(14, new java.sql.Date(dog.getEpDate().getTime()));
				ps.setDate(15, new java.sql.Date(dog.getBirthday().getTime()));
				ps.setString(16, dog.getName());
			}

			@Override
			public int getBatchSize() {
				return dogs.size();
			}});
		
	}

	@Override
	public void UpdateDogs(Map<String, Object> dogProps) {
		String sqlHead = "update trainingdog set ";
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
