package bd2.model;

import java.util.Date;

/**
 * Clase para la evaluación de las traducciones 
 *
 */
public class Evaluacion extends Tarea {
	private int puntaje;
	private Traduccion traduccion;
	
	public Evaluacion(Date fecha, String descripcion, Boolean completado, Traduccion traduccion, int puntaje) {
		super(fecha, descripcion, completado);
		this.puntaje = puntaje;
		this.traduccion = traduccion; 
	}
	
	/**
	 * @return el puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * @param setea el puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	/**
	 * @return la traduccion
	 */
	public Traduccion getTraduccion() {
		return traduccion;
	}
	
	/**
	 * @param setea la traduccion
	 */
	public void setTraduccion(Traduccion traduccion) {
		this.traduccion = traduccion;
	}
		
}