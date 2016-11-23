package com.data.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtils {

	public static EntityManager getEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");
		return emf.createEntityManager();
	}
}
