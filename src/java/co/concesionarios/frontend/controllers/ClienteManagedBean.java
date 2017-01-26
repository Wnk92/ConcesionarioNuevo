/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Cliente;
import co.concesionario.backend.persistences.facades.ClienteFacadeLocal;
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
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable, InterfaceManagedBean<Cliente> {
    
private Cliente cliente;
@EJB
private ClienteFacadeLocal clientefl;
   
    public ClienteManagedBean() {
        
    }
    
    @PostConstruct
    public void init(){
    cliente = new Cliente();
    }

    @Override
    public Cliente getObjectByKey(Integer llave) {
        return clientefl.find(llave);
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
    public void registrarCliente(){
    
    clientefl.create(cliente);
        
    }
    
    public void eliminarCliente(){
    
    clientefl.remove(cliente);
        
    }
    
    public List<Cliente> listarCliente(){
    
    return clientefl.findAll();
    
    }
}
