package com.wxs.management.services.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wxs.management.models.PetDog;


public class PetDogRowMapper  implements RowMapper<PetDog> {

	@Override
	public PetDog mapRow(ResultSet rs, int rowNum) throws SQLException {
		PetDog pd = new PetDog();
		pd.setId(rs.getString("id"));
		pd.setType(rs.getString("type"));
		pd.setName(rs.getString("name"));
		pd.setEpDate(rs.getDate("epdate"));
		pd.setBirthday(rs.getDate("birthday"));
		pd.setKennelId(rs.getString("kennelid"));
		pd.setChipId(rs.getString("chipid"));
		pd.setEarId(rs.getString("earid"));
		pd.setCompanyCode(rs.getString("companycode"));
		pd.setRemarks(rs.getString("remarks"));
		
		pd.setTrainingLevel(rs.getInt("traininglevel"));
		pd.setTrainer(rs.getString("trainer"));
		pd.setBreeder(rs.getString("breeder"));
		pd.setApperance(rs.getString("apperance"));
		pd.setReadyForSell(rs.getInt("readyforsell"));
		pd.setPrice(rs.getFloat("price"));
		pd.setCategory(rs.getString("category"));
		return pd;
	}

}
