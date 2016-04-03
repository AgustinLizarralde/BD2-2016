package bd2.model;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Un documento tiene un idioma y está compuesto por parrafos
 *
 */
public class Documento {
	private Collection<Parrafo> parrafos = new LinkedList<Parrafo>();
	private Idioma idioma;
	private String nombre;
	private Integer complejidad;
	
	public Documento(String nombre, Idioma idioma) {
		super();
		this.idioma = idioma;
		this.nombre = nombre;
	}
	
	public Documento(String nombre, Idioma idioma, Integer complejidad, Collection<Parrafo> parrafos) {
		super();
		this.parrafos = parrafos;
		this.idioma = idioma;
		this.nombre = nombre;
		this.complejidad = complejidad;
	}

	/**
	 * @return el idioma
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/**
	 * @param setea el idioma
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param setea el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return la complejidad
	 */
	public Integer getComplejidad() {
		return complejidad;
	}

	/**
	 * @param setea la complejidad
	 */
	public void setComplejidad(Integer complejidad) {
		this.complejidad = complejidad;
	}

	/**
	 * @return collection de parrafos
	 */
	public Collection<Parrafo> getParrafos() {
		return this.parrafos;
	}
	
	/**
	 * crea un parrafo a partir del string, lo guarda y devuelve el parrafo
	 */
	public Parrafo agregarParrafo(String texto) {
		Parrafo parrafo = new Parrafo(texto, this);
		this.parrafos.add(parrafo);
		return parrafo;
	}
}
