package com.api.recipeManager.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Chemical;

@Repository("postgreschem")
public class ChemicalDataAccessService implements ChemicalDao{
	
	private final JdbcTemplate jdbctemplate;
	
	public ChemicalDataAccessService(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbctemplate = jdbcTemplate;
	}
	
	@Override
	public int deleteChemical(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "DELETE FROM RM_CHEMICAL_DATA where id = ?";
		return jdbctemplate.update(sql,objectId);
	}
	@Override
	public List<Chemical> getAllChemical() {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,chemicalname,description FROM RM_CHEMICAL_DATA";
		return jdbctemplate.query(sql, (resultSet,i)->{
			return new Chemical(resultSet.getString("id"), resultSet.getString("chemicalname"), resultSet.getString("description"));
		});
	}@Override
	public List<Chemical> getChemical(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,chemicalname,description FROM RM_CHEMICAL_DATA where id = ?";
		return jdbctemplate.query(sql, (resultSet,i)->{
			return new Chemical(resultSet.getString("id"), resultSet.getString("chemicalname"), resultSet.getString("description"));
		},objectId);
	}@Override
	public int insertChemical(Chemical chemical) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO RM_CHEMICAL_DATA ("
				+ "id,"
				+ "chemicalname,"
				+ "description,"
				+ "submittime) VALUES("
				+ "'CHE-'||nextval('RM_CHEMICAL_SEQ'),"
				+ "?,"
				+ "?,"
				+ "CURRENT_DATE)";
		return jdbctemplate.update(sql,chemical.getChemicalName(),chemical.getDescription());
	}
}
