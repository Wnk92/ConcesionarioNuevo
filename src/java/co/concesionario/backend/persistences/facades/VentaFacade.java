/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionario.backend.persistences.facades;

import co.concesionario.backend.persistences.entities.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author camila
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    @PersistenceContext(unitName = "RedConcesionariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }

    @Override
    public List<Venta> mayorVenta() {
        String sql = "select fecha from Ventas where id_venta = 1";
        Query q = em.createNativeQuery(sql);
        List<Venta> venta = q.getResultList();
        return venta;
    }

}
