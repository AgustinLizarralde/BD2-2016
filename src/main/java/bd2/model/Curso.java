/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Leandro Di Tommaso
 */
public class Curso {
	
	/**
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

	private String nombre;
	private Integer nivel;
	private Idioma idioma;
	private Collection<Leccion> lecciones = new ArrayList<Leccion>();
	
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
	 * @return the nivel
	 */
	public Integer getNivel() {
		return nivel;
	}
	
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * @return the idioma
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * @return the lecciones
	 */
	public Collection<Leccion> getLecciones() {
		return lecciones;
	}
	
	/**
	 * @param 
	 */
	public void agregarLeccion(Leccion leccion) {
		this.lecciones.add(leccion);
	}

}
