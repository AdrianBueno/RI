package uo.ri.amp.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.amp.common.model.types.SustitucionKey;

@Entity
@Table (name = "TSustituciones")
@IdClass(SustitucionKey.class)
public class Sustitucion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantidad = 0;
	@Id @ManyToOne private Intervencion intervencion;
	@Id @ManyToOne private Repuesto repuesto;
	Sustitucion(){}
	public Sustitucion(Repuesto repuesto,Intervencion intervencion) {
		this.intervencion = intervencion;
		this.repuesto = repuesto;
		this.intervencion._getSustituciones().add(this);
		this.repuesto._getSustituciones().add(this);
	}
	public void unlink(){
		this.intervencion._getSustituciones().remove(this);
		this.repuesto._getSustituciones().remove(this);
		this.intervencion = null;
		this.repuesto = null;
	}

	
	public Intervencion getIntervencion() {
		return intervencion;
	}
	public void setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}
	public Repuesto getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getImporte(){
		return getCantidad() * this.repuesto.getPrecio();
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((intervencion == null) ? 0 : intervencion.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
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
		Sustitucion other = (Sustitucion) obj;
		if (intervencion == null) {
			if (other.intervencion != null)
				return false;
		} else if (!intervencion.equals(other.intervencion))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}

	
}
