package uo.ri.amp.common.model;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TTarjetasCredito")
public class TarjetaCredito extends MedioPago {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String numero;
	private Date validez;
	TarjetaCredito(){}
	public TarjetaCredito(Cliente cliente){
		super(cliente);
	}
	public TarjetaCredito(String string) {
		// TODO Auto-generated constructor stub
		this.numero = string;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getValidez() {
		return validez;
	}
	public void setValidez(Date validez) {
		this.validez = validez;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((validez == null) ? 0 : validez.hashCode());
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
		TarjetaCredito other = (TarjetaCredito) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (validez == null) {
			if (other.validez != null)
				return false;
		} else if (!validez.equals(other.validez))
			return false;
		return true;
	}
	
	
	
}
