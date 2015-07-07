package br.ufes.inf.nemo.prassaplay.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufes.inf.nemo.prassaplay.domain.Jogo;

@ManagedBean(name="listajogosne", eager = true)
@ApplicationScoped
public class ListaJogosTeste {
	private List<Jogo> jogos;
	
	@PostConstruct
	public void init(){
		jogos = new ArrayList<Jogo>();
		Jogo jogo1 = new Jogo();
		   jogo1.setId((long) 88);
		   jogo1.setNome("batata");
		   Jogo jogo2 = new Jogo();
		   jogo2.setId((long) 8822);
		   jogo2.setNome("batata2222");
		   jogos.add(jogo1);
		   jogos.add(jogo2);
	}
	
    public List<Jogo> getJogos() {
        return jogos;
    }

}
