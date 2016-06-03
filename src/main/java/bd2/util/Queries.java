package bd2.util;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Queries {
	
	private static SessionFactory sessions;
	
	public static void consultaItemA() {
		Query queryResult;
		List list;
		try {
			System.out.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();

			Session session = sessions.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				queryResult = session.createQuery("select nombre from Documento");
				list = queryResult.list();
				tx.commit();
				System.out.println(list);
				while( iterator.hasNext() ){
					System.out.println("Documento: "+ iterator.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		consultaItemA();
		consultaItemB();
		consultaItemC();
	}
	
	public static void consultaItemB() {
		Query queryResult;
		List list;
		try {
			System.out.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();

			Session session = sessions.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				queryResult = session.createQuery(""
						+ "select distinct m.email "
						+ "from Moderador as m "
						+ "join m.evaluaciones as e "
						+ "where e.traduccion.idioma.nombre = :idioma "
						)
						.setString("idioma", "Ingles");
				list = queryResult.list();
				tx.commit();
				Iterator<String> iterator = list.iterator();
				while( iterator.hasNext() ){
					System.out.println("Email: "+ iterator.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
	}
	
	public static void consultaItemC() {
		Query queryResult;
		List list;
		try {
			System.out.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();

			Session session = sessions.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				queryResult = session.createQuery(""
						+ "select distinct u.nombre "
						+ "from Usuario as u "
						+ "join u.cursadasRealizadas as cr "
						+ "join cr.curso as c "
						+ "where c.idioma.nombre = :idioma "
						+ "and c.nivel >= 3 "
						)
						.setString("idioma", "Frances");
				list = queryResult.list();
				tx.commit();
				Iterator<String> iterator = list.iterator();
				while( iterator.hasNext() ){
					System.out.println("Nombre: "+ iterator.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
	}
}
