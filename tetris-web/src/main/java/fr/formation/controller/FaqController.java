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

import fr.formation.dao.IFaqDAO;
import tetris.model.faq.Faq;

@Controller
@RequestMapping("/admin/faq")
public class FaqController {
	
	@Autowired
	IFaqDAO daoFaq;
	
	@GetMapping("/liste")
	public String afficherFaq(Model model) {
		model.addAttribute("faq",daoFaq.findAll());
		return "admin/faq";
	}
	
	@GetMapping("/editer")
	public String ajouter(Model model) {
		model.addAttribute("faq", new Faq());
		return "admin/editerFaq";
	}
	
	@PostMapping("/editer")
	public String ajoutPost(@Valid @ModelAttribute("faq") Faq myFaq,  BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "admin/editerFaq";
		}
		
		daoFaq.save(myFaq);
		return "redirect:/admin/faq/liste";
	}
	
	@GetMapping("/editer/{id}")
	public String modifier(@PathVariable(value="id", required=true) String myId, Model model) {
		Faq myFaq = daoFaq.findById(Integer.parseInt(myId)).get();
		model.addAttribute("faq",myFaq);
		return "admin/editerFaq";
	}
	
	@PostMapping("/editer/{id}")
	public String modifierPost(@PathVariable(value="id", required=true) String myId, @Valid @ModelAttribute("faq") Faq myFaq, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "admin/editerFaq";
		}
		
		daoFaq.save(myFaq);
		return "redirect:/admin/faq/liste";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(@PathVariable(value="id", required=true) String myId, Model model) {
		Faq myFaq = daoFaq.findById(Integer.parseInt(myId)).get();
		daoFaq.delete(myFaq);
		return "redirect:/admin/faq/liste";
	}	
}
