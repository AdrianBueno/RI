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
@Table (name = "TRepuestos")
public class Repuesto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String codigo;
	private String descripcion;
	private double precio;
	@OneToMany(mappedBy="repuesto")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();
	Repuesto(){}
	public Repuesto(String codigo, String descripcion, double money) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = money;
	}
	
	public Long getId() {
		return id;
	}

	Set<Sustitucion> _getSustituciones(){
		return this.sustituciones;
	}
	public Set<Sustitucion> getSustituciones(){
		return Collections.unmodifiableSet(this.sustituciones);
	}
	public String getCodigo() {
		return codigo;
	}
	void _setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	void _setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	void _setPrecio(double money) {
		this.precio = money;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Repuesto other = (Repuesto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
