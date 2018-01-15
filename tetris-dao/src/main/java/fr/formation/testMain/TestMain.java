package fr.formation.testMain;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.IDAO;
import fr.formation.dao.TetriminoDAO;
import fr.formation.tetrimino.Tetrimino;

public class TestMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		testFindByIDGeneric();
	}


	static void testFindByID() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			System.out.println("test-findByID");
			TetriminoDAO myTetriminoDAO = myContext.getBean(TetriminoDAO.class);
			Tetrimino t = myTetriminoDAO.findByID(4);

			System.out.println(t);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		myContext.close();
	}
	
	static void testFindAll() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			System.out.println("test-findAll");
			TetriminoDAO myTetriminoDAO = myContext.getBean(TetriminoDAO.class);
			List<Tetrimino> ListTetri= myTetriminoDAO.findAll();

			System.out.println(ListTetri);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		myContext.close();
	}
	
	static void testInsert() {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			System.out.println("test-Insert");
			Tetrimino t = new Tetrimino("test5","cyan");
			TetriminoDAO myTetriminoDAO = myContext.getBean(TetriminoDAO.class);
			myTetriminoDAO.insert(t);		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		myContext.close();
	}
	
	static void testFindByIDGeneric() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			System.out.println("test-findByIDGeneric");
			IDAO dao = myContext.getBean(IDAO.class);
			Tetrimino t = (Tetrimino) dao.findByID(4);

			System.out.println(t);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		myContext.close();
	}
}
