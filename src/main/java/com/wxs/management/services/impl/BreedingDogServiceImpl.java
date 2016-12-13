package com.wxs.management.services.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wxs.management.models.BreedingDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.BreedingDogRowMapper;

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
	public void UpdateDogs(BreedingDog dogs) {
		
		String sql = "update workingdog set trainer=?,price=? where id=?";
		
//		jdbcTemplate.update(sql, );
		
	}

}
