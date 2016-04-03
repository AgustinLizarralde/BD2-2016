package bd2.model;


/**
 * Idioma de documentos
 * 
 */
public class Idioma {
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
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param setea el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return el diccionario
	 */
	public Diccionario getDiccionario() {
		return diccionario;
	}
	
	/**
	 * @param setea el diccionario
	 */
	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}
	
}