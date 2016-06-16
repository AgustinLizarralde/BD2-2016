package bd2.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	
	public static void main(String[] args) {
		/*
		consultaItemA();
		consultaItemB();
		consultaItemC();
		Date desde = new GregorianCalendar(2015,Calendar.JULY,1).getTime();
		Date hasta = new GregorianCalendar(2015,Calendar.DECEMBER,31).getTime();
		consultaItemD(desde, hasta);
		consultaItemE();
		consultaItemF();
		consultaItemG("Leuchtturm");
		consultaItemH();
		*/
	}
	
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
				Iterator<String> iterator = list.iterator();
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
	
	public static void consultaItemD(Date desde, Date hasta) {
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
						+ "select distinct m.nombre "
						+ "from Moderador as m "
						+ "join m.evaluaciones as e "
						+ "where e.fecha between :desde and :hasta"
						)
						.setDate("desde", desde )
						.setDate("hasta", hasta );
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
	
	public static void consultaItemE() {
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
						+ "select t.descripcion "
						+ "from Tarea as t "
						+ "join t.idioma as idiomaTraduccion "
						+ "join t.parrafo.documento.idioma as idiomaOriginal "
						+ "where t.completa = true "
						+ "and t.class = 'T' "
						+ "and idiomaTraduccion.nombre = 'frances' "
						+ "and idiomaOriginal.nombre = 'ingles' "
						);
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
	
	public static void consultaItemF() {
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
							
						+ "select distinct u.email "
						+ "from Usuario as u "
						+ "join u.cursadasRealizadas as cr "
						//el curso no esta entre los desaprobados
						+ "where cr not in ( "
							//cursos desaprobados
							+ "select cur "
							+ "from Cursada as cur "
							+ "join cur.curso.lecciones as lec "
							+ "join cur.pruebas as pru "
							//alguna leccion no esta aprobada por el usuario
							+ "where lec not in( "
								//lecciones aprobadas del usuario
								+ "select leccion "
								+ "from Usuario as user "
								+ "join user.cursadasRealizadas as cursadas "
								+ "join cursadas.pruebas as pruebas "
								+ "join pruebas.leccion as leccion "
								+ "where pruebas.puntaje >= 60 "
								+ "and user = u "
								+ "group by leccion "
							+ ") "
						+ ") "
							
						);
				list = queryResult.list();
				tx.commit();
				Iterator<String> iterator = list.iterator();
				while( iterator.hasNext() ){
					System.out.println("Usuario con cursada aprobada: "+ iterator.next());
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
	
	public static void consultaItemG(String palabra) {
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
						+ "select distinct d.idioma.nombre "
						+ "from Diccionario as d "
						+ "join d.definiciones as def "
						+ "where index(def) = :palabra  "
						)
					.setString("palabra", palabra);
				list = queryResult.list();
				tx.commit();
				Iterator<String> iterator = list.iterator();
				while( iterator.hasNext() ){
					System.out.println("El idioma " + iterator.next() + " define la palabra '" + palabra + "'" );
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
	
	public static void consultaItemH() {
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
						+ "select distinct doc.nombre "
						+ "from Documento as doc "
						+ "join doc.parrafos as p "
						//el documento no esta en los que tienen traducciones
						+ "where doc not in ( "
							//documentos con traducciones
							+ "select doc "
							+ "from Traduccion as t "
							+ "join t.parrafo as p "
							+ "join p.documento as doc "
							+ "group by doc "
						+ ")"
						);
				list = queryResult.list();
				tx.commit();
				Iterator<String> iterator = list.iterator();
				while( iterator.hasNext() ){
					System.out.println("El documento " + iterator.next() + " no tiene ninguna traduccion" );
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
