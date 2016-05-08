/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Un curso tiene un nombre, un idioma que es el que se aprende en ese curso y un nivel,
 * que indica el grado de dificultad del mismo. Ademas, tiene una serie de lecciones que
 * son las que componen cada modulo de ensenanza del curso.
 * @author Leandro Di Tommaso
 */
public class Curso {
	
	public Curso() {
		super();
	}
	
	/**
	 * Crea un curso con un nombre, un idioma y un nivel, en base a los parametros
	 * recibidos.
	 * @param nombre
	 * @param idioma
	 * @param nivel
	 */
	public Curso(String nombre, Idioma idioma, Integer nivel) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.idioma = idioma;
		this.lecciones = new ArrayList<Leccion>();
	}

	private Long id;
	private String nombre;
	private Integer nivel;
	private Idioma idioma;
	private Collection<Leccion> lecciones = new ArrayList<Leccion>();
	
	/**
	 * Devuelve el nombre del curso.
	 * @return Nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Cambia el nombre del curso.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve un entero que representa el nivel del curso.
	 * Cuanto mas alto el numero, mas complejo el curso.
	 * @return Nivel.
	 */
	public Integer getNivel() {
		return nivel;
	}
	
	/**
	 * Establece el nivel del curso.
	 * @param nivel
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * Devuelve el idioma que se aprende en el curso.
	 * @return Idioma.
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/**
	 * Setea el idioma del curso.
	 * @param idioma
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * Devuelve todas las lecciones que se dictan en el marco del curso.
	 * @return Coleccion de Lecciones.
	 */
	public Collection<Leccion> getLecciones() {
		return lecciones;
	}
	
	/**
	 * Se agrega al curso la leccion pasada como parametro.
	 * @param leccion
	 */
	public void agregarLeccion(Leccion leccion) {
		this.lecciones.add(leccion);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Guarda las lecciones.
	 * @param lecciones the lecciones to set
	 */
	public void setLecciones(Collection<Leccion> lecciones) {
		this.lecciones = lecciones;
	}

}
