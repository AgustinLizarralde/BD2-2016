package bd2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Diccionario de un idioma con las palabras y sus definiciones
 *
 */
public class Diccionario {
	public Map<String,String> diccionario = new HashMap<String, String>();
	public String edicion;
	public Idioma idioma;
	
	
	public Diccionario() {
		super();
	}

	public Diccionario(Idioma idioma) {
		super();
		this.idioma = idioma;
	}

	public Diccionario(Idioma idioma, String edicion) {
		super();
		this.edicion = edicion;
		this.idioma = idioma;
	}

	/**
	 * @param agrega una definicion al diccionario
	 */
	public void agregarDefinicion(String palabra, String definicion){
		this.diccionario.put(palabra, definicion);
	}
	
	/**
	 * @return la definicion de la palabra dada
	 */
	public String definicion(String palabra) {
		return this.diccionario.get(palabra);
	}
	
	/**
	 * @return la edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * @param setea la edicion
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
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
	 * @return las definiciones como un Map<String, String>
	 */
	public Map<String,String> getDefiniciones() {
		return this.diccionario;
	}

}
