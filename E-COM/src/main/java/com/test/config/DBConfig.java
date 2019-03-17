package com.test.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.test.Dao.CartDao;
import com.test.Dao.CartDaoImpl;
import com.test.Dao.CategoryDao;
import com.test.Dao.CategoryDaoImpl;
import com.test.Dao.OrderDao;
import com.test.Dao.OrderDaoImpl;
import com.test.Dao.ProductDao;
import com.test.Dao.ProductDaoImpl;
import com.test.Dao.UserDao;
import com.test.Dao.UserDaoImpl;
import com.test.model.CartItem;
import com.test.model.Category;
import com.test.model.OrderDetails;
import com.test.model.Product;
import com.test.model.UserDetail;

@Configuration
@ComponentScan("com.test")
@EnableTransactionManagement
public class DBConfig {
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource() 
	{
		String url="jdbc:h2:tcp://localhost/~/test";
		String uname = "sa";
		String pass = "";
DriverManagerDataSource dataSource=new DriverManagerDataSource();
dataSource.setDriverClassName("org.h2.Driver");
dataSource.setUrl(url);
dataSource.setUsername(uname);
dataSource.setPassword(pass);

System.out.println("---Data Source Created---");
return dataSource;
}
	
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateProp=new Properties();
	
	hibernateProp.setProperty("hiberate.hbm2ddl.auto", "update");
	hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	
	LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
	
	factoryBuilder.addAnnotatedClass(Category.class);
	factoryBuilder.addAnnotatedClass(Product.class);
	factoryBuilder.addAnnotatedClass(UserDetail.class);
	factoryBuilder.addAnnotatedClass(CartItem.class);
	factoryBuilder.addAnnotatedClass(OrderDetails.class);
	
	factoryBuilder.addProperties(hibernateProp);
	
	System.out.println("Creating SessionFactory Bean");
	return factoryBuilder.buildSessionFactory();
	
}

@Bean(name="categoryDAO")
public CategoryDao getCategoryDAO()
{
	System.out.println("----Category DAO Implementation---");
	return new CategoryDaoImpl();
}

@Bean(name="userDAO")
public UserDao getUserDao()
{
	System.out.println("---user DAO Implementation ---");
	return new UserDaoImpl();
	
}

@Bean(name="productDAO")
public ProductDao getProductDAO()
{
	System.out.println("---Product DAO Implementation ---");
	return new ProductDaoImpl();
}

@Bean(name="cartDAO")
public CartDao getCartDAO()
{
	System.out.println("-- Cart DAO Implementation ----");
	return new CartDaoImpl();
}

@Bean(name="orderDAO")
public OrderDao getOrderDAO()
{
	System.out.println("-- Order DAO Implementation ----");
	return new OrderDaoImpl();
}

@Bean(name="txManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("---Transaction Manager----");
	return new HibernateTransactionManager(sessionFactory);
}


}

