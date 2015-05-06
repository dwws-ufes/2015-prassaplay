package br.ufes.inf.nemo.prassaplay.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity

public class Review extends Identificador implements Serializable {

	
	private Integer nota;
	private String texto;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Jogo jogo;
	
	private static final long serialVersionUID = 1L;

	public Review() {
		super();
	}   
	public Integer getNota() {
		return this.nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}   
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}   
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
   
}
