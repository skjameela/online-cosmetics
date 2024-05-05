package com.cosmeticshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cosmeticshop.dao.UserDao;
import com.cosmeticshop.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/userlogin")
	public String goToLoginPage() {
		return "userlogin";
	}

	@GetMapping("/userregister")
	public String goToRegisterPage() {
		return "userregister";
	}
	
	@GetMapping("/admindashboard")
	public String goToAdminPage() {
		return "admin";
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		session.removeAttribute("active-user");
		session.removeAttribute("user-login");
		mv.addObject("status", "Logged out Successfully");
		mv.setViewName("index");

		return mv;
	}

	@PostMapping("/userregister")

	public ModelAndView registerAdmin(@ModelAttribute User user) {

		ModelAndView mv = new ModelAndView();

		String email = user.getEmailid();


		if (userDao.isEmailExists(email)) {

			mv.addObject("status", "User with this email already exists!");

			mv.setViewName("userregister");

		}

		else {

			this.userDao.save(user);

			mv.addObject("status", user.getFirstname() + " Successfully Registered!");

			mv.setViewName("userlogin");

		}

		return mv;

	}

	@PostMapping("/forgetpassword")

	public ModelAndView forgetpassword(@RequestParam("email") String email, @RequestParam("pass") String password,

	@RequestParam("phone") String phone) {

	ModelAndView mv = new ModelAndView();



	User user = userDao.getUserByEmailIdAndPhone(email, phone);



	if (user != null) {



	userDao.saveUpdate(email, phone, password);

	mv.addObject("status","Password reset done");

	mv.setViewName("index");

	}


	else {

	mv.addObject("status", "No User found!");

	mv.setViewName("userregister");

	}

	return mv;

	}
	@PostMapping("/userlogin")
	public ModelAndView loginAdmin(HttpServletRequest request, @RequestParam("emailid") String emailId,
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();

		User user = userDao.getUserByEmailIdAndPassword(emailId, password);

		/*
		 * if(user != null) { HttpSession session = request.getSession();
		 * session.setAttribute("active-user", user);
		 * session.setAttribute("user-login","user"); mv.addObject("status",
		 * user.getFirstname()+" Successfully Logged In!"); mv.setViewName("index"); }
		 * 
		 * else { mv.addObject("status","Failed to login!"); mv.setViewName("index"); }
		 */
		
		/*
		 * HttpSession httpSession = request.getSession(); if (user == null) {
		 * mv.addObject("status", "Failed to login!");
		 * 
		 * mv.setViewName("userlogin");
		 * 
		 * } else { mv.addObject("status",user.getFirstname() +
		 * " Successfully Logged In!"); if(user.getUsertype().equals("admin")) {
		 * httpSession.setAttribute("active-user", user);
		 * httpSession.setAttribute("user-login", "admin"); mv.setViewName("index"); }
		 * else if(user.getUsertype().equals("user")) { mv.setViewName("index");
		 * httpSession.setAttribute("active-user", user);
		 * httpSession.setAttribute("user-login", "user"); }
		 * 
		 * }
		 */
		  
		  
		  
		  
		  if(user!=null)
		  {
			  HttpSession httpSession = request.getSession(); 
			  mv.addObject("status",user.getFirstname() + " Successfully Logged In!"); 
			  if(user.getUsertype().equals("admin")) 
			  { 
				  httpSession.setAttribute("active-user", user);
				  httpSession.setAttribute("user-login", "admin");
				  mv.setViewName("index");
		      } else if(user.getUsertype().equals("user")) 
		      { 
		    	  mv.setViewName("index"); 
		    	  httpSession.setAttribute("active-user", user);
				  httpSession.setAttribute("user-login", "user");
		      }
		  }else
		  {
			  mv.addObject("status", "Failed to login!");
			  
			  mv.setViewName("userlogin");
			  
		  }
		 
		
	
		

		return mv;
	}

}
