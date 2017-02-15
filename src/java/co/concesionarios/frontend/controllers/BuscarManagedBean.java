/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistences.entities.Vehiculo;
import co.concesionario.backend.persistences.entities.Venta;
import co.concesionario.backend.persistences.facades.VehiculoFacadeLocal;
import co.concesionario.backend.persistences.facades.VentaFacadeLocal;
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
@Named(value = "buscarManagedBean")
@RequestScoped
public class BuscarManagedBean implements Serializable {

    private List<Vehiculo> filtroVehiculo; 
    private int codigoVehiculo;
    private int precio = 28000000;
    private List<Venta> listaVentas;
    private int idVehiculo;
    private Venta venta;
    private Vehiculo vehiculo;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public List<Vehiculo> getFiltroVehiculo() {
        return filtroVehiculo;
    }

    public void setFiltroVehiculo(List<Vehiculo> filtroVehiculo) {
        this.filtroVehiculo = filtroVehiculo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    

    @EJB
    private VehiculoFacadeLocal vehiculoEJB;
    @EJB
    private VentaFacadeLocal ventaEJB;


    @PostConstruct
    public void init() {
       filtroVehiculo = vehiculoEJB.findAll();
       
    venta = new Venta();
    
    }
    
    public void buscar(){
    
        try {
            filtroVehiculo = vehiculoEJB.buscar(codigoVehiculo);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    
    }
    
    public void consultar(){

        filtroVehiculo = vehiculoEJB.consultaVehiculo2(precio);

    }

   public void masVendido(){
   
       try {
           listaVentas = ventaEJB.mayorVenta();
           
       } catch (Exception e) {
       
           System.out.println(e.getMessage());
       }
       
   
   } 

}

