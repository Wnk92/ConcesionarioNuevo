/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.utilities.converter;

import co.concesionario.backend.persistences.entities.DTO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


/**
 *
 * @author camila
 */
public abstract class AbstractConverter implements Converter{
    
    protected String namedManagedBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer llave = Integer.valueOf(value);
            InterfaceManagedBean imb = (InterfaceManagedBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, namedManagedBean);
            return imb.getObjectByKey(llave);
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage("Error al implementar" + e.getMessage()));
        }
        return null;
   }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof DTO){
                DTO objetoEntidad = (DTO) value;
                return objetoEntidad.ObtenerLlavePrimaria();
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error al convertir" + e.getMessage()));
        }
return null;
   }
    
    
    
}

