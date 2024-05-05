package com.cosmeticshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cosmeticshop.dao.CategoryDao;
import com.cosmeticshop.dao.ProductDao;
import com.cosmeticshop.model.Category;
import com.cosmeticshop.model.Product;


@Controller
public class CategoryController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@PostMapping("/addcategory")
	public ModelAndView addcategory(@ModelAttribute Category category) {
		ModelAndView  mv = new ModelAndView();
		
		categoryDao.save(category);
		
		mv.addObject("status", "Category Added Successfully!");
		mv.setViewName("index");
		
		return mv;
	}
	
	@GetMapping("/deletecategory")
	public ModelAndView deleteCategory(@RequestParam("categoryId") int categoryId) {
        ModelAndView  mv = new ModelAndView();
		
        categoryDao.delete(categoryId);
		
		mv.addObject("status", "Category Deleted Successfully!");
		mv.setViewName("index");
		
		return mv;
	}
	
	@GetMapping("/category")
	public ModelAndView category(@RequestParam("categoryId") int  categoryId) {
		ModelAndView mv = new ModelAndView();
		List<Product> products = productDao.getProductsByCategoryId(categoryId);
		
		mv.addObject("products", products);
		mv.addObject("sentFromOtherSource", "yes");
		mv.setViewName("index");
		
		return mv;
	}

}
