package fr.formation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.IPartieDAO;
import tetris.model.jeu.Partie;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/home")
public class ScoreRestController {

	@Autowired
	private IPartieDAO daoPartie;
	
	@GetMapping("") //http://localhost:8080/tetris-web/api/admin/home
	public List<Partie> listParties() {
		return this.daoPartie.findAll();
	}
	
}
