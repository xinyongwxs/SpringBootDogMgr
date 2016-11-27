package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wxs.management.models.WorkingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.WorkingDogRowMapper;

@Service
public class WorkingDogServiceImpl implements DogService<WorkingDog> {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<WorkingDog> getAll() {
		List<WorkingDog> wdList = new ArrayList<WorkingDog>();
		wdList = jdbcTemplate.query("select * from workingdog", new WorkingDogRowMapper());
		return wdList;
	}

	@Override
	public void AddDogs(List<WorkingDog> dogs) {
		String sql = "insert into trainingdog values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				WorkingDog dog = dogs.get(i);
				ps.setString(1, dog.getId());
				ps.setString(2, dog.getType());
				ps.setString(3, dog.getName());
				ps.setInt(4, dog.getTrainingLevel());
				ps.setString(5, dog.getTrainer());
				ps.setDate(6, new java.sql.Date(dog.getBirthday().getTime()));
				ps.setInt(7, dog.getReadyForWorking());
				ps.setFloat(8, dog.getPrice());
				ps.setString(9, dog.getCategory());
				ps.setString(10, dog.getChipId());
				ps.setString(11, dog.getEarId());
				ps.setString(12, dog.getCompanyCode());
				ps.setString(13, dog.getRemarks());
				ps.setDate(14, new java.sql.Date(dog.getEpDate().getTime()));
				ps.setString(15, dog.getKennelId());
			}

			@Override
			public int getBatchSize() {
				return dogs.size();
			}});
	}

}
