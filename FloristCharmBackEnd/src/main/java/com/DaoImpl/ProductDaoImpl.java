package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.*;
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;
@SuppressWarnings("deprecation")
@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao
{
	
	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	

	
	public void insertProduct(Product product)
	{
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
       
		session.persist(product);// session.SaveOrUpdate(product);
		// this line will insert a single row in the product table
		// with values of all the fields
		
		session.getTransaction().commit();
		
		
	}
	/*@Transactional*/
	public List<Product> retrieve()
	 {
		 Session session= sessionFactory.openSession();
			session.beginTransaction();
	List<Product> list = session.createQuery("from Product").list();
			 session.getTransaction().commit();
			 return list;
		 
	 }

	 public Product findById(int pid)
	 {
		 Session session= sessionFactory.openSession();
		 Product p=null;
		 try{
		session.beginTransaction();
		p=session.get(Product.class, pid);
		 session.getTransaction().commit();
		 }
		 catch(HibernateException ex)
		 {
			 ex.printStackTrace();
			 session.getTransaction().rollback();// it will not fetch the id
		 }
		 
		 return p;
	 }

	 public List<Product> getProdById(int cid)
	 {
		 Session session= sessionFactory.openSession();
		List<Product> products =null; ;
		session.beginTransaction();
		products=session.createQuery("from Product where cid="+cid).list();
			 session.getTransaction().commit();
			 return products;
		 
	 }
	 
	 public void deleteProduct(int pid)//product id parameter will enable 
	 //the program to identify each product row value uniquely
	 {
		 Session session= sessionFactory.openSession();
		 session.beginTransaction();
		 Product product =(Product)session.get(Product.class, pid);
		 session.delete(product);// delete that particular pid row
		 session.getTransaction().commit();
	 }
	 
	 public void update(Product p)
	 {
		 Session session= sessionFactory.openSession();
		 session.beginTransaction();
		 session.update(p);
		 session.getTransaction().commit();
	 }
		
}
	
















