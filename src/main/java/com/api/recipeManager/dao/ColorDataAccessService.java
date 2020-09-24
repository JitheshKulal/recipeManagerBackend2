package com.api.recipeManager.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.recipeManager.model.Color;

@Repository("postgrescol")
public class ColorDataAccessService implements ColorDao{
	private final JdbcTemplate jdbctemplate;
	
	public ColorDataAccessService(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbctemplate = jdbcTemplate;
	}
	
	@Override
	public int deleteColor(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "DELETE FROM RM_COLOR_DATA where id = ?";
		return jdbctemplate.update(sql,objectId);
	}
	@Override
	public List<Color> getAllColor() {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,colorname,description FROM RM_COLOR_DATA";
		return jdbctemplate.query(sql, (resultSet,i)->{
			return new Color(resultSet.getString("id"), resultSet.getString("colorname"), resultSet.getString("description"));
		});
	}@Override
	public List<Color> getColor(String objectId) {
		// TODO Auto-generated method stub
		final String sql = "SELECT id,colorname,description FROM RM_COLOR_DATA where id = ?";
		return jdbctemplate.query(sql, (resultSet,i)->{
			return new Color(resultSet.getString("id"), resultSet.getString("colorname"), resultSet.getString("description"));
		},objectId);
	}@Override
	public int insertColor(Color color) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO RM_COLOR_DATA ("
				+ "id,"
				+ "colorname,"
				+ "description,"
				+ "submittime) VALUES("
				+ "'COL-'||nextval('RM_COLOR_SEQ'),"
				+ "?,"
				+ "?,"
				+ "CURRENT_DATE)";
		return jdbctemplate.update(sql,color.getColorName(),color.getDescription());
	}
	
}
