package fr.formation.auth;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user")
@PrimaryKeyJoinColumn(name="USE_ID", referencedColumnName="PER_ID")
@DiscriminatorValue("User")
public class User extends Personne{

	public User() {
	}
	
	public User(String login, String password) {
		super(login, password);
	}
	
	@Override
	public String toString() {
		return "User : " + super.toString();
	}
	
}
