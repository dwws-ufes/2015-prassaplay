package br.ufes.inf.nemo.prassaplay.persistence;

import javax.ejb.Stateless;

import br.ufes.inf.nemo.prassaplay.domain.Review;

/**
 * Session Bean implementation class ReviewDAO
 */
@Stateless
public class ReviewDAO extends DAO<Review> {

	@Override
    protected Class<Review> getDomainClass() {
        // TODO Auto-generated method stub
        return Review.class;
    }

}
