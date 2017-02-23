package com.genericdata;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

public abstract class AbstractRepository<T,E extends EntityPath<T>>  {

	Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager em;

	protected abstract E getEntityPath();

	@PostConstruct
	@SuppressWarnings("unchecked")
	private void init() {
		this.entityClass = GenericsUtil.getMappedSuperclass(getClass());
	}

	public boolean exists(Predicate... predicates) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(getEntityPath());
		if (!Objects.isNull(predicates) && predicates.length > 0) {
			query.where(predicates);
		}
		return query.fetchCount() > 0;
	}

	public T findOneThrowsException(Predicate... predicates) {
		T entity = findOne(predicates);
		if (entity == null) {
			throw new ServiceException("Registro de " + entityClass.getSimpleName() + " não encontrado.");
		}
		return entity;
	}

	public T findOne(Predicate... predicates) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(getEntityPath())
			.where(predicates);
		return query.fetchOne();
	}
	
	public T findOneThrowsException(OrderSpecifier<?> order, Predicate... predicates) throws ServiceException {
		T entity = findOne(order, predicates);
		if (entity == null) {
			throw new ServiceException("Registro de " + entityClass.getSimpleName() + " não encontrado.");
		}
		return entity;
	}
	
	public T findOne(OrderSpecifier<?> order, Predicate... predicates) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(getEntityPath())
			.where(predicates)
			.orderBy(order);
		return query.fetchOne();
	}
	
	public List<T> find(Predicate... predicates) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(getEntityPath());
		query.where(predicates);
		return query.fetch();
	}
	
}
