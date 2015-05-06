package br.ufes.inf.nemo.prassaplay.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Jogo
 *
 */
@Entity
public class Jogo extends Identificador implements Serializable {

	private String nome;
	private Integer dataLancamento;

	@OneToMany(mappedBy = "jogo")
	private Set<Review> reviews;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Plataformas> plataformas;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Generos> generos;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Duracoes> duracoes;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Publicadoras> publicadoras;

	private static final long serialVersionUID = 1L;

	public Jogo() {
		super();
		plataformas = new HashSet<Plataformas>();
		generos = new HashSet<Generos>();
		duracoes = new HashSet<Duracoes>();
		publicadoras = new HashSet<Publicadoras>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Integer dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Plataformas> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Set<Plataformas> plataformas) {
		this.plataformas = plataformas;
	}

	public Set<Generos> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Generos> generos) {
		this.generos = generos;
	}

	public Set<Duracoes> getDuracoes() {
		return duracoes;
	}

	public void setDuracoes(Set<Duracoes> duracoes) {
		this.duracoes = duracoes;
	}

	public Set<Publicadoras> getPublicadoras() {
		return publicadoras;
	}

	public void setPublicadoras(Set<Publicadoras> publicadoras) {
		this.publicadoras = publicadoras;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	

}
