package br.com.fauker.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
