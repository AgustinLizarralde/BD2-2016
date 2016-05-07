package bd2.model;

/**
 * Representa una leccion tomada por un usuario en el marco de un curso.
 * @author Leandro Di Tommaso
 */
public class Leccion {
	
	/**
	 * Crea una leccion con el nombre indicado.
	 * @param nombre
	 */
	public Leccion(String nombre) {
		super();
		this.nombre = nombre;
	}

	private long id;
	private String nombre;

	/**
	 * Devuelve el nombre de la leccion.
	 * @return Nombre de la leccion.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre de la leccion por el enviado por parametro.
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
