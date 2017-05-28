package uo.ri.amp.common.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TBonos")
public class Bono extends MedioPago {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double disponible;
	private String codigo;
	Bono(){}


	public Bono(Cliente cliente, String string, double d) {
		// TODO Auto-generated constructor stub
		super(cliente);
		this.codigo = string;
		this.disponible = d;	
	}

	public double getDisponible() {
		return disponible;
	}
	void _setDisponible(double disponible) {
		this.disponible = disponible;
	}
	public String getCodigo() {
		return codigo;
	}
	void _setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bono other = (Bono) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
