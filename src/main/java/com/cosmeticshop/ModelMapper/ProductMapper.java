package com.cosmeticshop.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.cosmeticshop.model.Product;

public class ProductMapper implements RowMapper<Product>  {
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		product.setCategoryId(rs.getInt("categoryId"));
		product.setImagePath(rs.getString("imagePath"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setDiscount(rs.getDouble("discount"));
		product.setDescription(rs.getString("description"));
	    product.setId(rs.getInt("id"));
	    product.setQuantity(rs.getInt("quantity"));
		return product;
		
	}

}
