package br.ufes.inf.nemo.prassaplay.controller;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.prassaplay.application.ManageUsuariosServiceBean;
import br.ufes.inf.nemo.prassaplay.domain.Usuario;

@Model
@ManagedBean
public class ManageUsuariosController {
	
	@EJB
	private ManageUsuariosServiceBean manageUsuariosService;
	
	private Usuario usuario = new Usuario();
		
	public String salvar() {
		manageUsuariosService.criar(usuario);
		return "/index.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
