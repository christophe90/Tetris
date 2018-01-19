package fr.formation.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.auth.Admin;
import fr.formation.config.AppConfig;
import fr.formation.dao.IAuthDAO;

public class Main {

	public static void main(String[] args) {

		prog1();

	}

	public static void prog1() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IAuthDAO dao = myContext.getBean(IAuthDAO.class);
		
		Admin adm = new Admin("admin1","1234");
		dao.save(adm);
		
		System.out.println(dao.findAll());
		
		myContext.close();
		
	}
	
}
