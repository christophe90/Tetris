package tetris.model.faq;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COU_ID")
	private int id;
	
	@Column(name="FAQ_QUESTION")
	private List<String> questions;
	
	@Column(name="FAQ_REPONSE")
	private List<String> reponse;
	
	public Faq() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public List<String> getReponse() {
		return this.reponse;
	}

	public void setReponse(List<String> reponse) {
		this.reponse = reponse;
	}
}
