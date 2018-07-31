package br.com.testerichfaces.manager;

public class LoginManagerBean {

	private String email="";
//	private String senha;
//	private boolean Logado;

//	@EJB
//	private LoginController loginController;
	
	public LoginManagerBean() {
		 
	}
//
//	public void login(String email, String senha) {
//		this.Logado = loginController.isCadastrado(email, senha);
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	public boolean isLogado() {
//		return Logado;
//	}
//
//	public void setLogado(boolean logado) {
//		Logado = logado;
//	}

//	public String Redirect() {
//		login(this.getEmail(),this.getSenha());
//		
//		if(this.Logado==true) {
//			return"dashboard.xhtml";
//		}else {
//			return "error";
//		}
//	}
}
