package uo.ri.amp.common.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.amp.common.model.types.CargoKey;
@Entity
@Table (name = "TCargos")
@IdClass(CargoKey.class)
public class Cargo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Campos naturales
	private double importe;
	//Campos de asociaciones
	@Id
	@ManyToOne
	private MedioPago medioPago;
	@Id
	@ManyToOne
	private Factura factura;
	
	Cargo(){}
	public Cargo( Factura factura, MedioPago medioPago, double importe) {
		super();
		this.medioPago = medioPago;
		this.factura = factura;
		this.importe = importe;
		medioPago._getCargos().add(this);
		factura._getCargos().add(this);
	}
	public void unlink(){
		medioPago._getCargos().remove(this);
		factura._getCargos().remove(this);
		medioPago = null;
		factura = null;
	}
	public MedioPago getMedioPago() {
		return medioPago;
	}
	void _setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	public Factura getFactura() {
		return factura;
	}
	void _setFactura(Factura factura) {
		this.factura = factura;
	}
	public double getImporte() {
		return importe;
	}
	void _setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(importe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((medioPago == null) ? 0 : medioPago.hashCode());
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
		Cargo other = (Cargo) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (Double.doubleToLongBits(importe) != Double
				.doubleToLongBits(other.importe))
			return false;
		if (medioPago == null) {
			if (other.medioPago != null)
				return false;
		} else if (!medioPago.equals(other.medioPago))
			return false;
		return true;
	}
	
	
	
}
