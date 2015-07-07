package br.ufes.inf.nemo.prassaplay.persistence;

import javax.ejb.Stateless;

import br.ufes.inf.nemo.prassaplay.domain.Usuario;

@Stateless
public class UsuarioDAO extends DAO<Usuario> {
 
    @Override
    protected Class<Usuario> getDomainClass() {
        // TODO Auto-generated method stub
        return Usuario.class;
    }
 
}