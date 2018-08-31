package br.com.testerichfaces.dao;

import java.util.Iterator;
import java.util.List;

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


}
