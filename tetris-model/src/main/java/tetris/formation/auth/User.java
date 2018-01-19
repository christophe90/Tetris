package tetris.formation.auth;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import tetris.model.jeu.Partie;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="USE_ID", referencedColumnName="PER_ID")
@DiscriminatorValue("User")
public class User extends Personne{
	
	@OneToMany(mappedBy="partie")
	private List<Partie> listParties;

	public User() {
	}
	
	public User(String login, String password) {
		super(login, password);
	}
	
	public List<Partie> getListParties() {
		return listParties;
	}

	public void setListParties(List<Partie> listParties) {
		this.listParties = listParties;
	}

	@Override
	public String toString() {
		return "User : " + super.toString();
	}
	
}
