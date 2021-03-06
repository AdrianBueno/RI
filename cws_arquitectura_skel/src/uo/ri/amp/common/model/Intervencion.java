package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.common.model.types.IntervencionKey;
@Entity
@Table (name ="TIntervenciones")
@IdClass(IntervencionKey.class)
public class Intervencion  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minutos = 0;
	@Id
	@ManyToOne
	private Mecanico mecanico;
	@Id
	@ManyToOne
	private Averia averia;
	@OneToMany(mappedBy="intervencion")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();
	
	public Intervencion() {}

	public Intervencion(Mecanico mecanico, Averia averia) {
		this.mecanico = mecanico;
		this.averia = averia;
		averia._getIntervenciones().add( this );
		mecanico._getIntervenciones().add( this );
	}
	public void unlink(){
		averia._getIntervenciones().remove( this );
		mecanico._getIntervenciones().remove( this );
		this.mecanico = null;
		this.averia = null;
	}
	
	
	public Averia getAveria() {
		return averia;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	
	Set<Sustitucion> _getSustituciones(){
		return this.sustituciones;
	}
	public Set<Sustitucion> getSustituciones(){
		return Collections.unmodifiableSet(this.sustituciones);
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null)
				return false;
		} else if (!averia.equals(other.averia))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}
	public double getImporte() {
		// TODO Auto-generated method stub
		double importe = 0;
		double precio = this.averia.getVehiculo().getTipo().getPrecioHora();
		for(Sustitucion element : this.sustituciones)
			importe+=element.getImporte();
		
		importe += (minutos * (precio/60.0));
		return importe;
	}
	
}
