package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				ps.setString(1, dog.getId());
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

}
