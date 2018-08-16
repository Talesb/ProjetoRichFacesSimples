package br.com.testerichfaces.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name="SYS_USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOMLOGINUSUARIO")
	private String nomLoginUsuario;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SENHA")
	private String senha;
	
	
	public Usuario() {}
	
	
	public Usuario(Integer id, String nomLoginUsuario, String email, String senha) {
		this.id = id;
		this.nomLoginUsuario = nomLoginUsuario;
		this.email = email;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomLoginUsuario() {
		return nomLoginUsuario;
	}

	public void setNomLoginUsuario(String nomLoginUsuario) {
		this.nomLoginUsuario = nomLoginUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
