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
	 * @return el idioma del documento
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/**
	 * @param idioma idioma del documento
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * @return nombre del documento
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre nombre del documento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return numero indicando la complejidad
	 */
	public Integer getComplejidad() {
		return complejidad;
	}

	/**
	 * @param complejidad complejidad en forma numerica
	 */
	public void setComplejidad(Integer complejidad) {
		this.complejidad = complejidad;
	}

	/**
	 * @return coleccion de parrafos del documento
	 */
	public Collection<Parrafo> getParrafos() {
		return this.parrafos;
	}
	
	/**
	 * crea un parrafo a partir del string, lo guarda y devuelve el parrafo
	 * @param texto texto del nuevo parrafo
	 * @return parrafo insertado
	 */
	public Parrafo agregarParrafo(String texto) {
		Parrafo parrafo = new Parrafo(texto, this);
		this.parrafos.add(parrafo);
		return parrafo;
	}
}
