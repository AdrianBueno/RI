package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "TVehiculos")
public class Vehiculo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String matricula;
	private String marca;
	private String modelo;
	@Column( name="NUM_AVERIAS")
	private int numAverias;
	@ManyToOne
	private TipoVehiculo tipo;
	@ManyToOne
	private Cliente cliente;
	@OneToMany (mappedBy="vehiculo")
	private Set<Averia> averias = new HashSet<Averia>();
	
	Vehiculo(){}
	public Vehiculo(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Long getId() {
		return id;
	}

	void _addAveria(Averia averia){
		averia._setVehiculo(this);
		averias.add(averia);
		numAverias++;
	}
	public void removeAveria(Averia averia){
		averias.remove(averia);
		averia._setVehiculo(null);
		numAverias--;
	}
	public Set<Averia> getAverias(){
		return Collections.unmodifiableSet(this.averias);
	}

	void _setAverias(Set<Averia> averias) {
		this.averias = averias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	 void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoVehiculo getTipo(){
		return tipo;
	}

	void _setTipo(TipoVehiculo tVehiculo) {
		this.tipo = tVehiculo;
	}

	public String getMatricula() {
		return matricula;
	}
	void _setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	void _setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	void _setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumAverias() {
		return numAverias;
	}
	public void setNumAverias(int numAverias) {
		this.numAverias = numAverias;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
	
}
