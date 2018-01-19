package fr.formation.model;

import java.util.Date;
import java.util.List;

public class Partie {
	
	private int id=-1;
	private Date date;
	private User user;
	private List<Coup> listCoups;
	private int score;
	
	public Partie() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Partie(Date date, User user, List<Coup> listCoups, int score) {
		this.date = date;
		this.user = user;
		this.listCoups = listCoups;
		this.score = score;
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
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		String rep = "";
		if (id!=-1)
			rep = "id : " + id + ", ";
		rep += "date : " + date + ", ";
		
		if (this.user!=null)
			rep +="user : "+ this.user + ", ";
		
		if (this.listCoups!=null)
			rep += "liste de coups : " + this.listCoups + ", ";
		
		rep += "score : " + this.score;
		return rep;
	}
	
	
}