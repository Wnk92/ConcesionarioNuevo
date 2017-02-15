/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Venta;
import co.concesionario.backend.persistences.entities.Venta_;
import co.concesionario.backend.persistences.facades.VentaFacadeLocal;
import co.concesionarios.frontend.utilities.converter.InterfaceManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author camila
 */
@Named(value = "ventaManagedBean")
@RequestScoped
public class VentaManagedBean implements Serializable, InterfaceManagedBean<Venta> {

    private Venta venta;

    @EJB
    private VentaFacadeLocal ventafl;
    private List<Venta> masVendido;
    private int idVehiculo;

    public VentaManagedBean() {
    }

    @PostConstruct
    public void init() {
        venta = new Venta();
    }

    @Override
    public Venta getObjectByKey(Integer llave) {
        return ventafl.find(llave);
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void registrarVenta() {

        try {

            ventafl.create(venta);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Venta registrada con éxito"));

        } catch (Exception e) {

        }
    }

    public void eliminarVenta(Venta v) {

        ventafl.remove(v);

    }

    public List<Venta> listarVenta() {

        return ventafl.findAll();

    }


    public List<Venta> getMasVendido() {
        return masVendido;
    }

    public void setMasVendido(List<Venta> masVendido) {
        this.masVendido = masVendido;
    }
}
