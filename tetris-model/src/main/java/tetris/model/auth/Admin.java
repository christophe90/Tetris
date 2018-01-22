package tetris.model.auth;

import javax.persistence.*;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PER_ID")
public class Admin extends Personne{
	
	public Admin() {
	}
	
	public Admin(String login, String password) {
		this.login=login;
		this.password=password;
	}

	@Override
	public String toString() {
		return "Admin : " + super.toString();
	}
	
}
