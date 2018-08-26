package br.com.testerichfaces.ejb;

import javax.ejb.Local;

import br.com.testerichfaces.model.Usuario;

@Local
public interface RepositorioUsuario {
	
	Usuario obterUsuarioByLoginESenha(String nomLogin, String senha);

}
