package pl.com.hom.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import org.hibernate.Session;

public final class SessionCreator {
	private static EntityManagerFactory emf;
	private static EntityManager        em;
	private static Session              session;

	public static void init() {
		HibernatePersistenceProvider hpp = new HibernatePersistenceProvider();
		emf     = hpp.createEntityManagerFactory("bank", null);
		em      = emf.createEntityManager();
		session = em.unwrap(Session.class);
	}

	public static Session getSession() {
		return session;
	}

	public static void saveToDB(Object o) {
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}

	public static EntityManager getEntityManager() {
		return em;
	}
}