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
@Entity
@Table (name = "TTiposVehiculo")
public class TipoVehiculo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private double precioHora;
	@OneToMany( mappedBy="tipo" )
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	
	TipoVehiculo(){}
	public TipoVehiculo(String nombre, double precioHora) {
		super();
		this.nombre = nombre;
		this.precioHora = precioHora;
	}
	public Long getId() {
		return id;
	}
	public void addVehiculo(Vehiculo vehiculo){
		vehiculo._setTipo( this );
		this.vehiculos.add(vehiculo);
	}
	public void removeVehiculo(Vehiculo vehiculo){
		this.vehiculos.remove(vehiculo);
		vehiculo._setTipo(null);
	}
	public Set<Vehiculo> getVehiculos(){
		return Collections.unmodifiableSet(vehiculos);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	void _setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioHora() {
		return precioHora;
	}
	void _setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
