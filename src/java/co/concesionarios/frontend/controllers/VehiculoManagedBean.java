/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Vehiculo;
import co.concesionario.backend.persistences.facades.VehiculoFacadeLocal;
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
@Named(value = "vehiculoManagedBean")
@RequestScoped
public class VehiculoManagedBean implements Serializable, InterfaceManagedBean<Vehiculo> {

    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacadeLocal vehiculofl;

    public VehiculoManagedBean() {
    }

    @PostConstruct
    public void init() {

        vehiculo = new Vehiculo();

    }
 public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    @Override
    public Vehiculo getObjectByKey(Integer llave) {
        return vehiculofl.find(llave);
    }

   

    public void registrarVehiculo() {

        vehiculofl.create(vehiculo);

    }

    
    public List<Vehiculo> listarVehiculo() {

        return vehiculofl.findAll();

    }
    
    public void eliminarVehiculo(Vehiculo ve) {

        vehiculofl.remove(ve);

    }
}
