/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Venta;
import co.concesionario.backend.persistences.entities.Vehiculo;
import co.concesionario.backend.persistences.facades.VentaFacadeLocal;
import co.concesionarios.frontend.utilities.converter.InterfaceManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
    private Vehiculo vehiculo;
    @Inject
    private IndexManagedBean ven;

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

    public List<Venta> getMasVendido() {
        return masVendido;
    }

    public void setMasVendido(List<Venta> masVendido) {
        this.masVendido = masVendido;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public IndexManagedBean getVen() {
        return ven;
    }

    public void setVen(IndexManagedBean ven) {
        this.ven = ven;
    }

    public SessionManagedBean getInd() {
        return ind;
    }

    public void setInd(SessionManagedBean ind) {
        this.ind = ind;
    }

   

    public void registrarVenta() {

        try {
            venta.setFecha(new Date());
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

   
    public String mayorVenta() {
        String v = null;
        String a = null;
        try {
            for (Venta m : listarVenta()) {
                v = v + " " + m.getIdVehiculo().getNombre();
            }
            a = repetido(v);
            return a;
        } catch (Exception e) {
            return a;
        }
    }

    public String repetido(String vehiculo) {

        String palabras[] = vehiculo.split(" ");
        String palabrasA[] = vehiculo.split(" ");

        int cantidad = palabras.length;
        String resultado = "";
        int contadorMasRespe = 0;

        for (int i = 0; i < cantidad; i++) {
            int contador = 0;
            String palabra = palabras[i];

            for (int j = 0; j < cantidad; j++) {
                if (palabra.equalsIgnoreCase(palabrasA[j])) {
                    contador++;
                    palabras[j] = "";
                }
            }
            if ((contador > 1) && (contador > contadorMasRespe)) {
                resultado = palabra;
                contadorMasRespe = contador;
                System.out.print(palabras[i]);
            } else if ((contador > 1) && (contador == contadorMasRespe)) {
                resultado += " " + palabra;
            }
        }
        if (resultado == "") {
            resultado = " Solo se encuantra una venta ";
        }
        return resultado;
    }


       @Inject private SessionManagedBean ind;

    public SessionManagedBean getInde() {
        return ind;
    }

    public List<Venta> venrVentaConcesionario() {
        List<Venta> l = new ArrayList<>();
        for (Venta v : listarVenta()) {
            if(v.getIdConcesionario().equals(ind.getVent())) {
                l.add(v);
            }
        }
        return l;
    }
}
