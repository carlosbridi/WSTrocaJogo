package com.genericdata;

import javax.persistence.EntityManager;

public abstract class AbstractService<T extends EntityId<?>>  {

	
	public T save(T entity) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		em.getTransaction().begin();
		T entitySaved = null;
		if(entity.getId() != null) {
			entitySaved = em.merge(entity);
		} else {
			em.persist(entity);
			entitySaved = entity;
		}
		em.getTransaction().commit();
		em.close();
		return entitySaved;
	}
	
	public T saveWithoutTransactionBeginCommit(T entity) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		T entitySaved = null;
		if(entity.getId() != null) {
			entitySaved = em.merge(entity);
		} else {
			em.persist(entity);
			entitySaved = entity;
		}
		em.close();
		return entitySaved;
	}
	
	public void remove(T entity) {
		EntityManager em = EntityConnectionUtils.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		em.close();
	}
	
}
