package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.common.model.types.AveriaStatus;
import alb.util.date.DateUtil;
@Entity
@Table (name = "TMecanicos")
public class Mecanico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String dni;//No está en el original
	private String nombre;
	private String apellidos;
	@OneToMany(mappedBy="mecanico")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
	@OneToMany(mappedBy="mecanico")
	private Set<Averia> averias = new HashSet<Averia>();
	@OneToMany(mappedBy="mecanico")
	private Set<Contrato> contratos = new HashSet<Contrato>();
	
	public Mecanico(){}
	public Mecanico(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}
	void _setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	//Métodos de asociación
	public void addAveria(Averia averia){
		averia._setMecanico(this);
		averias.add(averia);
	}
	public void removeAveria(Averia averia){
		averias.remove(averia);
		averia._setMecanico(null);
	}
	public Set<Averia> getAverias() {
		return Collections.unmodifiableSet(this.averias);
	}
	public Set<Averia> getAsignadas(){
		return Collections.unmodifiableSet(this.averias);
	}
	void _setAverias(Set<Averia> averias) {
		this.averias = averias;
	}
	public void addContrato(Contrato contrato){
		contrato.setMecanico(this);
		contratos.add(contrato);
	}
	public void removeContrato(Contrato contrato){
		contratos.remove(contrato);
		contrato.setMecanico(null);
	}
	public Set<Contrato> getContratos(){
		return Collections.unmodifiableSet(contratos);
	}
	void _setContratos(Set<Contrato> contratos){
		this.contratos = contratos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	Set<Intervencion> _getIntervenciones() {
		// TODO Auto-generated method stub
		return this.intervenciones;
	}
	public Set<Intervencion> getIntervenciones() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableSet(this.intervenciones);
	}
	/**Para obtener las intervenciones entre 2 fechas especificadas.
	 * @param inicio fecha de inicio
	 * @param fin fecha de fin
	 * @return Set con las intervenciones pedidas.
	 */
	public Set<Intervencion> getIntervenciones(Date inicio, Date fin){
		Set<Intervencion> intervenciones = new HashSet<Intervencion>();
		for(Intervencion i : this.intervenciones){
			if(i.getAveria().getStatus() != AveriaStatus.TERMINADA)
				continue;
			Date fecha =  i.getAveria().getFecha();
			if(DateUtil.isAfter(fecha, inicio) && DateUtil.isBefore(fecha, fin))
				intervenciones.add(i);
		}
		return intervenciones;
	}
	public double calcularBrutoAcumulado(Contrato contrato){
		if(this.contratos.contains(contrato)){
		 Double brutoAcumulado = 0.0;
		 for(Nomina nomina : contrato.getNominas()){
			 brutoAcumulado =+ nomina.getSalarioBruto();
		 }
		 return brutoAcumulado;
	 }
		return 0.0;
	}
	public Contrato getLastContrato(){
		Contrato lastContrato = new Contrato();
		lastContrato.setFechaInicio(DateUtil.fromString("1/1/1"));
		for(Contrato contrato : contratos){
			if(!DateUtil.isAfter(lastContrato.getFechaInicio(), contrato.getFechaInicio()))
				lastContrato = contrato;
		}
		return lastContrato;
	}
	
}
