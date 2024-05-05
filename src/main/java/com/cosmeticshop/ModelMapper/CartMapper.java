package com.cosmeticshop.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cosmeticshop.model.Cart;

public class CartMapper implements RowMapper<Cart>  {
	
	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cart cart = new Cart();
		cart.setId(rs.getInt("id"));
		cart.setDate(rs.getString("date"));
		cart.setProductId(rs.getInt("productId"));
		cart.setQuantity(rs.getInt("quantity"));
		cart.setUserId(rs.getInt("userId"));
		
		return cart;
		
	}

}
