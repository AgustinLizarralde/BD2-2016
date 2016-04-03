package bd2.model;

import java.util.Date;

/**
 * Traduccion de un parrafo de un texto
 *
 */
public class Traduccion extends Tarea {
	private Parrafo parrafo;
	private Idioma idioma;
	private String texto;
	
	public Traduccion(Date fecha, String descripcion, Boolean completado, String texto, Parrafo parrafo, Idioma idioma) {
		super(fecha, descripcion, completado);
		this.parrafo = parrafo;
		this.idioma = idioma;
		this.texto = texto;
	}
	/**
	 * @return el parrafo
	 */
	public Parrafo getParrafo() {
		return parrafo;
	}
	
	/**
	 * @param setea el parrafo
	 */
	public void setParrafo(Parrafo parrafo) {
		this.parrafo = parrafo;
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
	 * @return el idiomaOriginal
	 */
	public Idioma getIdiomaOriginal() {
		return parrafo.getIdioma();
	}
	/**
	 * @return el texto (traduccion hecha)
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param setea el texto (traduccion hecha)
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
