package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.faq.Faq;
import tetris.model.piece.RotationTetrimino;

@Controller
@RequestMapping("/admin")
public class ajoutTetriController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("/ajoutTetri")
	public String ajouterTetrimino(Model model) {
		int myHauteur = 0;
		int myLargeur = 0;
		model.addAttribute("tetrimino", new RotationTetrimino());
		
		model.addAttribute("hauteur", myHauteur);
		model.addAttribute("largeur", myLargeur);
		
		return "admin/ajoutTetri";
	}
	
	@PostMapping("/ajoutTetri/taille")
	public String ajouterTetrimino(@ModelAttribute("hauteur") String myHauteurStr, @ModelAttribute("largeur") String myLargeurStr, Model model) {		
		
		model.addAttribute("hauteur", myHauteurStr);
		model.addAttribute("largeur", myLargeurStr);
		
		return "admin/ajoutTetri";
	}
	
	@PostMapping("/ajoutTetri/soumettre")
	public String ajouter(@ModelAttribute("tetrimino") RotationTetrimino myTetrimino, @ModelAttribute("hauteur") String myHauteurStr, @ModelAttribute("largeur") String myLargeurStr, Model model, HttpServletRequest myServletRequest) {
		model.addAttribute("tetrimino", myTetrimino);
		
		int myHauteur=Integer.parseInt(myHauteurStr);
		int myLargeur=Integer.parseInt(myLargeurStr);
		
		//System.out.println("hauteur = " + myHauteur + ", largeur = " + myLargeur); //------------ A supprimer
		
		String[][] tab = new String[myHauteur][myLargeur];

		
		for (int i=0; i<myHauteur; i++) {
			for (int j=0; j<myLargeur; j++) {
				String str = "checkbox-" + i + "-" + j;
				String myCheckbox = myServletRequest.getParameter(str);
				
				if (myCheckbox==null) {
					tab[i][j] = "0";
					System.out.print(i + " " + j + " = " + tab[i][j] + "// "); //------------ A supprimer
					}
				else {
					tab[i][j] = "1";
					System.out.print(i + " " + j +" = " + tab[i][j] + "// "); //------------ A supprimer
				}
			}
			System.out.println();
		}
		
		myTetrimino.setActif(true);
		String strMatrice = myTetrimino.arrayToString(tab);
		myTetrimino.setStr(strMatrice);
		daoTetri.save(myTetrimino);
		
		return "redirect:/admin/tetriminos";
	}
	
	@GetMapping("/modifierTetri")
	public String modifier(@RequestParam("id") String myId, Model model) {
		RotationTetrimino myTetri = (RotationTetrimino) daoTetri.findById(Integer.parseInt(myId)).get();
		model.addAttribute("tetrimino",myTetri);
		return "admin/modifier";
	}
	
}
