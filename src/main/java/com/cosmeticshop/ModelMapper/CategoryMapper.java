package com.cosmeticshop.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cosmeticshop.model.Category;

public class CategoryMapper implements RowMapper<Category>  {
	
	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setDescription(rs.getString("description"));
		
		return category;
	}

}
