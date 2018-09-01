package br.com.testerichfaces.manager;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.testerichfaces.ejb.LoginController;
import br.com.testerichfaces.model.Usuario;
import br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario;

public class LoginManagerBean {

	private String nomLogin = "";
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

	private void login() {
		this.logado = loginController.isCadastrado(nomLogin, senha);
	}

	public String getNomLogin() {
		return nomLogin;
	}

	public void setNomLogin(String nomLogin) {
		this.nomLogin = nomLogin;
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
	
	public String redirectToLogin() {
		login();
		if(this.logado == true) {
			return "index2";
		}else {
			return "home";
		}
		
	}

}
