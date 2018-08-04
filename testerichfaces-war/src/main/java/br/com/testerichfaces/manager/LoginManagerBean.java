package br.com.testerichfaces.manager;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.testerichfaces.ejb.LoginController;

public class LoginManagerBean {

	private String email = "";
	private String senha;
	private Boolean logado = false;

	LoginController loginController;
	public LoginManagerBean() {

		try {
			 loginController =  (LoginController)new InitialContext().lookup("java:global/testerichfaces-ear/testerichfaces-ejb-0.0.1-SNAPSHOT/LoginControllerBean!br.com.testerichfaces.ejb.LoginController");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public void login() {
		this.logado = loginController.isCadastrado(email, senha);
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

	public Boolean isLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}

}
