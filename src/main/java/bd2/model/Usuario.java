/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Representa un usuario del sistema, que puede tomar cursos y aportar traducciones.
 * @author Leandro Di Tommaso
 */
public class Usuario {
	
	/**
	 * Crea un usuario con el email, el nombre y la fecha de creacion recibidos como
	 * parametro.
	 * @param email
	 * @param nombre
	 * @param fechaDeCreacion
	 */
	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.traducciones = new ArrayList<Traduccion>();
		this.cursadasRealizadas = new ArrayList<Cursada>();
	}
	
	private String email;
	private String nombre;
	private Date fechaDeCreacion;
	private Collection<Traduccion> traducciones = new ArrayList<Traduccion>();
	private Collection<Cursada> cursadasRealizadas = new ArrayList<Cursada>();
	
	/**
	 * Devuelve el correo electronico del usuario.
	 * @return Email del usuario.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Guarda la direccion de correo electronico del usuario.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Devuelve el nombre del usuario.
	 * @return Nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Recibe un nombre y lo guarda como el nombre del usuario.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve la fecha de creacion del usuario.
	 * @return Fecha de creacion.
	 */
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	
	/**
	 * Recibe como parametro una fecha y la guarda como fecha de creacion del usuario.
	 * @param fechaDeCreacion
	 */
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	/**
	 * Devuelve las traducciones aportadas por el usuario.
	 * @return Coleccion de Traducciones.
	 */
	public Collection<Traduccion> getTraducciones() {
		return traducciones;
	}
	
	/**
	 * Devuelve las cursadas que el usuario realizo en el sitio.
	 * @return Coleccion de cursadas.
	 */
	public Collection<Cursada> getCursadasRealizadas() {
		return cursadasRealizadas;
	}
	
	/**
	 * Recibe una cursada y la agrega a las cursadas que el usuario realizo.
	 * @param cursada
	 */
	public void agregarCursada(Cursada cursada) {
		this.getCursadasRealizadas().add(cursada);
	}

	/**
	 * Recibe una traduccion y la agrega a las traducciones aportadas por el usuario.
	 * @param traduccion
	 */
	public void agregarTraduccion(Traduccion traduccion) {
		this.getTraducciones().add(traduccion);
	}
	
	/**
	 * Recibe como parametro un idioma y retorna el nivel del usuario para el idioma
	 * solicitado. Para ello, verifica todos los cursos realizados por el usuario y retorna
	 * el nivel del curso mas avanzado aprobado por el usuario.
	 * @param idioma
	 * @return Nivel del usuario para el idioma dado.
	 */
	public int nivel(Idioma idioma) {
		Iterator<Cursada> cursadas = this.getCursadasRealizadas().iterator();
		Cursada cursada;
		Integer nivel = 0;
		while (cursadas.hasNext()) {
			cursada = cursadas.next();
			if ((cursada.getIdioma().getNombre().equals(idioma.getNombre())) && 
				((cursada.getCurso().getNivel()) > nivel) && cursada.finalizada())
				nivel = cursada.getCurso().getNivel();
		}		
		return nivel;
	}
	
	/**
	 * Dado un idioma, devuelve una coleccion con todas las cursadas aprobadas por el usuario
	 * para el idioma solicitado.
	 * @param idioma
	 * @return Coleccion de cursadas.
	 */
	public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
		Iterator<Cursada> cursadas = this.getCursadasRealizadas().iterator();
		Collection<Cursada> cursadasAprobadas = new ArrayList<Cursada>();
		Cursada cursada;
		
		while (cursadas.hasNext()) {
			cursada = cursadas.next();
			if ((cursada.getIdioma().getNombre().equals(idioma.getNombre())) &&
				cursada.finalizada()) {
				cursadasAprobadas.add(cursada);
			}
		}		
		return cursadasAprobadas;
	}
	
}
