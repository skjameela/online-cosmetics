package com.cosmeticshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cosmeticshop.ModelMapper.ProductMapper;
import com.cosmeticshop.model.Product;
import com.cosmeticshop.model.User;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createProductTable() {

		String query = "CREATE TABLE IF NOT EXISTS PRODUCT(id int primary key auto_increment,categoryId int, description varchar(255), discount double, imagePath varchar(255), name varchar(255), price double, quantity int)";
		this.jdbcTemplate.update(query);
		System.out.println("create table product query executed");

	}

	public int save(Product product) {

		String query = "INSERT INTO product (categoryId, description, discount, imagePath, name, price, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int update = this.jdbcTemplate.update(query,
				new Object[] { product.getCategoryId(), product.getDescription(), product.getDiscount(),
						product.getImagePath(), product.getName(), product.getPrice(), product.getQuantity() });

		return update;
	}

	public int update(Product product) {

		String query = "UPDATE PRODUCT SET categoryId=?, description=?, discount=?, imagePath=?, name=?, price=?, quantity=? WHERE id=?";
		int update = this.jdbcTemplate.update(query,
				new Object[] { product.getCategoryId(), product.getDescription(), product.getDiscount(),
						product.getImagePath(), product.getName(), product.getPrice(), product.getQuantity(),
						product.getId() });

		return update;

	}

	public List<Product> searchProductsByName(String productName) {

		String query = "select * from Product where name LIKE '%"+ productName+ "%'";
		List<Product> products = new ArrayList<>();
				
		products = this.jdbcTemplate.query(query, new ProductMapper());

		return products;

	}
	
	public Product getProductById(int productId) {

		String query = "select * from Product where id="+productId;
		List<Product> products = this.jdbcTemplate.query(query, new ProductMapper());

		if(products.isEmpty()) {
			return null;
		}
		
		else {
			return products.get(0);
		}

	}

	public int delete(int productId) {

		String query = "delete from Product where id="+productId;
		int update = this.jdbcTemplate.update(query);

		return update;

	}
	
	public List<Product> getProductsByCategoryId(int categoryId) {

		String query = "select * from Product where categoryId="+categoryId;
		List<Product> products = new ArrayList<>();
		
		products = this.jdbcTemplate.query(query, new ProductMapper());

		return products;


	}
	
	public List<Product> getAllProducts() {

		String query = "select * from Product";
		List<Product> products = new ArrayList<>();
		
		products = this.jdbcTemplate.query(query, new ProductMapper());

		return products;


	}
	
}
