package uo.ri.amp.common.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TMetalico")
public class Metalico extends MedioPago {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Metalico(){}
	public Metalico(Cliente cliente) {
		super(cliente);
	}
	
	
	
	
}
