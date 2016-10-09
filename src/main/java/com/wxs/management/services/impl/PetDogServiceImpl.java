package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wxs.management.models.PetDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.PetDogRowMapper;

@Repository
public class PetDogServiceImpl implements DogService<PetDog> {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PetDog> getAll() {
		List<PetDog> pdList = new ArrayList<PetDog>();
		pdList = jdbcTemplate.query("select * from petdog", new PetDogRowMapper());
		return pdList;
	}

	@Override
	public void AddDogs(List<PetDog> dogs) {
		String sql = "insert into petdog values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PetDog dog = dogs.get(i);
				ps.setString(1, dog.getId());
				ps.setString(2, dog.getType());
				ps.setString(3, dog.getName());
				ps.setInt(4, dog.getTrainingLevel());
				ps.setString(5, dog.getTrainer());
				ps.setString(6, dog.getBreeder());
				ps.setDate(7, new java.sql.Date(dog.getBirthday().getTime()));
				ps.setString(8, dog.getApperance());
				ps.setInt(9, dog.getReadyForSell());
				ps.setFloat(10, dog.getPrice());
				ps.setDate(11, new java.sql.Date(dog.getEpDate().getTime()));
				ps.setString(12, dog.getChipId());
				ps.setString(13, dog.getEarId());
				ps.setString(14, dog.getKennelId());
				ps.setString(15, dog.getCategory());
				ps.setString(16, dog.getCompanyCode());
				ps.setString(17, dog.getRemarks());
			}

			@Override
			public int getBatchSize() {
				return dogs.size();
			}
			
		});
		
	}

}
