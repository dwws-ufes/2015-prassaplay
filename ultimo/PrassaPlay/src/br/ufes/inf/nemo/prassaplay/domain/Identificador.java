package br.ufes.inf.nemo.prassaplay.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Identificador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public boolean isPersistente() {
        return (id != null);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}