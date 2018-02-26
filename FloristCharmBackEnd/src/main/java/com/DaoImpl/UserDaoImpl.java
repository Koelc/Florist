package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.UserDao;
import com.model.Cart;
import com.model.Product;
import com.model.User;

public class UserDaoImpl implements UserDao
{
    @Autowired// this annotation will mark the object as singleton
    SessionFactory sessionFactory;
    
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory)
    {
    	super();
    	this.sessionFactory= sessionFactory;
    }
	
    
	public void insertUser(User user)// this method will be called
	//from controller of the front end
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);// DB transaction
		session.getTransaction().commit();
				
	}
	
	
	public List<User> retrieve()
	 {
		 Session session= sessionFactory.openSession();
			session.beginTransaction();
	List<User> list = session.createQuery("from User").list();
			 session.getTransaction().commit();
			 return list;
		  }
	
	public User findUserById(String email)
	{
		Session session= sessionFactory.openSession();
		User cr = null;
		try
		{
			session.beginTransaction();
			cr=session.get(User.class, email);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
		}
		return cr;
	}

}
