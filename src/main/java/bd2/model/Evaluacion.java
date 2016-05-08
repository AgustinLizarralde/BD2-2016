package bd2.model;

import java.util.Date;

/**
 * Clase para la evaluacion de las traducciones 
 *
 */
public class Evaluacion extends Tarea {
	private int puntaje;
	private Traduccion traduccion;
	
	public Evaluacion() {
		super();
	}
	
	public Evaluacion(Date fecha, String descripcion, Boolean completado, Traduccion traduccion, int puntaje) {
		super(fecha, descripcion, completado);
		this.puntaje = puntaje;
		this.traduccion = traduccion; 
	}
	
	/**
	 * @return puntaje de la evaluacion en formato numerico entero
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * @param puntaje puntaje de la evaluacion en formato numerico entero
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	/**
	 * @return traduccion asociada a la evaluacion
	 */
	public Traduccion getTraduccion() {
		return traduccion;
	}
	
	/**
	 * @param traduccion traduccion asociada a la evaluacion
	 */
	public void setTraduccion(Traduccion traduccion) {
		this.traduccion = traduccion;
	}
		
}