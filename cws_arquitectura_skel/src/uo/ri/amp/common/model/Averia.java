package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.common.model.types.AveriaStatus;
@Entity
@Table(name = "TAverias")
public class Averia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	//Campos naturales
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Double importe; 
	@Enumerated(EnumType.STRING)
	private AveriaStatus status;
	//Campos de asociación
	@ManyToOne
	private Vehiculo vehiculo;
	@ManyToOne
	private Mecanico mecanico;
	@ManyToOne
	private Factura factura;
	@OneToMany(mappedBy="averia")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
	
	Averia(){}
	public Averia(Vehiculo vehiculo,String descripcion ) {
		this.descripcion = descripcion;
		fecha = new Date();
		vehiculo._addAveria(this);
		setStatus(AveriaStatus.ABIERTA);
	}
	
	public Long getId() {
		return id;
	}
	//Métodos naturales
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getImporte() {
		calcularImporte();
		return importe;
	}
	void _setImporte(Double importe) {
		this.importe = importe;
	}
	public AveriaStatus getStatus() {
		return status;
	}
	public void setStatus(AveriaStatus status) {
		this.status = status;
	}
	public void calcularImporte() {
		// TODO Auto-generated method stub
		this.importe = 0.0;
		for(Intervencion element : this.intervenciones){
			this.importe += element.getImporte();
		}
		setStatus(AveriaStatus.TERMINADA);
	}
	
	// Métodos de asociación
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	void _setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
		setStatus(AveriaStatus.ASIGNADA);
	}
	public Factura getFactura() {
		return factura;
	}
	void _setFactura(Factura factura) {
		if(factura != null)
			setStatus(AveriaStatus.FACTURADA);
		this.factura = factura;
	}
	Set<Intervencion> _getIntervenciones() {//Será llamado desde intervenciones
		// TODO Auto-generated method stub
		return intervenciones;
	}
	public Set<Intervencion> getIntervenciones() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableSet(intervenciones);
	}
	
	//Métodos sobreescritos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Averia other = (Averia) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	
	
	

	
}
