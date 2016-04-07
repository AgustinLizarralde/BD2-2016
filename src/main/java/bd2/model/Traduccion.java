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
	 * @return parrafo original
	 */
	public Parrafo getParrafo() {
		return parrafo;
	}
	
	/**
	 * @param parrafo parrafo original
	 */
	public void setParrafo(Parrafo parrafo) {
		this.parrafo = parrafo;
	}
	
	/**
	 * @return idioma al que se ha traducido
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/**
	 * @param idioma idioma al que se ha traducido
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * @return idioma original del parrafo
	 */
	public Idioma getIdiomaOriginal() {
		return parrafo.getIdioma();
	}
	/**
	 * @return texto traducido
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto texto traducido
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
