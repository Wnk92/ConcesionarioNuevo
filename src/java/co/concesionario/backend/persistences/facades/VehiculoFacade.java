/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionario.backend.persistences.facades;

import co.concesionario.backend.persistences.entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author camila
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "RedConcesionariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public List<Vehiculo> consultaVehiculo(int precio) {

        return em.createNamedQuery("Vehiculo.consultaPrecio").setParameter("precio", precio).getResultList();

    }

    @Override
    public List<Vehiculo> consultaVehiculo2(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecio2").setParameter("precio", precio).getResultList();
    }

    @Override
    public List<Vehiculo> buscar(int codigoVehiculo) throws Exception {

        List<Vehiculo> list;
        try {
            String jpql = "FROM Vehiculo v WHERE v.codigoVehiculo = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, codigoVehiculo);

            list = query.getResultList();

        } catch (Exception e) {

            throw e;
        }
        return list;
    }


    

}
