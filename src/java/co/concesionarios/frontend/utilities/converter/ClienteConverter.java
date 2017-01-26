/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.utilities.converter;

import co.concesionario.backend.persistences.entities.Cliente;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Cliente.class)
public class ClienteConverter extends AbstractConverter{
    
    public ClienteConverter(){
    
        this.namedManagedBean = "clienteManagedBean";
    }
    
}
