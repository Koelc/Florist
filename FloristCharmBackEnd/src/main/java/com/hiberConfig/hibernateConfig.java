package com.hiberConfig;




import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hibernateConfig 
{
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2Data()
	{
		System.out.println("hibernate bean initiated");
		DriverManagerDataSource dsource= new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/fch");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 Connected");
		return dsource;
	}

	private Properties gethiberProp()
	{
		Properties p = new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		
		System.out.println("Data table created in H2");
		return p;
		
	}
	
	@SuppressWarnings("deprecation")
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFac(DataSource datasource)
	{	LocalSessionFactoryBuilder sb= new LocalSessionFactoryBuilder(datasource);
	  sb.addProperties(gethiberProp());
	  sb.addAnnotatedClass(User.class);
	  sb.addAnnotatedClass(Supplier.class);
	  sb.addAnnotatedClass(Category.class);
	  sb.addAnnotatedClass(Product.class);
	  sb.addAnnotatedClass(Orders.class);
	  sb.addAnnotatedClass(Cart.class);
	  return sb.buildSessionFactory();
	 	
	}
	
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
	}
	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl getCatData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
	}
	@Autowired
	@Bean(name="ProductDaoImpl")
	public ProductDaoImpl getProductData(SessionFactory sf)
	{
		return new ProductDaoImpl(sf);
	}
	
	
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl getUseData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="OrderDaoImpl")
	public OrdersDaoImpl getOrderData(SessionFactory sf)
	{
		return new OrdersDaoImpl(sf);
		
	}
	@Autowired
	@Bean(name="CartDaoImpl")
	public CartDaoImpl getCartData(SessionFactory sf)
	{
		return new CartDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sf)
	{
		HibernateTransactionManager tm = new HibernateTransactionManager(sf);
		return tm;
	}
	
	
	
}








