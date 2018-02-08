package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.piece.Tetrimino;

@Controller
@RequestMapping
public class TetriminoController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("/admin/tetriminos")
	public String tetrimino(Model model) {
		List<Tetrimino> tetris = daoTetri.findAll();
		model.addAttribute("tetriminos", tetris);
		return "admin/tetriminos";
	}
	
	@GetMapping("/admin/activerTetri")
	public String activation(@RequestParam("id") int id, Model model) {
		Tetrimino tetri = daoTetri.findById(id).get();
		tetri.setActif(true);
		daoTetri.save(tetri);
		return "redirect:/admin/tetriminos";
	}
	
	@GetMapping("/admin/desactiverTetri")
	public String desactivation(@RequestParam("id") int id, Model model) {
		Tetrimino tetri = daoTetri.findById(id).get();
		tetri.setActif(false);
		daoTetri.save(tetri);
		return "redirect:/admin/tetriminos";
	}
	
}
