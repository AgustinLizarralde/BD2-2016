package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * La cursada esta asociada directamente a un usuario y registra el rendimiento del
 * usuario en el curso que se dicta en la cursada. La misma tiene las pruebas que
 * el usuario rinde como parte de su aprendizaje, con el resultado de cada una.
 * @author Leandro Di Tommaso
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

	private Long id;
	private Date inicio;
	private Curso curso;
	private Usuario usuario;
	private Collection<Prueba> pruebas = new ArrayList<Prueba>();
	
	/**
	 * Devuelve la fecha de inicio de la cursada.
	 * @return Fecha de inicio.
	 */
	public Date getInicio() {
		return inicio;
	}
	
	/**
	 * Guarda la fecha de inicio de la cursada.
	 * @param inicio
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	/**
	 * Devuelve el curso asociado a la cursada.
	 * @return Curso.
	 */
	public Curso getCurso() {
		return curso;
	}
	
	/**
	 * Asocia a la Cursada con un Curso.
	 * @param curso
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	/**
	 * Devuelve las pruebas de la cursada.
	 * @return Coleccion de Pruebas.
	 */
	public Collection<Prueba> getPruebas() {
		return pruebas;
	}
	
	/**
	 * Devuelve el usuario que atiende la cursada.
	 * @return Usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Registra el usuario que hara la cursada.
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Se entiende que una cursada esta finalizada cuando el usuario aprobo al menos
	 * una prueba de cada una de las lecciones del curso.
	 * @return Boolean indicando si la cursada esta finalizada o no.
	 */
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
	
	/**
	 * Permite agregar una prueba a la cursada.
	 * @param prueba
	 */
	public void agregarPrueba(Prueba prueba) {
		this.getPruebas().add(prueba);
	}
	
	/**
	 * Devuelve todas las lecciones aprobadas por el usuario en el contexto
	 * de la cursada en ejecucion.
	 * @return Coleccion de Lecciones.
	 */
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
	
	/**
	 * El nivel del curso establece una forma de medir la dificultad del mismo.
	 * De esta forma, cuanto mas alto sea el numero del nivel, mas avanzado sera el mismo.
	 * @return Nivel del curso.
	 */
	public Integer getNivel() {
		return this.getCurso().getNivel();
	}
	
	/**
	 * Devuelve el idioma que se aprende en el curso.
	 * @return Idioma.
	 */
	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param pruebas the pruebas to set
	 */
	public void setPruebas(Collection<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	
}
