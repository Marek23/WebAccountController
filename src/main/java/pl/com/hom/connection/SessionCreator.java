package pl.com.hom.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionCreator {
	private static SessionFactory sessionFactory = null;
	private static Session session				 = null;

	static {
		try{
			loadSessionFactory();
		}catch(Exception e){
			System.err.println("Exception while initializing hibernate util.. ");
			e.printStackTrace();
		}
	}

	public static void loadSessionFactory(){

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		//configuration.addAnnotatedClass(Employee.class);
		ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(srvcReg);
	}

	public static void init() throws HibernateException {
		if (session == null)
		{
			try {
				session = sessionFactory.openSession();
			}catch(Throwable t){
				System.err.println("Exception while getting session.. ");
				t.printStackTrace();
			}
		}

		if(session == null) {
			System.err.println("session is discovered null");
		}
		else {
			session.beginTransaction();
			session.getTransaction().commit();
		}
	}

	public static void saveToDB(Object o) {
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}
}