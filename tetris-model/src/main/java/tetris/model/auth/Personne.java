package tetris.model.auth;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="authentification")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Personne implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int id;
	
	@Column(name="PER_LOGIN")
	@NotNull
	@NotEmpty(message="Le login est obligatoire")
	protected String login;
	
	@Column(name="PER_PASSWORD")
	@NotNull
	@NotEmpty(message="Le mot de passe est obligatoire")
	@Size(min=4, message="Le nombre de caractère du mot de passe doit être supérieur à 4")
	protected String password;

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
