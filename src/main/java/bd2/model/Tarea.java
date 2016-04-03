package bd2.model;

import java.util.Date;

/**
 * Clase abstracta de tareas a realizar
 *
 */
public abstract class Tarea {
	protected Date fecha;
	protected String descripcion;
	protected Boolean completa = false;
	
	
	/**
	 * constructor de una tarea, debe ser llamado por sus hijos
	 */
	protected Tarea(Date fecha, String descripcion, Boolean completa) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completa = completa;
	}

	/**
	 * @return la fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * @param setea la fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @param setea la descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @param setea la tarea como completa
	 */
	public void completar() {
		this.completa = true;
	}

	/**
	 * @return el estado completo
	 */
	public Boolean getCompleta() {
		return completa;
	}

	/**
	 * @param setea el valor del estado "completo"
	 */
	public void setCompleta(Boolean completa) {
		this.completa = completa;
	}
}
