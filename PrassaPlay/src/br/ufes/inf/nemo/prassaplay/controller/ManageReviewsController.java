package br.ufes.inf.nemo.prassaplay.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.datatable.DataTable;

import br.ufes.inf.nemo.prassaplay.application.ManageJogosServiceBean;
import br.ufes.inf.nemo.prassaplay.application.ManageReviewsServiceBean;
import br.ufes.inf.nemo.prassaplay.application.ManageUsuariosServiceBean;
import br.ufes.inf.nemo.prassaplay.domain.Jogo;
import br.ufes.inf.nemo.prassaplay.domain.Review;
import br.ufes.inf.nemo.prassaplay.domain.Usuario;

@Model
@ManagedBean
public class ManageReviewsController {

	@EJB
	private ManageReviewsServiceBean manageReviewsServiceBean;
	@EJB
	private ManageJogosServiceBean manageJogosServiceBean;
	@EJB
	private ManageUsuariosServiceBean manageUsuariosServiceBean;
	
	private DataTable dataTable;

	private Review review = new Review();
	

	public List<Jogo> getListaJogos() {
		return manageJogosServiceBean.recupearJogos();
	}
	
	public List<Usuario> getListaUsuarios() {
		return manageUsuariosServiceBean.getLista();
	}
	
	public List<Review> getListaReviews() {
		return manageReviewsServiceBean.getLista();
	}

	public String salvar() {
		System.out.println(manageUsuariosServiceBean.toString());
		System.out.println(manageJogosServiceBean.toString());
		System.out.println("piroaca gaorada");
		
		manageReviewsServiceBean.criar(review);
		return "/index.xhtml";
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public void excluir(){
		review = (Review) dataTable.getRowData();
		manageReviewsServiceBean.excluir(review);
	}
	
}
