package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Un documento tiene un idioma y esta compuesto por parrafos
 *
 */
public class Documento {
	private Long id;
	private Collection<Parrafo> parrafos = new ArrayList<Parrafo>();
	private Idioma idioma;
	private String nombre;
	private Integer complejidad;
	
	protected Documento() {
		super();
	}

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

	/**
	 * @param parrafos coleccion de parrafos
	 */
	public void setParrafos(Collection<Parrafo> parrafos) {
		this.parrafos = parrafos;
	}
	
	/**
	 * @return el identificador de la instancia de la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id el identificador de la instancia de la clase
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
