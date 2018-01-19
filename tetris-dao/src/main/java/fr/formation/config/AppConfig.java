package fr.formation.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:data-source.properties")
@ComponentScan("fr.formation.dao")
public class AppConfig {
	
	@Autowired
	private Environment env;

	@Bean("dataSource")
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("mysql.className"));
		dataSource.setUrl(env.getProperty("mysql.url"));
		dataSource.setUsername(env.getProperty("mysql.username"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		dataSource.setMaxTotal(env.getProperty("mysql.maxTotal", Integer.class));
		
		return dataSource;
	}
	
	@Bean
	public Connection getConn() {
		try {
			return this.dataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
