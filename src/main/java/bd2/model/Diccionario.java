package bd2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Diccionario de un idioma con las palabras y sus definiciones
 *
 */
public class Diccionario {
	public Map<String,String> definiciones = new HashMap<String, String>();
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
	 * Agrega definiciones al diccionario de la forma palabra-definicion
	 * @param palabra palabra a definir
	 * @param definicion definicion de la palabra
	 */
	public void agregarDefinicion(String palabra, String definicion){
		this.definiciones.put(palabra, definicion);
	}
	
	/**
	 * @return String definicion de la palabra dada
	 * @param palabra dalabra a buscar definicion
	 */
	public String definicion(String palabra) {
		return this.definiciones.get(palabra);
	}
	
	/**
	 * @return la edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * @param edicion nombre de la edicion
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	/**
	 * @return Idioma objeto idioma
	 */
	public Idioma getIdioma() {
		return idioma;
	}

	/**
	 * @return Coleccion de definiciones como un Map<String, String>
	 */
	public Map<String,String> getDefiniciones() {
		return this.definiciones;
	}

}
