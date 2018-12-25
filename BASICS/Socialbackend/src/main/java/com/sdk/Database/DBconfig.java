package com.sdk.Database;

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

import com.sdk.Dao.BlogCommentDAO;
import com.sdk.Dao.BlogCommentDAOImpl;
import com.sdk.Dao.BlogDAO;
import com.sdk.Dao.BlogDAOImpl;
import com.sdk.Dao.ForumCommentDAO;
import com.sdk.Dao.ForumCommentDAOImpl;
import com.sdk.Dao.ForumDAO;
import com.sdk.Dao.ForumDAOImpl;
import com.sdk.Dao.FriendDAO;
import com.sdk.Dao.FriendDAOImpl;
import com.sdk.Dao.JobDetailDAO;
import com.sdk.Dao.JobDetailDAOImpl;
import com.sdk.Dao.ProfilePictureDAO;
import com.sdk.Dao.ProfilePictureDAOImpl;
import com.sdk.Dao.UserDetailDAO;
import com.sdk.Dao.UserDetailDAOImpl;
import com.sdk.Domain.Blog;
import com.sdk.Domain.BlogComment;
import com.sdk.Domain.Forum;
import com.sdk.Domain.ForumComment;
import com.sdk.Domain.Friend;
import com.sdk.Domain.JobDetail;
import com.sdk.Domain.ProfilePicture;
import com.sdk.Domain.UserDetail;

@Configuration
@ComponentScan(basePackages="com.sdk.*")
@EnableTransactionManagement
public class DBconfig {
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@DESKTOP-TKEDS80:1521:XE");
		dataSource.setUsername("HubSpot");
		dataSource.setPassword("Oracle123");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(BlogComment.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(ForumComment.class);
		factoryBuilder.addAnnotatedClass(Friend.class);
		factoryBuilder.addAnnotatedClass(JobDetail.class);
		factoryBuilder.addAnnotatedClass(ProfilePicture.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("---Creating SessionFactory Bean---");
		return factoryBuilder.buildSessionFactory();
	}
	

	@Bean(name="blogDAO")
	public BlogDAO getblogDAO()
	{
		System.out.println("---blog dao bean created---");
		return new BlogDAOImpl();
	}
	
	@Bean(name="blogCommentDAO")
	public BlogCommentDAO getblogCommentDAO()
	{
		System.out.println("---blogComment dao bean created---");
		return new BlogCommentDAOImpl();
	}
	
	@Bean(name="forumDAO")
	public ForumDAO getforumDAO()
	{
		System.out.println("---forum dao bean created---");
		return new ForumDAOImpl();
	}
	
	@Bean(name="forumCommentDAO")
	public ForumCommentDAO getforumCommentDAO()
	{
		System.out.println("---forumComment dao bean created---");
		return new ForumCommentDAOImpl();
	}
	
	@Bean(name="friendDAO")
	public FriendDAO getfriendDAO()
	{
		System.out.println("---friend dao bean created---");
		return new FriendDAOImpl();
	}
	
	@Bean(name="jobDetailDAO")
	public JobDetailDAO getjobDetailDAO()
	{
		System.out.println("---jobDetail dao bean created---");
		return new JobDetailDAOImpl();
	}
	
	@Bean(name="profilePictureDAO")
	public ProfilePictureDAO getprofilePictureDAO()
	{
		System.out.println("---profilePicture dao bean created---");
		return new ProfilePictureDAOImpl();
	}
	
	@Bean(name="userDetailDAO")
	public UserDetailDAO getuserDetailDAO()
	{
		System.out.println("---userDetail dao bean created---");
		return new UserDetailDAOImpl();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}



