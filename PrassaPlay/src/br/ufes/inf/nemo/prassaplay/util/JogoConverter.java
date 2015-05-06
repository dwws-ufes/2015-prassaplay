package br.ufes.inf.nemo.prassaplay.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufes.inf.nemo.prassaplay.application.ManageJogosServiceBean;
import br.ufes.inf.nemo.prassaplay.domain.Jogo;

@FacesConverter("jogoConverter")
public class JogoConverter implements Converter {

   public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

	   
	   ManageJogosServiceBean manageJogosServiceBean = new ManageJogosServiceBean();
	   
	   //System.out.println(manageJogosServiceBean.getLista().get(0).getNome());
	   System.out.println("2 " + manageJogosServiceBean.getLista().size() + "  4" );
	   
       if(value != null && value.trim().length() > 0) {
//               ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
    	   ListaJogos listasso = (ListaJogos) fc.getExternalContext().getApplicationMap().get("listaJogos");
        	   
        	   //System.out.println("mkm" + manageJogosServiceBean.getLista());
    	   //System.out.println(listasso.getJogos().get(0));
    	   //System.out.println("bbbbb" + listasso.getJogos().size());
        	   //return listadejogos.get(Integer.parseInt(value));
    	   return listasso.getJogos().get(Integer.parseInt(value));

       }
       else {
           return null;
       }
   }

   public String getAsString(FacesContext fc, UIComponent uic, Object object) {
       if(object != null) {
           return String.valueOf(((Jogo) object).getId());
       }
       else {
           return null;
       }
   }   
}