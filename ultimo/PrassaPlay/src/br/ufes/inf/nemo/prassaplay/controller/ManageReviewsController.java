package br.ufes.inf.nemo.prassaplay.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.datatable.DataTable;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;

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
		manageJogosServiceBean.criar(review.getJogo());
		//manageReviewsServiceBean.criar(review);
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

	public void excluir() {
		review = (Review) dataTable.getRowData();
		manageReviewsServiceBean.excluir(review);
	}

	public void suggestDescription() {
		System.out.println("Procurando na DBpedia...");
		String nomeJogo = review.getJogo().getNome();
		if (nomeJogo != null && nomeJogo.length() > 3) {
			String query = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "SELECT distinct ?x ?name ?desc "
					+ "WHERE { "
					+ "?x rdfs:label ?name ; "
					+ "dbpedia-owl:abstract ?desc . "
					+ "FILTER regex(lcase(str(?name)), \""
					+ nomeJogo.toLowerCase()
					+ "\") "
					+ "FILTER (langMatches(lang(?desc), \"EN\"))"
					+ "} "
					+ "LIMIT 1";
			QueryExecution queryExecution = QueryExecutionFactory
					.sparqlService("http://dbpedia.org/sparql", query);
			ResultSet results = queryExecution.execSelect();
			if (results.hasNext()) {
				QuerySolution querySolution = results.next();
				Literal literal = querySolution.getLiteral("desc");
				review.getJogo().setDescricao("" + literal.getValue());
				// System.out.println("" + literal.getValue());
			}
		}
		System.out.println("Fim da busca.");
	}

}
