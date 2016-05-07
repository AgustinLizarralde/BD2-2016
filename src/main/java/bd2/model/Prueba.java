package bd2.model;

/**
 * Es un examen tomado en el marco de una cursada,
 * asociado a una leccion especifica.
 * @author Leandro Di Tommaso
 */
public class Prueba {
	
	/**
	 * Crea un objeto Prueba con una leccion y un puntaje.
	 * @param leccion
	 * @param puntaje
	 */
	public Prueba(Leccion leccion, Integer puntaje) throws Exception {
		super();
		this.leccion = leccion;
		this.setPuntaje(puntaje);
	}

	private long id;
	private Leccion leccion;
	private Integer puntaje;
	
	/**
	 * Devuelve el puntaje obtenido en la prueba.
	 * @return Puntaje de la prueba.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Guarda el puntaje obtenido en la prueba. Dicho puntaje debe estar entre 0 y 100,
	 * caso contrario se eleva una excepcion. Si el puntaje dado fuera mayor a 100, se guarda
	 * como puntaje 100 y se eleva una excepcion que indica que el puntaje no puede ser mayor a 100.
	 * En caso de que el puntaje dado fuera menor a 0, se guarda un puntaje de 1 y la excepcion
	 * indicara que no se puede obtener resultados negativos.
	 * @param puntaje
	 */
	public void setPuntaje(Integer puntaje) throws Exception {
		if (puntaje < 0) {
			this.puntaje = 1;
			throw new Exception("No se puede usar valores negativos como puntaje de una prueba.");
		}
		else if (puntaje > 100) {
			this.puntaje = 100;
			throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
		}
		this.puntaje = puntaje;
	}

	/**
	 * Devuelve la leccion asociada a la prueba.
	 * @return Leccion.
	 */
	public Leccion getLeccion() {
		return leccion;
	}

	/**
	 * Asocia a la prueba la Leccion dada por parametro.
	 * @param leccion
	 */
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}
	
	/**
	 * Permite saber si la prueba esta aprobada o no.
	 * Se considera aprobada si el puntaje es mayor o igual a 60.
	 * @return Boolean, que indica si la prueba fue aprobada o no.
	 */
	public Boolean aprobada() {
		return this.getPuntaje() >= 60;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
