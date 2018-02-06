package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value={"/home/{username}" }, method=RequestMethod.GET)
	public String home(@PathVariable String username, Model model) {
		model.addAttribute("username", username);
		return "home/{username}";
	}

}
