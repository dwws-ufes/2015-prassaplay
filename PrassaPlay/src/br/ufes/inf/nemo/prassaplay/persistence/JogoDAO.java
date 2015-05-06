package br.ufes.inf.nemo.prassaplay.persistence;

import javax.ejb.Stateless;

import br.ufes.inf.nemo.prassaplay.domain.Jogo;

/**
 * Session Bean implementation class ReviewDAO
 */
@Stateless
public class JogoDAO extends DAO<Jogo> {

	@Override
	protected Class<Jogo> getDomainClass() {
		// TODO Auto-generated method stub
		return Jogo.class;
	}
}
