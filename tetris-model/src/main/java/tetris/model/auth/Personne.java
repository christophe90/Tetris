package tetris.model.auth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Id;

@Entity
@Table(name="authentification")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PER_TYPE")
public class Personne implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int id;
	
	@Column(name="PER_LOGIN")
	@NotNull
	@NotEmpty
	private String login;
	
	@Column(name="PER_PASSWORD")
	@NotNull
	@NotEmpty
	@Size(min=4)
	private String password;
	
	public Personne() {
	}
	
	public Personne(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "id=" + id + ", login=" + login + ", password=" + password;
	}
	
}
