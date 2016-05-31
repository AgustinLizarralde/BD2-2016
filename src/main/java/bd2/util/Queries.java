package bd2.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import bd2.model.Sitio;

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
	}
	
}
