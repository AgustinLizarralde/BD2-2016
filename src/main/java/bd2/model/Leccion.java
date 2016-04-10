package bd2.model;

/**
 * Es una lección tomada por un usuario en el marco de un curso.
 * @author Leandro Di Tommaso
 */
public class Leccion {
	
	/**
	 * Crea una lección con el nombre indicado.
	 * @param nombre
	 */
	public Leccion(String nombre) {
		super();
		this.nombre = nombre;
	}

	private String nombre;

	/**
	 * @return El nombre de la lección.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param Recibe el nombre que tendrá la lección.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
