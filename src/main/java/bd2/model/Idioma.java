package bd2.model;


/**
 * Idioma de documentos
 * 
 */
public class Idioma {
	private Long id;
	private String nombre;
	private Diccionario diccionario;
	
	public Idioma() {
		super();
		this.diccionario = new Diccionario(this);
	}
	
	public Idioma(String nombre) {
		super();
		this.nombre = nombre;
		this.diccionario = new Diccionario(this);
	}

	/**
	 * @return nombre del idioma
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre nombre del idioma 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return diccionario del idioma
	 */
	public Diccionario getDiccionario() {
		return diccionario;
	}
	
	/**
	 * @param diccionario diccionario del idioma
	 */
	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}

	/**
	 * @return el identificador de la instancia de la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id el identificador de la instancia de la clase
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}