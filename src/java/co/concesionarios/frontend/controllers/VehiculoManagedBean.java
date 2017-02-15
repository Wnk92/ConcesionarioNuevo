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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author camila
 */
@Named(value = "vehiculoManagedBean")
@ViewScoped
public class VehiculoManagedBean implements Serializable, InterfaceManagedBean<Vehiculo> {

    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacadeLocal vehiculofl;
    private int precio;
    private List<Vehiculo> pruebaCon;

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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Vehiculo> getPruebaCon() {
        return pruebaCon;
    }

    public void setPruebaCon(List<Vehiculo> pruebaCon) {
        this.pruebaCon = pruebaCon;
    }

    
    @Override
    public Vehiculo getObjectByKey(Integer llave) {
        return vehiculofl.find(llave);
    }

    public void registrarVehiculo() {

        try {

            vehiculofl.create(vehiculo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Vehículo registrado con éxito"));

        } catch (Exception e) {

        }

    }

    public List<Vehiculo> listarVehiculo() {

        return vehiculofl.findAll();

    }

    public void eliminarVehiculo(Vehiculo ve) {

        vehiculofl.remove(ve);

    }
    public void consultarPrecio(){

        pruebaCon = vehiculofl.consultaVehiculo(precio);

    }


}
