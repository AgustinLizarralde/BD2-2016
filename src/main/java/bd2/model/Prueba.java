package bd2.model;

/**
 * Es un examen tomado en el marco de una cursada,
 * asociado a una leccion especifica.
 * @author Leandro Di Tommaso
 */
public class Prueba {
	
	/**
	 * Crea un objeto Prueba con una leccion y un puntaje.
	 * @param Leccion.
	 * @param Puntaje.
	 */
	public Prueba(Leccion leccion, Integer puntaje) throws Exception {
		super();
		this.leccion = leccion;
		this.setPuntaje(puntaje);
	}

	private Leccion leccion;
	private Integer puntaje;
	
	/**
	 * @return Puntaje de la Prueba.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Guarda el puntaje obtenido en la prueba.
	 * Dicho puntaje debe estar entre 0 y 100,
	 * caso contrario se eleva una excepción.
	 * @param Puntaje obtenido en la Prueba.
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
	 * @return Lección correspondiente a la Prueba.
	 */
	public Leccion getLeccion() {
		return leccion;
	}

	/**
	 * @param Asocia a la Prueba la Leccion correspondiente.
	 */
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}
	
	/**
	 * Permite saber si la prueba esta aprobada o no.
	 * Se considera aprobada si el puntaje es mayor o igual a 60.
	 * @return Valor que indica si la prueba fue aprobada o no.
	 */
	public Boolean aprobada() {
		return this.getPuntaje() >= 60;
	}

}
