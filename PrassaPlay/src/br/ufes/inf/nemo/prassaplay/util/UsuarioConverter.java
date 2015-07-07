package br.ufes.inf.nemo.prassaplay.util;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufes.inf.nemo.prassaplay.domain.Usuario;

@FacesConverter(value = "usuarioConverter",forClass = Usuario.class)
@ManagedBean(value = "usuarioConverter")  
@RequestScoped   
public class UsuarioConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Usuario) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Usuario) {
            Usuario entity= (Usuario) value;
            if (entity != null && entity instanceof Usuario && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}