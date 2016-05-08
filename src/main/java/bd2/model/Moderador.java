/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Un moderador es un usuario que tiene la capacidad de revisar las
 * traducciones aportadas por los usuarios y calificarlas.
 * Para ello, el moderador debera conocer tanto el idioma original como
 * el idioma al que se traduce la fuente.
 * Los moderadores tienen ademas una reputacion, que se calcula en base a la
 * cantidad de evaluaciones realizadas.
 * @author Leandro Di Tommaso
 */
public class Moderador extends Usuario {

	public Moderador(){
		super();
	}
	/**
	 * El constructor del moderador recibe como parametro el correo electronico,
	 * el nombre y la fecha de creacion del mismo, que son los parametros que solicita
	 * el constructor de la clase Usuario a la que extiende.
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
	
	/**
	 * Devuelve un entero que indica la reputacion del moderador,
	 * que es igual a la cantidad de evaluaciones realizadas.
	 * @return Reputacion.
	 */
	public int reputacion() {
		return this.getEvaluaciones().size();
	}
	
	/**
	 * Recibe por parametro una traduccion, una descripcion y un puntaje y crea una evaluacion
	 * con la fecha actual, la establece como completada y le asigna la descripcion, la traduccion
	 * y el puntaje recibidos como parametro.
	 * En caso de que el moderador no conozca alguno de los dos idiomas, no podra realizar la
	 * evaluacion, por lo que se elevara una excepcion indicando la situacion.
	 * @param traduccion
	 * @param descripcion
	 * @param puntaje
	 * @throws Exception
	 */
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception {
		if (!((this.manejaIdioma(traduccion.getIdioma()) && (this.manejaIdioma(traduccion.getIdiomaOriginal())))))
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		this.getEvaluaciones().add(new Evaluacion(new Date(), descripcion, true, traduccion, puntaje));		
	}
	
	/**
	 * Recibe como parametro un idioma y devuelve verdadero o falso, dependiendo de si el moderador
	 * sabe el idioma o no.
	 * @param idioma
	 * @return Boolean, indicando si maneja el idioma o no.
	 */
	public Boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}
	
	/**
	 * Agrega el idioma a la lista de idiomas que el moderador sabe.
	 * @param idioma
	 */
	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}

	/**
	 * Devuelve la lista de evaluaciones realizadas por el moderador.
	 * @return Coleccion de evaluaciones.
	 */
	public Collection<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	/**
	 * Devuelve la lista de idiomas que sabe el moderador.
	 * @return Coleccion de idiomas.
	 */
	public Collection<Idioma> getIdiomas() {
		return idiomas;
	}

	/**
	 * @param evaluaciones the evaluaciones to set
	 */
	public void setEvaluaciones(Collection<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	/**
	 * @param idiomas the idiomas to set
	 */
	public void setIdiomas(Collection<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	
}
