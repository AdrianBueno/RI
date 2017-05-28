package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.common.model.types.Address;
@Entity
@Table (name = "TClientes")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue 
	private Long id;
	
	//Campos naturales
	private String dni;
	private String nombre;
	private String apellidos;

	private Address address;
	//Campos de asociaciones
	
	@OneToMany(mappedBy="cliente")
	private Set<MedioPago> mediosPago = new HashSet<MedioPago>();
	@OneToMany (mappedBy = "cliente")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	
	public Cliente(){}
	
	public Cliente(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}
	void _setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	void _setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	void _setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Address getAddress() { //Es mutable ? que hacer con el?
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public void addMedioPago(MedioPago medioPago){
		medioPago._setCliente( this );
		this.mediosPago.add(medioPago);
	}
	public void removeMedioPago(MedioPago medioPago){
		this.mediosPago.remove(medioPago);
		medioPago._setCliente( null );
	}
	public Set<MedioPago> getMediosPago(){
		return Collections.unmodifiableSet(this.mediosPago);
	}
	public void addVehiculo(Vehiculo vehiculo){
		vehiculo._setCliente( this );
		this.vehiculos.add(vehiculo);
	}
	public void removeVehiculo(Vehiculo vehiculo){
		this.vehiculos.remove(vehiculo);
		vehiculo._setCliente(null);
	}
	public Set<Vehiculo> getVehiculos(){
		return Collections.unmodifiableSet(vehiculos);
	}
	//Métodos sobreescritos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
