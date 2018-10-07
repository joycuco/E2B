package com.e2bnutrition.e2bbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
	   @Bean
	    public LocalSessionFactoryBean sessionFactory(){
	        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	        sessionFactoryBean.setDataSource(dataSource());
	        sessionFactoryBean.setPackagesToScan("com.e2bnutrition.e2bbackend.model");
	        sessionFactoryBean.setHibernateProperties(hibernateProperties());
	        return sessionFactoryBean;
	    }

	    @Bean
	    public DataSource dataSource(){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/e2b");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }

	    public Properties hibernateProperties(){
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	        properties.put("show_sql","true");
	        return properties;
	    }

	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(){
	        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
	        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
	        return hibernateTransactionManager;
	    }
}
