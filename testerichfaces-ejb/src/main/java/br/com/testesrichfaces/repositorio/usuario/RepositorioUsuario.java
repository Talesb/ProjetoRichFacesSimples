package br.com.testesrichfaces.repositorio.usuario;

import java.util.List;

import javax.ejb.Local;

import br.com.testerichfaces.model.Usuario;
import br.com.testerichfaces.repositorio.RepositorioGenerico;

@Local
public interface RepositorioUsuario<T extends Usuario> extends RepositorioGenerico<T>{
	 List<Usuario> findAllUsuarios();
}
