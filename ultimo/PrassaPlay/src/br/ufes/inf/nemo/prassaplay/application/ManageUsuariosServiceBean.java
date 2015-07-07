package br.ufes.inf.nemo.prassaplay.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.ufes.inf.nemo.prassaplay.domain.Usuario;
import br.ufes.inf.nemo.prassaplay.persistence.UsuarioDAO;

@Stateless
public class ManageUsuariosServiceBean {

	@EJB
	private UsuarioDAO usuarioDAO;

	public Usuario createNewEntity() {
		return new Usuario();
	}

	public UsuarioDAO getDAO() {
		return usuarioDAO;
	}

	public void criar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	public List<Usuario> getLista() {
		// TODO Auto-generated method stub
		return usuarioDAO.recuperaTodos();
	}

	@Override
	public String toString() {
		return "ManageUsuariosServiceBean [usuarioDAO=" + usuarioDAO + "]";
	}
	
	
}
