/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author leandro
 *
 */
public class Moderador extends Usuario {

	/**
	 * @param email
	 * @param nombre
	 * @param fechaDeCreacion
	 */
	public Moderador(String email, String nombre, Date fechaDeCreacion) {
		super(email, nombre, fechaDeCreacion);
		this.evaluaciones = new ArrayList<Evaluacion>();
		this.idiomas = new ArrayList<Idioma>();
	}
	
	private Collection<Evaluacion> evaluaciones;
	private Collection<Idioma> idiomas;
	
	public int reputacion() {
		return this.getEvaluaciones().size();
	}
	
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception {
		if (!((this.manejaIdioma(traduccion.getIdioma()) && (this.manejaIdioma(traduccion.getIdiomaOriginal())))))
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		this.getEvaluaciones().add(new Evaluacion(new Date(), descripcion, true, traduccion, puntaje));
		
	}
	
	public Boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}
	
	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}

	/**
	 * @return the evaluaciones
	 */
	public Collection<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	/**
	 * @return the idiomas
	 */
	public Collection<Idioma> getIdiomas() {
		return idiomas;
	}
	
}
