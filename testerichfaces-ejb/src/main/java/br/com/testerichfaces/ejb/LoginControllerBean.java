package br.com.testerichfaces.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.testerichfaces.dao.ClienteDao;
import br.com.testerichfaces.model.Usuario;
import br.com.testesrichfaces.repositorio.usuario.RepositorioUsuario;

@Stateless
public class LoginControllerBean implements LoginController {

	ClienteDao cDao;
	
	@EJB
	private RepositorioUsuario repositorioUsuario;

	
	@PostConstruct
	public void init() {

	}
	
	public boolean isCadastrado(String nomLogin, String senha) {
		Usuario usuario = repositorioUsuario.findUsuarioByNomeLoginAndSenha(senha, nomLogin);
		if (usuario != null) {
			return true;
		}
		return false;
	}

}
