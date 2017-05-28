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
@Table (name = "TCategorias")
public class CategoriaContrato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private double importeTrienios;
	private double plusProductividad;
	@OneToMany (mappedBy = "categoriaContrato")
	private Set<Contrato> contratos = new HashSet<Contrato>();
	
	public CategoriaContrato(){}
	
	public CategoriaContrato(String nombre, double importeTrienios,
			double plusProductividad) {
		super();
		this.nombre = nombre;
		this.importeTrienios = importeTrienios;
		this.plusProductividad = plusProductividad;
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
	public double getImporteTrienios() {
		return importeTrienios;
	}
	public void setImporteTrienios(double importeTrienios) {
		this.importeTrienios = importeTrienios;
	}
	public double getPlusProductividad() {
		return plusProductividad;
	}
	public void setPlusProductividad(double plusProductividad) {
		this.plusProductividad = plusProductividad;
	}

	public void addContrato(Contrato contrato){
		contrato.setCategoriaContrato(this);
		contratos.add(contrato);
	}
	public void removeContrato(Contrato contrato){
		contratos.remove(contrato);
		contrato.setCategoriaContrato(null);
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
		CategoriaContrato other = (CategoriaContrato) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
}
