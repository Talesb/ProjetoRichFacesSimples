package br.com.testerichfaces.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;

import br.com.testerichfaces.dao.GenericDao;

public abstract class RepositorioGenericoBean<T> implements RepositorioGenerico<T> {

	private GenericDao genericDao;
	
	@PersistenceContext(unitName="richfacesteste-pu")
	protected EntityManager entityManager;
	
	public List obterPorCriteria(Criteria criteria) throws RuntimeException{
		try {
			return getDao().getByCriteria(criteria);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(T entidade) throws RuntimeException{
		try {
			getDao().delete(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(T entidade) throws RuntimeException{
		try {
			getDao().save(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T obterUnicaEntidadePorCriteria(Criteria criteria) throws RuntimeException{
		try {
			return (T)getDao().getUniqueEntityFromCriteria(criteria);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Criteria obterCriteria(final Class entidade) throws RuntimeException{
		try {
			return getDao().getCriteria(entidade);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected GenericDao getGenericDao() {
		if(this.genericDao == null) {
			this.genericDao = new GenericDao();
			return this.genericDao;
		}
		return this.genericDao;
	}

	protected void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	protected GenericDao getDao() {
		getGenericDao().setEntityManager(entityManager);
		return genericDao;
	}
	
	
}
