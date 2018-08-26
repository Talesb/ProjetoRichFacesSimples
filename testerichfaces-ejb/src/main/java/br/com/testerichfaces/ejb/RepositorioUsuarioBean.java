package br.com.testerichfaces.ejb;

import javax.ejb.Stateless;

import br.com.testerichfaces.model.Usuario;

@Stateless
public class RepositorioUsuarioBean implements RepositorioUsuario{

	public Usuario obterUsuarioByLoginESenha(String nomLogin, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}
