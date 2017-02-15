/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionario.backend.persistences.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "concesionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concesionario.findAll", query = "SELECT c FROM Concesionario c"),
    @NamedQuery(name = "Concesionario.findByNit", query = "SELECT c FROM Concesionario c WHERE c.nit = :nit"),
    @NamedQuery(name = "Concesionario.findByNombre", query = "SELECT c FROM Concesionario c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concesionario.findByTelefono", query = "SELECT c FROM Concesionario c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Concesionario.findByDireccion", query = "SELECT c FROM Concesionario c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Concesionario.findByUsuario", query = "SELECT c FROM Concesionario c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Concesionario.findByContrase\u00f1a", query = "SELECT c FROM Concesionario c WHERE c.contrase\u00f1a = :contrase\u00f1a")})
public class Concesionario implements Serializable, DTO {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcesionario", fetch = FetchType.EAGER)
    private List<Venta> ventaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private Integer nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoConcesionario", fetch = FetchType.EAGER)
    private List<Vehiculo> vehiculoList;

    public Concesionario() {
    }

    public Concesionario(Integer nit) {
        this.nit = nit;
    }

    public Concesionario(Integer nit, String nombre, String telefono, String direccion, String usuario, String contraseña) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concesionario)) {
            return false;
        }
        Concesionario other = (Concesionario) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.concesionario.backend.persistences.entities.Concesionario[ nit=" + nit + " ]";
    }

    @Override
    public String ObtenerLlavePrimaria() {
        return nit.toString();
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }
    
}
