package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
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

@SuppressWarnings("unused")
@Controller
@RequestMapping("/admin")
public class adminController
{ 
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	
	
	@RequestMapping("/adding")
	public String addPage()
	{return "adding";
		
	}
	@RequestMapping("/index")
	public String addHome()
	{return "index";
		
	}
	
	@RequestMapping(value="/saveCat", method= RequestMethod.POST)
	@Transactional
	public ModelAndView saveCategory(@RequestParam("cid") int cid, @RequestParam("name") String name)
	{
		ModelAndView mav = new ModelAndView();// this methods maps model with view
		Category c = new Category();// creating the model class object c
		c.setCid(cid);// setter method invoked
		c.setName(name);//setter method invoked
		categoryDaoImpl.insertCategory(c);// insert() invoked from CategoryDaoImpl
		mav.setViewName("modal");
		//mav.setViewName("index");
	return mav;

}
	@RequestMapping(value="/saveSupp", method= RequestMethod.POST)
	@Transactional
	public ModelAndView saveSupplier(@RequestParam("sid") int sid, @RequestParam("supplierName") String supplierName)
	{
		ModelAndView mav = new ModelAndView();
		Supplier ss= new Supplier();
		ss.setSid(sid);
		ss.setSupplierName(supplierName);
		supplierDaoImpl.insertSupplier(ss);
		mav.setViewName("modal");
	return mav;

}

		
@RequestMapping(value="/saveProduct", method= RequestMethod.POST)
public String saveProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file)
{
	Product prod= new Product();
	prod.setName(request.getParameter("pName"));
    prod.setPrice(Float.parseFloat(request.getParameter("pPrice")));
    prod.setDescription(request.getParameter("pDescription"));
    prod.setStock(Integer.parseInt(request.getParameter("pStock")));
    prod.setCategory(categoryDaoImpl.findById(Integer.parseInt(request.getParameter("pCategory"))));
    prod.setSupplier(supplierDaoImpl.findById(Integer.parseInt(request.getParameter("pSupplier"))));
	
    String filepath=request.getSession().getServletContext().getRealPath("/");
    String filename = file.getOriginalFilename();// imgname
    prod.setImgname(filename);
    productDaoImpl.insertProduct(prod);// except image//image file is going to real path
    System.out.println("File path File "+ filepath+ " " + filename);
    try
    {
    	byte imagebyte[] = file.getBytes();
    	BufferedOutputStream fos = new BufferedOutputStream
                                     (new FileOutputStream(filepath+"/resources/" + filename));
    
           fos.write(imagebyte);
    	fos.close();
    		
                                  
           }catch(IOException e)
    {
        	  e.printStackTrace();

    }catch(Exception e)
    {
    	e.printStackTrace();
    }
	return "modal";
}
@RequestMapping("/productList")
public ModelAndView productList() {
	ModelAndView mav = new ModelAndView();
	mav.addObject("prodList", productDaoImpl.retrieve());
	mav.setViewName("productList");
	return mav;
}

@ModelAttribute
public void addAdttributes(Model m)
{
	m.addAttribute("catList", categoryDaoImpl.retrieve());// list object
	m.addAttribute("satList", supplierDaoImpl.retrieve());//list object
	m.addAttribute("prodList", productDaoImpl.retrieve());//list object
}

@RequestMapping("/deleteProduct/{pid}")
public String deleteProd(@PathVariable("pid") int pid)// advance spring annotation
{
  productDaoImpl.deleteProduct(pid);
  return "redirect:/admin/productList?del";
}

@RequestMapping("/updateProduct")
public ModelAndView updateProd(@RequestParam("id") int pid)
{
	ModelAndView mv= new ModelAndView();
	Product p = productDaoImpl.findById(pid);
	mv.addObject("prod", p);
	mv.addObject("cList", categoryDaoImpl.retrieve());
	mv.addObject("slist", supplierDaoImpl.retrieve());
	mv.setViewName("updateProduct");
	return mv;
	
	
}
 
@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
public ModelAndView updateProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
	System.out.println("called");
	ModelAndView mav = new ModelAndView();

	String pid = request.getParameter("pid");//  primitive way but easy to customise
	String pname = request.getParameter("pName");
	// System.out.println(n);
	String ct = request.getParameter("pCategory");
	String sp = request.getParameter("pSupplier");

	String p = request.getParameter("pPrice");
	String d = request.getParameter("pDescription");

	String q = request.getParameter("pStock");
   // Category cat = new Category();
   // cat.setProducts(productDaoImpl.findById(Integer.parseInt(pid)));
	Product prod2 = new Product();
	prod2.setId(Integer.parseInt(pid));
	prod2.setName(pname);
	prod2.setCategory(categoryDaoImpl.findById(Integer.parseInt(ct)));
	prod2.setSupplier(supplierDaoImpl.findById(Integer.parseInt(sp)));
	
	prod2.setPrice(Float.parseFloat(p));
	prod2.setDescription(d);
	prod2.setStock(Integer.parseInt(q));

	String filepath = request.getSession().getServletContext().getRealPath("/");

	String filname = file.getOriginalFilename();
	prod2.setImgname(filname);
	productDaoImpl.update(prod2);
	System.out.println("File path File" + filepath + " " + filname);

	try {
		// byte imagebyte[] = product.getPimage().getBytes();
		byte imagebyte[] = file.getBytes();
		BufferedOutputStream fos = new BufferedOutputStream(
				new FileOutputStream(filepath + "/resources/image/" + filname));
		fos.write(imagebyte);
		fos.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}

	mav.setViewName("redirect:/admin/productList?update");
	return mav;

}


}













	