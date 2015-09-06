package br.com.fauker.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
//	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu-eclipselink");
	
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu-hibernate");

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
