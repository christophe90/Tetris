package fr.formation.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.*;
import tetris.model.auth.*;

public class Main {

	public static void main(String[] args) {

		progAuth();

	}

	public static void progAuth() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IAuthDAO dao = myContext.getBean(IAuthDAO.class);
		
//		Admin adm = new Admin("admin1","1234");
//		dao.save(adm);
		
//		User user = new User("toto","toto");
//		dao.save(user);
		
		System.out.println(dao.findAll());
		
		myContext.close();
		
	}
	
}
