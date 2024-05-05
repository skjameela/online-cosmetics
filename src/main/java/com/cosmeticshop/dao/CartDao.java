package com.cosmeticshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cosmeticshop.ModelMapper.CartMapper;
import com.cosmeticshop.ModelMapper.ProductMapper;
import com.cosmeticshop.model.Cart;
import com.cosmeticshop.model.Product;


@Repository
public class CartDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createCartTable() {
		
		String query = "CREATE TABLE IF NOT EXISTS CART(id int primary key auto_increment,date varchar(255), productId int, quantity int, userId int)";
		this.jdbcTemplate.update(query);
		System.out.println("create table cart query executed");
		
	}
	
	public Cart getCartById(int cartId) {

		String query = "select * from Cart where id="+cartId;
		List<Cart> carts = new ArrayList<>();
		carts = this.jdbcTemplate.query(query, new CartMapper());

		if(carts.isEmpty()) {
			return null;
		}
		
		else {
			return carts.get(0);
		}

	}
	
	public int save(Cart cart) {

		String query = "INSERT INTO Cart (date, productId, userId, quantity) VALUES (?, ?, ?, ?)";
		int update = this.jdbcTemplate.update(query,
				new Object[] { cart.getDate(), cart.getProductId(), cart.getUserId(), cart.getQuantity()});

		return update;
	}

	public int delete(int cartId) {

		String query = "delete from Cart where id="+cartId;
		int update = this.jdbcTemplate.update(query);

		return update;

	}
	
	public List<Cart> getCartByUserId(int userId) {
		String query = "select * from Cart where userId="+userId;
		List<Cart> carts = new ArrayList<>();
		carts = this.jdbcTemplate.query(query, new CartMapper());

		return carts;
	}
	

}
