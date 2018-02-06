package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IAuthDAO;
import tetris.model.auth.Admin;

@Controller
@RequestMapping("/admin/connexion")
public class loginController {
	
	@Autowired
	private IAuthDAO daoAuth;
	
	@GetMapping("")
	public String connexion(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/connexion";
	}
	
	@PostMapping("")
	public String ajoutProduit(@ModelAttribute("admin") Admin admin, Model model, @RequestParam("login") String login) {
		Admin admin2 = (Admin) daoAuth.findByLogin(admin.getLogin());
		if (! admin2.getPassword().equals(admin.getPassword())) {
			return "admin/connexion";
		}
		return "redirect:.admin/home/{login}";
	}
	
}
