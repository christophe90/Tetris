package tetris.model.auth;

import javax.persistence.DiscriminatorValue;

import java.util.List;

import javax.persistence.*;

import tetris.model.jeu.*;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="USE_ID", referencedColumnName="PER_ID")
public class User extends Personne{
	
	@OneToMany(mappedBy="user")
	private List<Partie> parties;

	public User() {
	}
	
	public User(String login, String password) {
		this.login=login;
		this.password=password;
	}
	
	@Override
	public String toString() {
		return "User : " + super.toString();
	}
	
}
