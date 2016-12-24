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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wxs.management.models.PetDog;
import com.wxs.management.services.DogService;
import com.wxs.management.services.rowmappers.PetDogRowMapper;

@Service
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
				UUID id = UUID.randomUUID();
				if (dog.getEpDate() == null) {
					dog.setEpDate(new Date());
				}
				if (dog.getBirthday() == null) {
					dog.setBirthday(new Date());
				}
				ps.setString(1, id.toString());
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

	@Override
	public void UpdateDogs(Map<String, Object> dogProps) {
		String sqlHead = "update petdog set ";
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
