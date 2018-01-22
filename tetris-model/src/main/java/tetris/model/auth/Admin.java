package tetris.model.auth;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PER_ID")
@DiscriminatorValue("Admin")
public class Admin extends Personne{
	
	public Admin() {
	}
	
	public Admin(String login, String password) {
		super(login, password);
	}

	@Override
	public String toString() {
		return "Admin : " + super.toString();
	}
	
}
