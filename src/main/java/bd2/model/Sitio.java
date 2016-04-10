/**
 * 
 */
package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Modela la plataforma de aprendizaje de idiomas.
 * @author Leandro Di Tommaso
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
	 * Devuelve los cursos disponibles en la plataforma web.
	 * @return Coleccion de Cursos.
	 */
	public Collection<Curso> getCursos() {
		return cursos;
	}
	
	/**
	 * Devuelve los documentos presentes en el sitio.
	 * @return Coleccion de Documentos.
	 */
	public Collection<Documento> getDocumentos() {
		return documentos;
	}
	
	/**
	 * Permite obtener los usuarios del sitio web.
	 * @return Coleccion de Usuarios.
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Registra un nuevo usuario en el sitio web.
	 * @param usuario
	 */
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	/**
	 * Agrega un curso a la plataforma.
	 * @param curso
	 */
	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}
	
	/**
	 * Agrega un documento al sitio.
	 * @param documento
	 */
	public void agregarDocumento(Documento documento) {
		this.getDocumentos().add(documento);
	}
	
}
