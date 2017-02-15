/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Concesionario;
import co.concesionario.backend.persistences.entities.Venta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author camila
 */
@Named(value = "sessionManagedBean")
@SessionScoped
public class SessionManagedBean implements Serializable {

    private Concesionario conc;
    private Venta ven;

    public SessionManagedBean() {
    }

    @PostConstruct
    public void init() {
        conc = (Concesionario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
         }

    public void initi(){
     ven = (Venta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
  
    
    }
    
    public Concesionario getConc() {
        return conc;
    }

    public Venta getVent() {

        return ven;
    }
}
