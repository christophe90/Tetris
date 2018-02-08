package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.piece.RotationTetrimino;
import tetris.model.piece.Tetrimino;

@Controller
@RequestMapping("/admin")
public class ajoutTetriController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	/*
	@GetMapping("")
	public String connexion(Model model) {
		model.addAttribute("tetrimino", new RotationTetrimino());
		return "admin/ajoutTetri";
	}
	*/
	
	@GetMapping("/ajoutTetri")
	public String ajouterTetrimino(Model model) {
		int myHauteur = 0;
		int myLargeur = 0;
		model.addAttribute("tetrimino", new RotationTetrimino());
		
//		model.addAttribute("hauteur", myHauteur); //--------------------- A modifier
//		model.addAttribute("largeur", myLargeur); //--------------------- A modifier
		
		return "admin/ajoutTetri";
	}
	
	@PostMapping("/ajoutTetri")
	public String ajouter(@ModelAttribute("tetrimino") RotationTetrimino myTetrimino, Model model, HttpServletRequest myServletRequest) {
		model.addAttribute("tetrimino", myTetrimino);
		
		int myLargeur = 3; //--------------------- A modifier (à récuperer en "ModelAttribute")
		int myHauteur = 3; //--------------------- A modifier (à récuperer en "ModelAttribute")
		
		String[][] tab = new String[myLargeur][myHauteur];
		
		for (int i=0; i<myHauteur; i++) {
			for (int j=0; j<myHauteur; j++) {
				String str = "checkbox-" + i + "-" + j;
				String myCheckbox = myServletRequest.getParameter(str);
				
				if (myCheckbox==null) {
					System.out.println(i + " " + j + " = " + "0");
					tab[i][j] = "0";
					}
				else {
					System.out.println(i + " " + j +" = " + "1");
					tab[i][j] = "1";
				}
			}
		}
		
		String strMatrice = myTetrimino.arrayToString(tab);
		myTetrimino.setStr(strMatrice);
		daoTetri.save(myTetrimino);
		
		return "redirect:/admin/tetriminos";
	}
	
}
