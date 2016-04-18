package bd2.model;

/**
 * Parrafo de un documento
 *
 */
public class Parrafo {
	private long id;
	private String texto;
	private Documento documento;
	
	protected Parrafo() {
		super();
	}

	public Parrafo(String texto, Documento documento) {
		super();
		this.texto = texto;
		this.documento = documento;
	}

	/**
	 * @return texto del parrafo
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @param texto texto del parrafo
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/**
	 * @return documento al que pertenece
	 */
	public Documento getDocumento() {
		return documento;
	}
	
	/**
	 * @param documento documento al que pertenece
	 */
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * @return idioma del parrafo
	 */
	public Idioma getIdioma() {
		return this.documento.getIdioma();
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
