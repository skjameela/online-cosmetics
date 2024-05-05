package com.cosmeticshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cosmeticshop.dao.ProductDao;
import com.cosmeticshop.model.Product;

@Controller
@MultipartConfig
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/addproduct")
	public ModelAndView addProduct(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        ModelAndView mv = new ModelAndView();
		
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Double price=Double.parseDouble(request.getParameter("price"));
		Double discount=Double.parseDouble(request.getParameter("discount"));
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		Part part=request.getPart("image");	
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		String fileName=part.getSubmittedFileName();
		
		//String uploadPath="C:\\Users\\User\\Downloads\\online-cosmetic\\online-cosmetic\\src\\main\\webapp\\resources\\productpic"+fileName;
		 String path = request.getServletContext().getRealPath("resources") + File.separator +"productpic" + File.separator +fileName;
         System.out.println(path);
		try
		{
		FileOutputStream fos=new FileOutputStream(path);
		InputStream is=part.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Product product = new Product();
		product.setCategoryId(categoryId);
		product.setImagePath(fileName);
		product.setName(name);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setDescription(description);
		product.setQuantity(quantity);
	    
		int productAdded = productDao.save(product);
		
		if(productAdded > 0  )
	    {
			mv.addObject("status", "product Added Successfully.");
	    }
	    
	   else
	    {
		   mv.addObject("status", "Failed to add product.");
	    }
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
		 ModelAndView mv = new ModelAndView();
			int id = Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			Double price=Double.parseDouble(request.getParameter("price"));
			Double discount=Double.parseDouble(request.getParameter("discount"));
			int categoryId=Integer.parseInt(request.getParameter("categoryId"));
			Part part=request.getPart("image");	
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			String fileName=part.getSubmittedFileName();
			
			//String uploadPath="E:\\spring boot project\\online-cosmetic\\src\\main\\webapp\\resources\\productpic\\resources\\productpic\\"+fileName;
			 String path = request.getServletContext().getRealPath("resources") + File.separator +"productpic" + File.separator + part.getSubmittedFileName();
             System.out.println(path);
			
			try
			{
			FileOutputStream fos=new FileOutputStream(path);
			InputStream is=part.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			Product product = new Product();
			product.setCategoryId(categoryId);
			product.setImagePath(fileName);
			product.setName(name);
			product.setPrice(price);
			product.setDiscount(discount);
			product.setDescription(description);
		    product.setId(id);
		    product.setQuantity(quantity);
			
            int updatedProduct = productDao.update(product);
			
			if(updatedProduct > 0 )
		    {
				mv.addObject("status", "Product updated Successfully.");
		    }
		    
		    else
		    {
			   mv.addObject("status", "Failed to update Product.");
		    }
			
			mv.setViewName("index");
			
			return mv;
	}
	
	@GetMapping("/searchproduct")
	public ModelAndView searchProductByName(@RequestParam("productname") String productName) throws IOException, ServletException {
		ModelAndView mv = new ModelAndView();
		List<Product> products = new ArrayList<>();
		products = productDao.searchProductsByName(productName);
		   
		mv.addObject("sentFromOtherSource","yes");
		mv.addObject("products", products);
		mv.setViewName("index");
		
		return mv;
	}
	
	@GetMapping("/product")
	public ModelAndView getproduct(@RequestParam("productId") int productId) throws IOException, ServletException {
		ModelAndView mv = new ModelAndView();
		Product product = null;
		product = productDao.getProductById(productId);
		
		mv.addObject("product", product);
		mv.setViewName("product");
		
		return mv;
	}
	
	@GetMapping("/deleteproduct")
	public ModelAndView deleteproduct(@RequestParam("productId") int productId) throws IOException, ServletException {
		ModelAndView mv = new ModelAndView();
		
		int deletedProduct = productDao.delete(productId);
		
		if(deletedProduct > 0) {
			mv.addObject("status", "product Deleted Successfully!");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "failed to deleted product!");
			mv.setViewName("index");
		}
		
		return mv;
	}
	
	@GetMapping("/updateproduct")
	public ModelAndView updateproduct(@RequestParam("productId") int productId) throws IOException, ServletException {
		ModelAndView mv = new ModelAndView();
		
		Product product = null;
		product = productDao.getProductById(productId);
		
		mv.addObject("product", product);
		mv.setViewName("updateproduct");
		
		return mv;
	}
	
}
