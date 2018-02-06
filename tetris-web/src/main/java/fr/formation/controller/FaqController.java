package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.dao.IFaqDAO;

@Controller
@RequestMapping("/admin/faq")
public class FaqController {
	
	@Autowired
	IFaqDAO daoFaq;
	
	@GetMapping(value={ "" })
	public String afficherFaq(Model model) {
		model.addAttribute("faq",daoFaq.findAll());
		return "admin/faq";
	}
}
