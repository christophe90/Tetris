package fr.formation.main;

import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.*;
import tetris.model.auth.*;
import tetris.model.faq.Faq;
import tetris.model.jeu.Coup;
import tetris.model.jeu.Partie;
import tetris.model.piece.RotationTetrimino;
import tetris.model.piece.Tetrimino;

public class Main {

	public static void main(String[] args) {

		progPartie();
		
	}
	
	public static void progPartie() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IPartieDAO dao = myContext.getBean(IPartieDAO.class);
		
//		Partie p = new Partie();
//		dao.save(p);
		
		System.out.println(dao.findAll());
		
		myContext.close();
	}
	
	public static void progFaq() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IFaqDAO dao = myContext.getBean(IFaqDAO.class);
		
//		Faq f = new Faq("Quoi ?", "Rien");
//		dao.save(f);
		
		System.out.println(dao.findAll());
		
		myContext.close();
		
	}
	
	public static void progTetri() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ITetriminoDAO dao = myContext.getBean(ITetriminoDAO.class);
//		
//		RotationTetrimino rt = new RotationTetrimino("Piece 1", "rouge", "1,1,1/1,0,1/1,0,1");
//		dao.save(rt);
		
		System.out.println(dao.findAll());
		
		myContext.close();
		
	}

	public static void progAuth() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IAuthDAO dao = myContext.getBean(IAuthDAO.class);
		
//		Admin adm = new Admin("admin1","1234");
//		dao.save(adm);
//		
//		User user = new User("toto","toto");
//		dao.save(user);
		
		System.out.println(dao.findAll());
		
		myContext.close();
		
	}
	
}
