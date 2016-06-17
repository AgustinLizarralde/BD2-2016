package bd2.util;

import java.text.SimpleDateFormat;
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
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		sessions = cfg.buildSessionFactory();
		Session session = sessions.openSession();
		try {
			consultaItemA(session);
			consultaItemB(session);
			consultaItemC(session);
			Date desde = new GregorianCalendar(2015,Calendar.JULY,1).getTime();
			Date hasta = new GregorianCalendar(2015,Calendar.DECEMBER,31).getTime();
			consultaItemD(session, desde, hasta);
			consultaItemE(session);
			consultaItemF(session);
			consultaItemG(session, "Leuchtturm");
			consultaItemH(session);
			consultaItemI(session, "Alemán");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.disconnect();
		}
	}
	
	public static void consultaItemA(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nA. Listar los nombres de todos los documentos.");
		try {
			tx = session.beginTransaction();
			queryResult = session.createQuery("select nombre from Documento");
			list = queryResult.list();
			tx.commit();
			Iterator<String> iterator = list.iterator();
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
	}
	
	public static void consultaItemB(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nB. Listar los emails de los moderadores que hayan evaluado traducciones al inglés.");
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
	}
	
	public static void consultaItemC(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nC. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3 como mínimo.");
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
	}
	
	public static void consultaItemD(Session session, Date desde, Date hasta) {
		Query queryResult;
		List list;
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Transaction tx = null;
        System.out.println("\nD. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.");
        System.out.println("Resultados para los parámetros " + dateFormat.format(desde) + " hasta " + dateFormat.format(hasta) + ".");
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
	}
	
	public static void consultaItemE(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nE. Listar traducciones completas del Inglés al Francés.");
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
	}
	
	public static void consultaItemF(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nF. Obtener los emails de los usuarios con alguna cursada aprobada.");
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
	}
	
	public static void consultaItemG(Session session, String palabra) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nG. Obtener el idioma que define la palabra enviada como parámetro en su diccionario.");
        System.out.println("Resultados para el parámetro: " + palabra + ".");
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
				System.out.println("El idioma " + iterator.next() + " define la palabra " + palabra + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
	}
	
	public static void consultaItemH(Session session) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nH. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningún idioma).");
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
				System.out.println("El documento " + iterator.next() + " no tiene ninguna traduccion.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
	}
		
	public static void consultaItemI(Session session, String idioma) {
		Query queryResult;
		List list;
		Transaction tx = null;
        System.out.println("\nI. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro.");
        System.out.println("Resultados para el parámetro: " + idioma + ".");
		try {
			tx = session.beginTransaction();
			queryResult = session.createQuery(""
					+ "select distinct p.documento.nombre "
					+ "from Parrafo p "
	                + "where p not in ("
	                	+ "select t.parrafo "
	                	+ "from Traduccion t "
	                	+ "where :idioma = t.idioma.nombre"
	                + ")"
					)
				.setString("idioma", idioma);
			list = queryResult.list();
			tx.commit();
			Iterator<String> iterator = list.iterator();
			while( iterator.hasNext() ){
				System.out.println("El documento " + iterator.next() + " no está totalmente traducido.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			session.close();
		}
	}
		
}
