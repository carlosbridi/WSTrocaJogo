package com.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilAcess {

	public static EntityManager getEM(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("WSTrocaJogo");
		return factory.createEntityManager();
	}
	
}
