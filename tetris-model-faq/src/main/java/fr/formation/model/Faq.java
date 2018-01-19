package fr.formation.model;

import java.util.List;

public class Faq {
	public List<String> questions;
	public List<String> reponse;
	
	public Faq() {
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
