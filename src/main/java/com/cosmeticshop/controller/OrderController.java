package com.cosmeticshop.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cosmeticshop.dao.CartDao;
import com.cosmeticshop.dao.OrderDao;
import com.cosmeticshop.dao.ProductDao;
import com.cosmeticshop.model.Cart;
import com.cosmeticshop.model.Orders;
import com.cosmeticshop.model.Product;
import com.cosmeticshop.model.User;
import com.cosmeticshop.utility.Constants;
import com.cosmeticshop.utility.Helper;


@Controller
public class OrderController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;

	@PostMapping("/order")
	public ModelAndView orderfoods(HttpSession session) {
        ModelAndView mv = new ModelAndView();
		
        User user = (User)session.getAttribute("active-user");
        
		String orderId = Helper.getAlphaNumericOrderId(10);
		String orderedDate = LocalDate.now().toString();
		
		List<Cart> carts = cartDao.getCartByUserId(user.getId());
		
		for(Cart cart : carts) {
			Orders order = new Orders();
			Product product = this.productDao.getProductById(cart.getProductId());
		
			order.setOrderDate(orderedDate);
			order.setOrderId(orderId);
			order.setUserId(user.getId());
			order.setQuantity(cart.getQuantity());
			order.setProductId(cart.getProductId());
			order.setDeliveryStatus(Constants.DeliveryStatus.PENDING.value());
			order.setDeliveryDate(Constants.DeliveryStatus.PENDING.value());
			product.setQuantity(product.getQuantity() - cart.getQuantity());
			orderDao.save(order);
			productDao.update(product);
			cartDao.delete(cart.getId());
		}
		
	
	    mv.addObject("status","Order placed Successfully, Order Id is "+orderId);
	    List<Orders> orders = orderDao.getOrderByorderId(orderId); 
		mv.addObject("orders", orders);
		mv.setViewName("payment");
		return mv;
	}
	
	@GetMapping("/myorder")
	public ModelAndView goToMyOrder(HttpSession session) {
		
		User user = (User)session.getAttribute("active-user");
		ModelAndView mv = new ModelAndView();
		List<Orders> orders = orderDao.getOrderByUserId(user.getId()); 
		mv.addObject("orders", orders);
		mv.setViewName("myorder");
		return mv;
	}
	
	@GetMapping("/searchorderbyid")
	public ModelAndView searchByOrderId(@RequestParam("orderid") String orderId) {
		ModelAndView mv = new ModelAndView();
		List<Orders> orders = orderDao.getOrderByOrderId(orderId);
		mv.addObject("orders", orders);
		mv.setViewName("myorder");
		return mv;
	}
	
	@GetMapping("/searchorderbydate")
	public ModelAndView searchByOrderDate(@RequestParam("orderdate") String orderDate, HttpSession session) {
		User user = (User)session.getAttribute("active-user");
		ModelAndView mv = new ModelAndView();
		List<Orders> orders = orderDao.getOrderByOrderDateAndUserId(orderDate, user.getId());
		mv.addObject("orders", orders);
		mv.setViewName("myorder");
		return mv;
	}
	
	@PostMapping("/checkout")
	public ModelAndView searchByOrderDate(@RequestParam("amount") String amount) {
		
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("amount", amount);
		mv.setViewName("checkout");
		return mv;
	}
	
	@GetMapping("/updatedeliverydate")
	public ModelAndView addDeliveryStatus(@RequestParam("orderId") String orderId, @RequestParam("deliveryStatus") String deliveryStatus, @RequestParam("deliveryDate") String deliveryDate ) {
		ModelAndView mv = new ModelAndView();
		
		List<Orders> orders = this.orderDao.getOrderByOrderId(orderId);
		
		for(Orders order : orders) {
			order.setDeliveryDate(deliveryDate);
			order.setDeliveryStatus(deliveryStatus);
		    this.orderDao.update(order);
		}
			mv.addObject("status", "Order Delivery Status Updated.");
			mv.setViewName("index");
	        return mv;
	}
	
	
}
