package br.com.testesrichfaces.repositorio.usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.testerichfaces.model.Usuario;
import br.com.testerichfaces.repositorio.RepositorioGenericoBean;

@Stateless
public class RepositorioUsuarioBean<T extends Usuario> extends RepositorioGenericoBean<T> implements RepositorioUsuario<T> {

	public List<Usuario> findAllUsuarios() {
		Criteria criteria = obterCriteria(Usuario.class);
		return obterPorCriteria(criteria);
	}
}
