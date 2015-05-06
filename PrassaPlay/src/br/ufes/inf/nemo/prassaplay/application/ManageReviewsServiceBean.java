package br.ufes.inf.nemo.prassaplay.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.prassaplay.domain.Review;
import br.ufes.inf.nemo.prassaplay.persistence.ReviewDAO;

@Stateless
public class ManageReviewsServiceBean {

	@EJB
	private ReviewDAO reviewDAO;

	public Review createNewEntity() {
		return new Review();
	}

	public ReviewDAO getDAO() {
		return reviewDAO;
	}

	public void criar(Review review) {
		reviewDAO.salvar(review);
	}

	public List<Review> getLista() {
		// TODO Auto-generated method stub
		return reviewDAO.recuperaTodos();
	}
	
	public void excluir(Review obj){ 
		reviewDAO.delete(obj);
	}

	@Override
	public String toString() {
		return "ManageReviewsServiceBean [reviewDAO=" + reviewDAO + "]";
	}

}
