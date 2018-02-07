package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.auth.Admin;
import tetris.model.piece.Tetrimino;

@Controller
@RequestMapping("/admin/tetriminos/ajoutTetri")
public class ajoutTetriController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("")
	public String connexion(Model model) {
		Tetrimino tetri = null;
		model.addAttribute("tetrimino", tetri);
		return "admin/tetriminos/ajoutTetri";
	}
	
}
