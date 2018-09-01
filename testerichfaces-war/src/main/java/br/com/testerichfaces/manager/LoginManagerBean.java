package br.com.testerichfaces.manager;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.testerichfaces.ejb.LoginController;
import br.com.testerichfaces.model.Usuario;
import br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario;

public class LoginManagerBean {

	private String email = "";
	private String senha;
	private Boolean logado = false;
	private RepositorioUsuario repositorioUsuario;

	LoginController loginController;
	public LoginManagerBean() {

		try {
			 loginController =  (LoginController)new InitialContext().lookup("java:global/testerichfaces-ear/testerichfaces-ejb-0.0.1-SNAPSHOT/LoginControllerBean!br.com.testerichfaces.ejb.LoginController");
			 repositorioUsuario =  (RepositorioUsuario)new InitialContext().lookup("java:global/testerichfaces-ear/testerichfaces-ejb-0.0.1-SNAPSHOT/RepositorioUsuarioBean!br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	private void login() {
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
	
	public String redirectToLogin() {
		login();
		List<Usuario> usuario = testeRetornoHibernate();
		if(this.logado == true) {
			return "index2";
		}else {
			return "home";
		}
		
	}
	
	private List<Usuario> testeRetornoHibernate(){
		return repositorioUsuario.findAllUsuarios();
	}

}
