package fr.formation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.piece.Tetrimino;

@RestController
@RequestMapping("/admin/tetriminos")
public class TetriminoRestController {

	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("")
	public List<Tetrimino> ListeTetri() {
		return this.daoTetri.findAll();
	}
	
}
