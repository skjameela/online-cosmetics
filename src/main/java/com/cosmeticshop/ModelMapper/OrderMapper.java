package com.cosmeticshop.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cosmeticshop.model.Orders;

public class OrderMapper implements RowMapper<Orders>  {
	
	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Orders order = new Orders();
		order.setDeliveryDate(rs.getString("deliveryDate"));
		order.setDeliveryStatus(rs.getString("deliveryStatus"));
		order.setId(rs.getInt("id"));
		order.setOrderDate(rs.getString("orderDate"));
		order.setOrderId(rs.getString("orderId"));
		order.setQuantity(rs.getInt("quantity"));
		order.setProductId(rs.getInt("productId"));
		order.setUserId(rs.getInt("userId"));
		
		return order;
		
	}

}
