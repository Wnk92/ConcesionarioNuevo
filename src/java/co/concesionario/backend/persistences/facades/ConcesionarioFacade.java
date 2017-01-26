/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionario.backend.persistences.facades;

import co.concesionario.backend.persistences.entities.Concesionario;
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
public class ConcesionarioFacade extends AbstractFacade<Concesionario> implements ConcesionarioFacadeLocal {

    @PersistenceContext(unitName = "RedConcesionariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcesionarioFacade() {
        super(Concesionario.class);
    }

    @Override
        public Concesionario iniciarSesion(Concesionario con){
        Concesionario concesionario = null;
        String consulta;
        
        try {
            consulta = "FROM Concesionario c WHERE c.usuario= ?1 and c.contraseña = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, con.getUsuario());
            query.setParameter(2,con.getContraseña());
            
            
            List<Concesionario> lista = query.getResultList();
            if(!lista.isEmpty()){
            concesionario = lista.get(0);
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    return concesionario;
    }
    
}
