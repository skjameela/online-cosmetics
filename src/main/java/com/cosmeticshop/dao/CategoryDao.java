package com.cosmeticshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cosmeticshop.ModelMapper.CategoryMapper;
import com.cosmeticshop.model.Cart;
import com.cosmeticshop.model.Category;

@Repository
public class CategoryDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createCategoryTable() {
		
		String query = "CREATE TABLE IF NOT EXISTS CATEGORY(id int primary key auto_increment,name varchar(255), description varchar(255))";
		this.jdbcTemplate.update(query);
		System.out.println("create table category query executed");
		
	}
	
	public Category getCategoryById(int categoryId) {

		String query = "select * from Category where id="+categoryId;
		List<Category> categories = this.jdbcTemplate.query(query, new CategoryMapper());

		if(categories == null) {
			return null;
		}
		
		else {
			return categories.get(0);
		}

	}
	
	public List<Category> getAllCategory() {

		String query = "select * from Category";
		List<Category> categories = new ArrayList<>();
		categories = this.jdbcTemplate.query(query, new CategoryMapper());

		return categories;

	}
	
	public int save(Category category) {

		String query = "INSERT INTO Category ( name, description) VALUES ( ?, ?)";
		int update = this.jdbcTemplate.update(query,
				new Object[] { category.getName(), category.getDescription()});

		return update;
	}

	public int delete(int categoryId) {

		String query = "delete from Category where id="+categoryId;
		int update = this.jdbcTemplate.update(query);

		return update;

	}

}
