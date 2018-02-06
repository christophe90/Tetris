package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class loginController {
	
	@GetMapping("connexion")
	public String connexion() {
		return "connexion";
	}
	
}
