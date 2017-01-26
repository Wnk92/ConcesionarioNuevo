/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Concesionario;
import co.concesionario.backend.persistences.facades.ConcesionarioFacadeLocal;
import co.concesionarios.frontend.utilities.converter.InterfaceManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "concesionarioManagedBean")
@RequestScoped
public class ConcesionarioManagedBean implements Serializable, InterfaceManagedBean<Concesionario> {

    private Concesionario concesionario;
    @EJB
    private ConcesionarioFacadeLocal concesionariofl;
   
    public ConcesionarioManagedBean() {
    }
    
    @PostConstruct
    public void init(){
    
        concesionario = new Concesionario();
        
    }

    @Override
    public Concesionario getObjectByKey(Integer llave) {
            return concesionariofl.find(llave);
    }

    
    
    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    public void registrarConcesionario(){
    
   concesionariofl.create(concesionario);
   
    }

public void eliminarConcesionario(Concesionario c){
    
concesionariofl.remove(concesionario);

}

public List<Concesionario> listarConcesionario(){

return concesionariofl.findAll();

}

}
