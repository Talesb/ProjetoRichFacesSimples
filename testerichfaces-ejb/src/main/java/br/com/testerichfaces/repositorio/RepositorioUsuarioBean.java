package br.com.testerichfaces.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.testerichfaces.model.Usuario;

@Stateless
public class RepositorioUsuarioBean implements RepositorioUsuario {

	@PersistenceContext(name="richfacesteste-pu")
	private EntityManager entityManager;

	
	public List<Usuario> findAllUsuarios() {

		 Session session = (Session) entityManager.getDelegate();
//		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);
		return criteria.list();

	}
}
