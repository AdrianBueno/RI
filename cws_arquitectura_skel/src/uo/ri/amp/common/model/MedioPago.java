package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "TMediosPago")
@Inheritance (strategy =  InheritanceType.SINGLE_TABLE)
public abstract class MedioPago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	protected Long id;
	protected double acumulado = 0.0;
	@ManyToOne
	protected Cliente cliente;
	
	@OneToMany (mappedBy="medioPago")
	protected Set<Cargo> cargos = new HashSet<Cargo>();
	
	public MedioPago(){}
	public MedioPago(Cliente client){client.addMedioPago(this);}
	public Set<Cargo> getCargos() {
		return Collections.unmodifiableSet(cargos);
	}
	Set<Cargo> _getCargos() {
		return cargos;
	}

	protected void _setCargos(Set<Cargo> cargos) {
		this.cargos = cargos;
	}
	protected void _setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public double getAcumulado() {
		this.calcularAcumulado();
		return acumulado;
	}
	public void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
	}
	public void calcularAcumulado(){
		for(Cargo cargo : cargos){
			this.acumulado +=cargo.getImporte();
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		MedioPago other = (MedioPago) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	

}
