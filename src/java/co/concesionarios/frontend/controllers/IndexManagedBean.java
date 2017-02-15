
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Concesionario;
import co.concesionario.backend.persistences.facades.ConcesionarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author camila
 */
@Named(value = "indexManagedBean")
@SessionScoped
public class IndexManagedBean implements Serializable {
    private Concesionario c;
    @EJB private ConcesionarioFacadeLocal cfl;
    
    @PostConstruct
    public void init(){
        c = new Concesionario();
    }

    public Concesionario getC() {
        return c;
    }

    public void setC(Concesionario c) {
        this.c = c;
    }
    
    public String iniciarSesion(){
        try{
            Concesionario i = cfl.iniciarSesion(c);
            if(i!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", i);
                return "/lista_vehiculos.xhtml?faces-redirect=true";
            }
            i = null;
        }catch(Exception e){
        }
        c= null;
                
            return null;
    }
    
    public void verificarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context.getExternalContext().getSessionMap().get("usuario")==null){
            HttpServletRequest r = (HttpServletRequest) context.getExternalContext().getRequest();
            try{
                context.getExternalContext().redirect(r.getContextPath() + "/index.xhtml");
            }catch(Exception e){
            }
        }
    }
    
    public String cerrarSesion(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        context.getExternalContext().invalidateSession();
        c = null;
        return "/index.xhtml?faces-redirect=true";  
    }
}
