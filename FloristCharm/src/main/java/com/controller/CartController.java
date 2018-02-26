package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.model.*;
import com.Dao.*;
import com.DaoImpl.*;


@Controller
public class CartController 
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	OrdersDaoImpl ordersDaoImpl;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	
	@RequestMapping(value="/prodDetails/{pid}")
	public ModelAndView productDetails(@PathVariable("pid") int pid)
	{
		ModelAndView mv= new ModelAndView();
		Product p = productDaoImpl.findById(pid);
		mv.addObject("product",p);
		mv.setViewName("prodDetails");
		return mv;
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public ModelAndView addtoCart(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		Principal principal = request.getUserPrincipal();
		String userEmail = principal.getName();
		
		try
		{
			int pid= Integer.parseInt(request.getParameter("pId"));
			Double price = Double.parseDouble(request.getParameter("pPrice"));
			int qty = Integer.parseInt(request.getParameter("quant"));
			String prodName= request.getParameter("name");
			String imgName= request.getParameter("imgname");
			
			
			Cart cartExists = cartDaoImpl.getCartById(pid, userEmail);
			if(cartExists==null)
			{
				Cart cm = new Cart();
				cm.setCartProductId(pid);
				cm.setCartPrice(price);
				cm.setCartQuantity(qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(prodName);
				
				User u = userDaoImpl.findUserById(userEmail);
				
				cm.setCartUserDetails(u);
				cartDaoImpl.insert(cm);
				
			}
			else if(cartExists!=null)
			{
                     Cart cm = new Cart();
				cm.setCartId(cartExists.getCartId());
				cm.setCartProductId(pid);
				cm.setCartPrice(price);
				
				cm.setCartQuantity(cartExists.getCartQuantity()+qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(prodName);
				
				User u = userDaoImpl.findUserById(userEmail);
				
				cm.setCartUserDetails(u);
				cartDaoImpl.update(cm);
			}
		mv.addObject("cartInfo",cartDaoImpl.findCartById(userEmail));
		mv.setViewName("Cart");
		return mv;
		}
		catch(Exception e)
		{
			mv.addObject("cartInfo",cartDaoImpl.findCartById(userEmail));
			mv.setViewName("Cart");
			return mv;
		}
	}
	
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView goToCheckout(HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		
		Principal principal = req.getUserPrincipal();
		
		String userEmail = principal.getName();
		
		User user = userDaoImpl.findUserById(userEmail);
		
		List<Cart> cart = cartDaoImpl.findCartById(userEmail);
		
		mv.addObject("user", user);
		
		mv.addObject("cart", cart);
		
		return mv;
		
	}
   	
	
   @RequestMapping(value="/deletePCart/{cartId}")
   public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId, HttpServletRequest req)
   {
	   ModelAndView mv =new ModelAndView();
	   
	   Principal principal = req.getUserPrincipal();
	   
	   String userEmail = principal.getName();
	   
	   cartDaoImpl.deleteCart(cartId);
	   
	   mv.addObject("cartInfo", cartDaoImpl.findCartById(userEmail));
	   mv.setViewName("Cart");
	   return mv;
	   
	   
   }
   
   @RequestMapping(value="/invoiceprocess", method=RequestMethod.POST)
   public ModelAndView ordersSaved(HttpServletRequest req)
	
   {
	   ModelAndView mv = new ModelAndView("invoice");
	   Orders ord = new Orders();
	  
	   Principal principal = req.getUserPrincipal();
	   String userEmail = principal.getName();
	   List<Cart> cart = cartDaoImpl.findCartById(userEmail);
	   
	   Double total= Double.parseDouble(req.getParameter("total"));
	   String payment = req.getParameter("payment");
	   User users = userDaoImpl.findUserById(userEmail);
	   ord.setUser(users);
	   ord.setTotal(total);
	   ord.setPayment(payment);
	   ordersDaoImpl.insert(ord);
	   mv.addObject("user", userDaoImpl.findUserById(userEmail));
	   mv.addObject("orderDetails", users);
	   mv.addObject("cart", cart);
	   
	   return mv;
   }
   
   @RequestMapping("/ack")
   public String ack()
   {
	   return "ack";
   }
	
   
   @RequestMapping(value="/goToCart", method=RequestMethod.GET)
   public ModelAndView gotocart(HttpServletRequest req)
   {
	   ModelAndView mv = new ModelAndView();
	   
	   Principal principal = req.getUserPrincipal();
	   String userEmail = principal.getName();
	   mv.addObject("cartInfo", cartDaoImpl.findCartById(userEmail));
	   mv.setViewName("Cart");
	   return mv;
   }
	
}















