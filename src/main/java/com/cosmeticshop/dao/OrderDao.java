package com.cosmeticshop.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cosmeticshop.ModelMapper.CartMapper;
import com.cosmeticshop.ModelMapper.OrderMapper;
import com.cosmeticshop.model.Cart;
import com.cosmeticshop.model.Orders;
import com.cosmeticshop.model.Product;


@Repository
public class OrderDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createOrderTable() {
		
		String query = "CREATE TABLE IF NOT EXISTS ORDERS(id int primary key auto_increment,deliveryDate varchar(255), deliveryStatus varchar(255), orderDate varchar(255), orderId varchar(255), productId int, quantity int, userId int)";
		this.jdbcTemplate.update(query);
		System.out.println("create table order query executed");
	}

	public List<Orders> getOrderByOrderId(String orderId) {

		String query = "select * from Orders where orderId='"+orderId+"'";
		List<Orders> orders = new ArrayList<>();
		orders = this.jdbcTemplate.query(query, new OrderMapper());

			return orders;
		
	}
	
	public Orders getOrderById(int id) {

		String query = "select * from Orders where id="+id;
		List<Orders> orders = this.jdbcTemplate.query(query, new OrderMapper());

		if(orders == null) {
			return null;
		}
		
		else {
			return orders.get(0);
		}

	}
	
	
	public int save(Orders order) {

		String query = "INSERT INTO Orders (orderId, userId, productId, quantity, orderDate, deliveryDate, deliveryStatus) VALUES (?, ?, ?, ?,?,?,?)";
		int update = this.jdbcTemplate.update(query,
				new Object[] { order.getOrderId(), order.getUserId(), order.getProductId(), order.getQuantity(),order.getOrderDate(), order.getDeliveryDate(), order.getDeliveryStatus()});

		return update;
	}
	
	public List<Orders>  getAllOrder() {

		String query = "select * from Orders";
		List<Orders> orders = new ArrayList<>();
		orders = this.jdbcTemplate.query(query, new OrderMapper());

			return orders;

	}
	
	public List<Orders> getOrderByUserId(int userId) {

		String query = "select * from Orders where userId="+userId;
		List<Orders> orders = new ArrayList<>();
		orders = this.jdbcTemplate.query(query, new OrderMapper());

			return orders;

	}
	
	public List<Orders> getOrderByorderId(String OrderId) {

		String query = "select * from Orders where OrderId='"+OrderId+"'";
		List<Orders> orders = new ArrayList<>();
		orders = this.jdbcTemplate.query(query, new OrderMapper());

			return orders;

	}
	
	
	public List<Orders> getOrderByOrderDateAndUserId(String orderDate,int userId) {

		String query = "select * from Orders where orderDate='"+orderDate+"' and userId="+userId;
		List<Orders> orders = new ArrayList<>();
		orders = this.jdbcTemplate.query(query, new OrderMapper());

			return orders;

	}
	
	public void update(Orders order) {

		String sql = "UPDATE orders SET deliverystatus = ?, deliverydate = ? WHERE orderid = ?";

		jdbcTemplate.update(sql, order.getDeliveryStatus(), order.getDeliveryDate(), order.getOrderId());

		}
	
}
