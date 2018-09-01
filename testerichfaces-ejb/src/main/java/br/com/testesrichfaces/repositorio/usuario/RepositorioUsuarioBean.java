package br.com.testesrichfaces.repositorio.usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.testerichfaces.model.Usuario;
import br.com.testerichfaces.repositorio.RepositorioGenericoBean;

@Stateless
public class RepositorioUsuarioBean<T extends Usuario> extends RepositorioGenericoBean<T> implements RepositorioUsuario<T> {

	public List<Usuario> findAllUsuarios() {
		Criteria criteria = obterCriteria(Usuario.class);
		return obterPorCriteria(criteria);
	}
	
	public Usuario findUsuarioByNomeLoginAndSenha(final String senha, final String nomLoginUsuario) {
		Criteria criteria = obterCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nomLoginUsuario", nomLoginUsuario.trim()).ignoreCase());
		criteria.add(Restrictions.eq("senha", senha));
		return obterUnicaEntidadePorCriteria(criteria);
	}
}
