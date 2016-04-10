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
	 * @param mail
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param mail the mail to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the fechaDeCreacion
	 */
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	
	/**
	 * @param fechaDeCreacion the fechaDeCreacion to set
	 */
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	/**
	 * @return the traducciones
	 */
	public Collection<Traduccion> getTraducciones() {
		return traducciones;
	}
	
	/**
	 * @return the cursadasRealizadas
	 */
	public Collection<Cursada> getCursadasRealizadas() {
		return cursadasRealizadas;
	}
	
	public void agregarCursada(Cursada cursada) {
		this.getCursadasRealizadas().add(cursada);
	}

	public void agregarTraduccion(Traduccion traduccion) {
		this.getTraducciones().add(traduccion);
	}
	
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
