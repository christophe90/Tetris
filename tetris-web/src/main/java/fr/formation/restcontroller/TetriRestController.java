package fr.formation.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.ITetriminoDAO;
import tetris.model.piece.Tetrimino;

@RestController
@RequestMapping("/admin/tetriminos")
public class TetriRestController {
	
	@Autowired
	private ITetriminoDAO daoTetri;
	
	@GetMapping("") //http://localhost:8080/tetris-web/api/admin/tetriminos
	public List<Tetrimino> listTetris() {
		List<Tetrimino> listTetriAll = this.daoTetri.findAll();
		List<Tetrimino> listTetriActif = new ArrayList<Tetrimino>();
		for (Tetrimino tetri : listTetriAll) {
			if (tetri.isActif() == true) {
				listTetriActif.add(tetri);
			}
		}
		return listTetriActif;
	}
	
	
}
