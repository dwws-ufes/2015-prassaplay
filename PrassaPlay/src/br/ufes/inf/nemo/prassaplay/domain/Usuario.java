package br.ufes.inf.nemo.prassaplay.domain;

import br.ufes.inf.nemo.prassaplay.domain.Identificador;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario extends Identificador implements Serializable {

	
	private String nome;
	private String email;
	private Integer idade;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Review> reviews;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public Integer getIdade() {
		return this.idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return nome;
	}
   
}
