package tetris.model.faq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "faq")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FAQ_ID")
	private int id;
	
	@Column(name="FAQ_QUESTION")
	@NotEmpty(message="Merci de saisir une question")
	private String questions;
	
	@Column(name="FAQ_REPONSE")
	@NotEmpty(message="Merci de saisir une r�ponse")
	private String reponse;
	
	public Faq() {
	}
	
	public Faq(String questions, String reponse) {
		super();
		this.questions = questions;
		this.reponse = reponse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Faq [id=" + id + ", questions=" + questions + ", reponse=" + reponse + "]";
	}
	
}