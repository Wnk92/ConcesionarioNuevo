/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionario.backend.persistences.facades;

import co.concesionario.backend.persistences.entities.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface VentaFacadeLocal {

    void create(Venta venta);

    void edit(Venta venta);

    void remove(Venta venta);

    Venta find(Object id);

    List<Venta> findAll();

    List<Venta> findRange(int[] range);

    int count();
    
    List<Venta> mayorVenta();
    
}
