package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.piece.Tetrimino;

@Controller
@RequestMapping("/admin/tetriminos")
public class TetriminoController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@RequestMapping(value={"/{login}" }, method=RequestMethod.GET)
	public String tetrimino(@PathVariable String login, Model model) {
	//@GetMapping("")
//	public String tetrimino(Model model) {
		List<Tetrimino> tetris = daoTetri.findAll();
		model.addAttribute("tetriminos", tetris);
		return "admin/tetriminos";
	}
	
}
