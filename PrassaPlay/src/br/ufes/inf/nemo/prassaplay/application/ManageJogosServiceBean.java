package br.ufes.inf.nemo.prassaplay.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.prassaplay.domain.Jogo;
import br.ufes.inf.nemo.prassaplay.persistence.JogoDAO;

@Stateless
public class ManageJogosServiceBean {

	@EJB
	private JogoDAO jogoDAO;

	public Jogo createNewEntity() {
		return new Jogo();
	}

	public JogoDAO getDAO() {
		return jogoDAO;
	}

	public void criar(Jogo jogo) {
		//System.out.println(jogo.toString());
		jogoDAO.salvar(jogo);
	}
	
	public List<Jogo> recupearJogos(){
		return jogoDAO.recuperaTodos();
	}

	public List<Jogo> getLista() {
		return jogoDAO.recuperaTodos();
	}

	@Override
	public String toString() {
		return "ManageJogosServiceBean [jogoDAO=" + jogoDAO + "]";
	}

}
