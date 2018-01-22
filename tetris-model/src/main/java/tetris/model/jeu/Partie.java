package tetris.model.jeu;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import tetris.model.auth.User;
import tetris.model.jeu.Coup;

@Entity
@Table(name="partie")
public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAR_ID")
	private int id;
	
	@Column(name="PAR_DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="PAR_USER_ID")
	private User user;
	
	@OneToMany(mappedBy="partie") // nom de l'attribut et non pas de la table
	private List<Coup> listCoups;
	
	@Column(name="PAR_SCORE")
	private int score;
	
	public Partie() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Partie(Date date, User user, List<Coup> listCoups) {
		this.date = date;
		this.user = user;
		this.listCoups = listCoups;
		calculScore();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Coup> getListCoups() {
		return listCoups;
	}

	public void setListCoups(List<Coup> listCoups) {
		this.listCoups = listCoups;
		calculScore();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		calculScore();
	}

	public String toString() {
		String rep = "";
		rep = "id : " + id + ", ";
		rep += "date : " + date + ", ";
		if (this.user!=null)
			rep += "user : "+ this.user + ", ";
		rep += "score : " + this.score;
		return rep;
	}
	
	public void calculScore() {
		this.score = 0;
		for (Coup c : listCoups)
			this.score += c.getPoints();
	}
	
}

