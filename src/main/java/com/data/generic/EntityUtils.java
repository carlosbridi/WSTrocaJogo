package com.data.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtils {

	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(){
		
		if (entityManager == null){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");
			entityManager = emf.createEntityManager();
		}
		
		return entityManager;
	}
}
