package bd2.model;

/**
 * Parrafo de un documento
 *
 */
public class Parrafo {
	public String texto;
	private Documento documento;
	
	public Parrafo(String texto, Documento documento) {
		super();
		this.texto = texto;
		this.documento = documento;
	}

	/**
	 * @return el texto
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * @param setea el texto del parrafo
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/**
	 * @return el documento
	 */
	public Documento getDocumento() {
		return documento;
	}
	
	/**
	 * @param setea el documento al que pertenece
	 */
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * @return el idioma
	 */
	public Idioma getIdioma() {
		return this.documento.getIdioma();
	}
	
}
