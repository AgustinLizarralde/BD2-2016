/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author leandro
 *
 */
public class Sitio {
	
	/**
	 * 
	 */
	public Sitio() {
		super();
		this.cursos = new ArrayList<Curso>();
		this.documentos = new ArrayList<Documento>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	private Collection<Curso> cursos;
	private Collection<Documento> documentos;
	private Collection<Usuario> usuarios;
	
	/**
	 * @return the cursos
	 */
	public Collection<Curso> getCursos() {
		return cursos;
	}
	
	/**
	 * @return the documentos
	 */
	public Collection<Documento> getDocumentos() {
		return documentos;
	}
	
	/**
	 * @return the usuarios
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @params Usuario
	 */
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	/**
	 * @params Curso
	 */
	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}
	
	/**
	 * @params Documento
	 */
	public void agregarDocumento(Documento documento) {
		this.getDocumentos().add(documento);
	}
	
}
