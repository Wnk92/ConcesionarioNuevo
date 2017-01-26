/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.utilities.converter;

/**
 *
 * @author camila
 */
public interface InterfaceManagedBean<T> {
    T getObjectByKey(Integer llave);
    
}
