package org.example;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	public class Hibernatecfg {
	    private static Hibernatecfg instance=new Hibernatecfg();
	    private SessionFactory sessionFactory;

	    public static Hibernatecfg getInstance() {
	        return instance;
	    }
	    private Hibernatecfg(){
	        Configuration configuration=new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        sessionFactory=configuration.buildSessionFactory();


	        // SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    }
	    public static Session getSession(){
	        Session session=getInstance().sessionFactory.openSession();
	        return session;
	    }
	}




