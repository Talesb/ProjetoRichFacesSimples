package br.com.testerichfaces.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

import br.com.testerichfaces.dao.ClienteDao;
import br.com.testerichfaces.model.Usuario;
import br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario;

@Stateless
public class LoginControllerBean implements LoginController {

	ClienteDao cDao;
	private RepositorioUsuario repositorioUsuario;

	
	@PostConstruct
	public void init() {
		try {			
			repositorioUsuario =  (RepositorioUsuario)new InitialContext().lookup("java:global/testerichfaces-ear/testerichfaces-ejb-0.0.1-SNAPSHOT/RepositorioUsuarioBean!br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario");
			cDao = new ClienteDao();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean isCadastrado(String nomLogin, String senha) {
		Usuario usuario = repositorioUsuario.findUsuarioByNomeLoginAndSenha(senha, nomLogin);
		if (usuario != null) {
			return true;
		}
		return false;
	}

}
