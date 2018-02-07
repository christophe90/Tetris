package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{message}")
	public String connexion2(Model model, @PathVariable boolean message) {
		model.addAttribute("admin", new Admin());
		model.addAttribute("message", message);
		return "admin/connexion";
	}
	
	@PostMapping(value={"", "/{message}"})
	public String ajoutProduit(@Valid@ModelAttribute("admin") Admin admin, BindingResult result, Model model, @RequestParam("login") String login) {
		if (result.hasErrors()) {
			return "admin/connexion";
		}
		boolean message = false;
		Admin admin2 = daoAuth.findAdmin(admin.getLogin(), admin.getPassword());
		if ( admin2 == null ) {
			message = true;
			model.addAttribute("message", message);
			return "redirect:./connexion/{message}";
		}
		model.addAttribute("login", login);
		return "redirect:/admin/home/{login}";
	}
	
}
