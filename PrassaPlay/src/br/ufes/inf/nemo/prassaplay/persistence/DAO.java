package br.ufes.inf.nemo.prassaplay.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.ufes.inf.nemo.prassaplay.domain.Identificador;

public abstract class DAO<T extends Identificador> {
	
	@PersistenceContext
    private EntityManager em;
 
    public EntityManager getEm() {
        return em;
    }
     
    protected abstract Class<T> getDomainClass();
 
 
    public Identificador salvar(Identificador obj) {
        if (obj.isPersistente()) {
        	//System.out.println("entrou no salvar persistente  ");
            obj = em.merge(obj);
        } else {
        	//System.out.println("entrou no salvar  ");
            em.persist(obj);
        }
        return obj;
    }
     
    public List<T> recuperaTodos() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(getDomainClass()));
        return em.createQuery(cq).getResultList();
    }
    
    public void delete(Identificador obj){
    	em.remove(em.merge(obj));
    }
    
}
