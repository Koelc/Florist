package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@SuppressWarnings("deprecation")
@Repository("supplierDaoImpl")
@Service
public class SupplierDaoImpl implements SupplierDao
{

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	
	/*@Transactional*/
	public void insertSupplier(Supplier supplier)
	{
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
       
		session.persist(supplier);
		
		session.getTransaction().commit();
		//session.close();
	
}
	public List<Supplier> retrieve()// productList
	 {
		 Session session= sessionFactory.openSession();
			session.beginTransaction();
			List<Supplier> list = session.createQuery("from Supplier").list();
			 session.getTransaction().commit();
			 return list;
		 
	 }

	 public Supplier findById(int sid)// dropdown selection
	 {
		 Session session= sessionFactory.openSession();
		 Supplier p=null;
		 try{
		session.beginTransaction();
		p=session.get(Supplier.class, sid);
		 session.getTransaction().commit();
		 }
		 catch(HibernateException ex)
		 {
			 ex.printStackTrace();
			 session.getTransaction().rollback();// it will not fetch the id
		 }
		 
		 return p;
	 }

	
}




























