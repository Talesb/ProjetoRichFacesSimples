package br.com.testerichfaces.manager;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.testerichfaces.manager.ejb.LoginManagedBeanEjb;

public class LoginManagerBean {

	private String nomLogin = "";
	private String senha;
	private Boolean logado = false;
  
	
	@EJB
	private LoginManagedBeanEjb loginManagedBeanEjb;

	public LoginManagerBean() {

		try {
			loginManagedBeanEjb = (LoginManagedBeanEjb) new InitialContext().lookup(
					"java:global/testerichfaces-ear/testerichfaces-war-0.0.1-SNAPSHOT/LoginManagedBeanEjbImpl!br.com.testerichfaces.manager.ejb.LoginManagedBeanEjb");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	private void login() {
		logado = loginManagedBeanEjb.isCadastrado(nomLogin,senha);
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
		if (this.logado == true) {
			return "index2";
		} else {
			return "home";
		}

	}

}
