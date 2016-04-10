/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author leandro
 *
 */
public class Cursada {
	
	/**
	 * @param curso
	 * @param inicio
	 * @param usuario
	 */
	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.curso = curso;
		this.usuario = usuario;
		this.pruebas = new ArrayList<Prueba>();
		usuario.agregarCursada(this);
	}

	private Date inicio;
	private Curso curso;
	private Usuario usuario;
	private Collection<Prueba> pruebas = new ArrayList<Prueba>();
	
	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}
	
	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}
	
	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	/**
	 * @return the pruebas
	 */
	public Collection<Prueba> getPruebas() {
		return pruebas;
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Boolean finalizada() {
		Iterator<Leccion> lecciones = this.getCurso().getLecciones().iterator();
		Leccion leccion;
		while (lecciones.hasNext()) {
			leccion = lecciones.next();
			if (!(this.leccionesAprobadas().contains(leccion)))
				return false;
		}
		return true;
	}
	
	public void agregarPrueba(Prueba prueba) {
		this.getPruebas().add(prueba);
	}
	
	public Collection<Leccion> leccionesAprobadas() {
		Prueba prueba;
		Iterator<Prueba> pruebas = this.getPruebas().iterator();
		Collection<Leccion> leccionesAprobadas = new ArrayList<Leccion>();
		
		while (pruebas.hasNext()) {
			prueba = pruebas.next();
			if (prueba.aprobada()) {
				leccionesAprobadas.add(prueba.getLeccion());
			}
		}
		return leccionesAprobadas;
	}
	
	public Integer getNivel() {
		return this.getCurso().getNivel();
	}
	
	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
	}
	
}
