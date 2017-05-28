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
@Table (name = "TTiposContrato")
public class TipoContrato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private int diasIndemnizacion;
	@OneToMany(mappedBy = "tipoContrato")
	private Set<Contrato> contratos = new HashSet<Contrato>();
	
	public TipoContrato(){}
	public TipoContrato(String nombre, Integer diasIndemnizacion){
		this.nombre = nombre;
		this.diasIndemnizacion = diasIndemnizacion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDiasIndemnizacion() {
		return diasIndemnizacion;
	}
	public void setDiasIndemnizacion(int diasIndemnizacion) {
		this.diasIndemnizacion = diasIndemnizacion;
	}
	public void addContrato(Contrato contrato){
		contrato.setTipoContrato(this);
		contratos.add(contrato);
	}
	public void removeContrato(Contrato contrato){
		contratos.remove(contrato);
		contrato.setTipoContrato(null);
	}
	public Set<Contrato> getContratos() {
		return Collections.unmodifiableSet(contratos);
	}

	void _setContratos(Set<Contrato> contratos) {
		this.contratos = contratos;
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
		TipoContrato other = (TipoContrato) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
