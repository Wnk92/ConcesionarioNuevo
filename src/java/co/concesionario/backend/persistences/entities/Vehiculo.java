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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByCodigoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.codigoVehiculo = :codigoVehiculo"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByNombre", query = "SELECT v FROM Vehiculo v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vehiculo.findByPrecio", query = "SELECT v FROM Vehiculo v WHERE v.precio = :precio")})
public class Vehiculo implements Serializable, DTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_vehiculo")
    private Integer codigoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo", fetch = FetchType.EAGER)
    private List<Venta> ventaList;
    @JoinColumn(name = "codigo_concesionario", referencedColumnName = "nit")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Concesionario codigoConcesionario;

    public Vehiculo() {
    }

    public Vehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public Vehiculo(Integer codigoVehiculo, String marca, int modelo, String nombre, int precio) {
        this.codigoVehiculo = codigoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(Integer codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Concesionario getCodigoConcesionario() {
        return codigoConcesionario;
    }

    public void setCodigoConcesionario(Concesionario codigoConcesionario) {
        this.codigoConcesionario = codigoConcesionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVehiculo != null ? codigoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.codigoVehiculo == null && other.codigoVehiculo != null) || (this.codigoVehiculo != null && !this.codigoVehiculo.equals(other.codigoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.concesionario.backend.persistences.entities.Vehiculo[ codigoVehiculo=" + codigoVehiculo + " ]";
    }

    @Override
    public String ObtenerLlavePrimaria() {
        return codigoVehiculo.toString();
    }
    
}
