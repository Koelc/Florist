package com.DaoImpl;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.*;
import com.model.*;

@SuppressWarnings("unused")
@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao
{
 @Autowired
 SessionFactory sessionFactory;
 @Autowired 
public CategoryDaoImpl(SessionFactory sessionFactory)
{
		this.sessionFactory= sessionFactory;
}

//@Transactional 
public void insertCategory(Category category)//101,Food,jdgfkdshf
{
	Session session= sessionFactory.openSession();
	session.beginTransaction();
    session.saveOrUpdate(category);// persist()// in the DB
   session.getTransaction().commit();

}
 public List<Category> retrieve()
 {
	 Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Category> list = session.createQuery("from Category").list();
		 session.getTransaction().commit();
		 return list;
	 
 }

 public Category findById(int cid)
 {
	 Session session= sessionFactory.openSession();
	 Category p=null;
	 try{
	session.beginTransaction();
	p=session.get(Category.class, cid);
	 session.getTransaction().commit();
	 }
	 catch(HibernateException ex)
	 {
		 ex.printStackTrace();
		 session.getTransaction().rollback();// it will not fetch the id
	 }
	 
	 return p;
 }

 
 public void deleteCategory(int cid)
 {
	 Session session= sessionFactory.openSession();
	 session.beginTransaction();
	 Category category =(Category)session.get(Category.class, cid);
	 session.delete(category);
	 session.getTransaction().commit();
 }
 
 public void update(Category c)
 {
	 Session session= sessionFactory.openSession();
	
	 try{
	 session.beginTransaction();
	 session.update(c);
	 }
	 catch(HibernateException ex)
	 {
		 ex.printStackTrace();
	 session.getTransaction().rollback();
	 }
 }



}





























