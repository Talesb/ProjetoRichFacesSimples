package br.com.testerichfaces.dao;

import java.util.Iterator;
import java.util.List;

import javax.crypto.Cipher;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.CriterionEntry;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.hibernate.internal.CriteriaImpl.Subcriteria;

public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;

	public GenericDao(final EntityManager entityManager) throws Exception{
		super();
		if (entityManager == null) {
			throw new Exception("O parametro entityManager não foi informado.");
		}
		this.entityManager = entityManager;
	}

	public GenericDao() {
		super();
	}
	
	public List getByCriteria(final Criteria criteria) throws Exception {
		try {
			if (criteria instanceof CriteriaImpl) {
				final CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
				if (criteriaImpl.getSession().isClosed()) {
					final Criteria criteriaClone = obterCriterioClone(criteriaImpl);

					return criteriaClone.list();
				}
			}
			return criteria.list();
		} catch (final Exception e) {
			throw new Exception(e);
		}

	}
	
	private Criteria obterCriterioClone(final CriteriaImpl criteriaImpl) {
		final Criteria criteriaClone = getSession().createCriteria(criteriaImpl.getEntityOrClassName());
		final Iterator<CriterionEntry> expressionEntry = criteriaImpl.iterateExpressionEntries();
		while (expressionEntry.hasNext()) {
			criteriaClone.add(expressionEntry.next().getCriterion());
		}
		final Iterator<OrderEntry> orderEntry = criteriaImpl.iterateOrderings();
		while (orderEntry.hasNext()) {
			criteriaClone.addOrder(orderEntry.next().getOrder());
		}
		final Iterator<Subcriteria> subCriteria = criteriaImpl.iterateSubcriteria();
		while (subCriteria.hasNext()) {
			final Subcriteria sub = subCriteria.next();
			criteriaClone.createAlias(sub.getPath(), sub.getAlias(), sub.getJoinType(), sub.getWithClause());
		}
		if (criteriaImpl.getProjection() != null) {
			criteriaClone.setProjection(criteriaImpl.getProjection());
		}
		if (criteriaImpl.getResultTransformer() != null) {
			criteriaClone.setResultTransformer(criteriaImpl.getResultTransformer());
		}
		if (criteriaImpl.getMaxResults() != null) {
			criteriaClone.setMaxResults(criteriaImpl.getMaxResults().intValue());
		}
		criteriaClone.setCacheable(false);
		criteriaClone.setCacheMode(CacheMode.IGNORE);
		criteriaClone.setFlushMode(FlushMode.MANUAL);

		return criteriaClone;
	}
	
	private Session getSession() {
		return (Session) this.entityManager.getDelegate();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Criteria getCriteria(final Class entidade) throws RuntimeException{
		try {
			final Criteria criteria = getSession().createCriteria(entidade);
			criteria.setCacheMode(CacheMode.IGNORE);
			criteria.setFlushMode(FlushMode.MANUAL);
			return criteria;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Object getUniqueEntityFromCriteria(Criteria criteria) throws RuntimeException{
		try {
			return criteria.uniqueResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void save(Object entity) throws RuntimeException{
		try {
			validateObeject(entity);
			if(entityManager.contains(entity)) {
				entityManager.merge(entity);
			}else {
				entityManager.persist(entity);
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void validateObeject(Object entity) {
		if(entity == null) {
			throw new RuntimeException("Entidade nula");
		}
	}
	
	public void delete(Object entity) throws RuntimeException{
		try {
			validateObeject(entity);
			entityManager.remove(entity);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
