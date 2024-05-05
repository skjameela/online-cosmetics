package com.cosmeticshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cosmeticshop.dao.CartDao;
import com.cosmeticshop.dao.ProductDao;
import com.cosmeticshop.model.Cart;
import com.cosmeticshop.model.Product;


@Controller
public class CartController {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@GetMapping("/addToCart")
	public ModelAndView addtoCart(@ModelAttribute Cart cart) {
		ModelAndView mv = new ModelAndView();
		
		Product product  = this.productDao.getProductById(cart.getProductId());
		
		if(cart.getQuantity() > product.getQuantity() ) {
			mv.addObject("status", "Insufficient Product Quantity!");
			mv.setViewName("index");
			
			return mv;
			
		}
	
		cartDao.save(cart);
		mv.addObject("status", "Product added to cart!");
		mv.setViewName("index");
		
		return mv;
	
	}
	
	@GetMapping("/deletecart")
	public ModelAndView deleteProductFromCart(@RequestParam("cartId") int  cartId) {
		ModelAndView mv = new ModelAndView();
		
		Cart cart = new Cart();
	
		int deletedCart = cartDao.delete(cartId);
		
		mv.addObject("status", "Selected Product removed from Cart!");
		mv.setViewName("index");
		
		return mv;
	}
	
}
