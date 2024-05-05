package com.cosmeticshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cosmeticshop.dao.CartDao;
import com.cosmeticshop.dao.CategoryDao;
import com.cosmeticshop.dao.OrderDao;
import com.cosmeticshop.dao.ProductDao;
import com.cosmeticshop.dao.UserDao;

@SpringBootApplication
public class OnlineCosmeticApplication implements CommandLineRunner {

	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartDao cartDao;
	
	
	
	@Autowired
	private CategoryDao categoryDao;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineCosmeticApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		this.productDao.createProductTable();
		this.userDao.createUserTable();
		this.categoryDao.createCategoryTable();
		
		this.cartDao.createCartTable();
		this.orderDao.createOrderTable();
	}

}
