package bd2.model;

import java.util.Date;

/**
 * Clase abstracta de tareas a realizar
 *
 */
public abstract class Tarea {
	protected long id;
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
	 * @return fecha de la tarea
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * @param fecha fecha de la tarea
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return descripcion de la tarea
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @param descripcion descripcion de la tarea
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * setea la tarea como completa
	 */
	public void completar() {
		this.completa = true;
	}

	/**
	 * @return estado de finalizacion
	 */
	public Boolean getCompleta() {
		return completa;
	}

	/**
	 * @param completa valor booleano del estado de finalizacion
	 */
	public void setCompleta(Boolean completa) {
		this.completa = completa;
	}

	/**
	 * @return el identificador de la instancia de la clase
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id el identificador de la instancia de la clase
	 */
	public void setId(long id) {
		this.id = id;
	}
}
