package br.com.testerichfaces.repositorio;

import java.util.List;

import javax.ejb.Local;

import br.com.testerichfaces.model.Usuario;

@Local
public interface RepositorioUsuario {
	 List<Usuario> findAllUsuarios();
}
