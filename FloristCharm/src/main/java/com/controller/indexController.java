package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.*;
import com.model.*;




@Controller
public class indexController 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@RequestMapping("/login")
	public String login()
	{
	return "/login";	
	}
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
		return "redirect:/index";
	}
	
	@RequestMapping("/error")
	public String errorPage()
	{
		return "/error";
	}

	
	@RequestMapping("/")
   	public String index()
	{
		return "index";
	}

@RequestMapping("/index")
	public String home()
{
	return "index";
}

/*
@RequestMapping("/register")
	public String showregister()
{
	return "register";
}
*/
/*@RequestMapping("/goTologin")
public String loginProcess()
{
return "login";
}*/




@RequestMapping(value="/register", method = RequestMethod.GET)
public ModelAndView showRegister()
{
	ModelAndView mav = new ModelAndView();
	// This class can map the view with it's corresponding Model class
	//Thus we use the object of this class to take reference of model class
	// and name of view
	mav.addObject("user", new User());// class
	mav.setViewName("register");// jsp
	return mav;
	
}

@RequestMapping("/goTologin")
public ModelAndView goToLogin()
{
	ModelAndView mav = new ModelAndView();
	mav.setViewName("login");
	return mav;
	
}


@RequestMapping(value="/saveregister", method = RequestMethod.POST)
public ModelAndView saveRegister(@Valid @ModelAttribute("user") User user, BindingResult result)
{
	ModelAndView mav= new ModelAndView();
	if(result.hasErrors())
	{
		mav.setViewName("register");
		return mav;
		
	}
	else
	{
		user.setRole("ROLE_USER");// by default anyone who registers will be marked as user
		userDaoImpl.insertUser(user);// all data are coming from spring form, only 
		//role data is set here
		mav.setViewName("redirect:/login");
		return mav;
	}
	
}

@ModelAttribute
public void addAdttributes(Model m)
{
	m.addAttribute("catList", categoryDaoImpl.retrieve());
	m.addAttribute("satList", supplierDaoImpl.retrieve());
	m.addAttribute("prodList", productDaoImpl.retrieve());
//"prodList" is a reference which is storing the list of data from 
	// retrieve() of ProductDaoImpl. This "prodList" object reference
	// will be used in the JSP page to display the data thru EL

}

	
@RequestMapping(value="/productCustList")
public ModelAndView getCustTable(@RequestParam ("cid") int cid)
{
	System.out.println(cid);
	ModelAndView mv = new ModelAndView();
	mv.addObject("prodList", productDaoImpl.retrieve());
	mv.setViewName("productCustList");
	return mv;
	
}
	

}







