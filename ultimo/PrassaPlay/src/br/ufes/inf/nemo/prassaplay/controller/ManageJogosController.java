package br.ufes.inf.nemo.prassaplay.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.ufes.inf.nemo.prassaplay.application.ManageJogosServiceBean;
import br.ufes.inf.nemo.prassaplay.domain.Jogo;
import br.ufes.inf.nemo.prassaplay.domain.Plataformas;
import br.ufes.inf.nemo.prassaplay.domain.Publicadoras;

@Model
@ManagedBean
public class ManageJogosController {

	@EJB
	private ManageJogosServiceBean manageJogosService;

	private Jogo jogo = new Jogo();

	private List<SelectItem> listaPlataformas;
	private Plataformas[] plataformas;

	private List<SelectItem> listaPublicadoras;
	private Publicadoras[] publicadoras;

	public List<SelectItem> getListaPlataformas() {
		if (listaPlataformas == null) {
			listaPlataformas = new ArrayList<SelectItem>();
			Plataformas[] plataformas = Plataformas.values();

			for (Plataformas plataforma : plataformas) {
				listaPlataformas.add(new SelectItem(plataforma));
			}
		}
		return listaPlataformas;
	}
	
	public List<SelectItem> getListaPublicadoras() {
		if (listaPublicadoras == null) {
			listaPublicadoras = new ArrayList<SelectItem>();
			Publicadoras[] publicadoras = Publicadoras.values();

			for (Publicadoras publicadora : publicadoras) {
				listaPublicadoras.add(new SelectItem(publicadora));
			}
		}
		return listaPublicadoras;
	}

	public String salvar() {
		// for (Plataformas p : plataformas) {
				// jogo.getPlataformas().add(p);
				// }
		
		// for (Publicadoras p : publicadoras) {
				// jogo.getPlataformas().add(p);
				// }

		manageJogosService.criar(jogo);
		return "/index.xhtml";
	}

	public Publicadoras[] getPublicadoras() {
		return publicadoras;
	}

	public void setPublicadoras(Publicadoras[] publicadoras) {
		this.publicadoras = publicadoras;
	}

	public void setListaPublicadoras(List<SelectItem> listaPublicadoras) {
		this.listaPublicadoras = listaPublicadoras;
	}

	public ManageJogosServiceBean getManageJogosService() {
		return manageJogosService;
	}

	public void setManageJogosService(ManageJogosServiceBean manageJogosService) {
		this.manageJogosService = manageJogosService;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Plataformas[] getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Plataformas[] plataformas) {
		this.plataformas = plataformas;
	}

	public void setListaPlataformas(List<SelectItem> listaPlataformas) {
		this.listaPlataformas = listaPlataformas;
	}

}
