package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.ITetriminoDAO;

@Controller
@RequestMapping("/admin/supprimerTetri")
public class supprTetriController {

	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("")
	public String suppression(@RequestParam("id") int id, Model model) {
		daoTetri.deleteById(id);
		return "redirect:/admin/tetriminos";
	}
	
}
