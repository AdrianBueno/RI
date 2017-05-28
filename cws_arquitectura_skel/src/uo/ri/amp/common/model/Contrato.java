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

import uo.ri.amp.common.model.types.ContratoStatus;
import alb.util.date.DateUtil;
@Entity
@Table (name = "TContratos")
public class Contrato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private Double salarioBaseAnual;
	private Double importeLiquidacion;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	@Temporal(TemporalType.DATE)
	private Date fechaLiquidacion;
	@Enumerated(EnumType.STRING)
	private ContratoStatus estado;
	@OneToMany(mappedBy="contrato")
	private Set<Nomina> nominas = new HashSet<Nomina>();
	@ManyToOne
	private Mecanico mecanico;
	@ManyToOne
	private TipoContrato tipoContrato;
	@ManyToOne
	private CategoriaContrato categoriaContrato;
	
	public Contrato(){}
	public Contrato(Double salarioBaseAnual,Date fechaInicio, Date fechaFin){
		this.salarioBaseAnual = salarioBaseAnual;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		setEstado(ContratoStatus.ACTIVO);
	}
	public Contrato(Double salarioBaseAnual,Date fechaInicio){
		this.salarioBaseAnual = salarioBaseAnual;
		this.fechaInicio = fechaInicio;
		setEstado(ContratoStatus.ACTIVO);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSalarioBaseAnual() {
		return salarioBaseAnual;
	}
	public void setSalarioBaseAnual(Double salarioBaseAnual) {
		this.salarioBaseAnual = salarioBaseAnual;
	}
	public Double getImporteLiquidacion() {
		return importeLiquidacion;
	}
	public void setImporteLiquidacion(Double importeLiquidacion) {
		this.importeLiquidacion = importeLiquidacion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	public ContratoStatus getEstado() {
		return estado;
	}
	public void setEstado(ContratoStatus estado) {
		this.estado = estado;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public CategoriaContrato getCategoriaContrato() {
		return categoriaContrato;
	}
	public void setCategoriaContrato(CategoriaContrato categoria) {
		this.categoriaContrato = categoria;
	}
	public void addNomina(Nomina nomina){
		nomina.setContrato(this);
		nominas.add(nomina);
	}
	public void removeNomina(Nomina nomina){
		nominas.remove(nomina);
		nomina.setContrato(null);
	}
	public Set<Nomina> getNominas(){
		return Collections.unmodifiableSet(nominas);
	}
	void _setNominas(Set<Nomina> nominas){
		this.nominas = nominas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Contrato other = (Contrato) obj;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}
	 
	 public Double getSalarioBrutoAnual(Date fecha){
		 Double brutoAnual = salarioBaseAnual; //Las 14 pagas.
		 fecha = DateUtil.setFirstDayOfMonth(fecha);
		 double diff = 0.0; //Diferencia entre el neto y el bruto
		 for(int i = 1; i <= 12; i++){
			 Nomina nomina = existNomina(fecha);
			 if(nomina != null){ //si la nómina existe acumulo su diferencia
				 diff += nomina.getSalarioBruto() 
						 - nomina.getSalarioBase() 
						 - nomina.getPagoExtra();
			 }else //Si no existe la estimo.
				diff += diff/i;
			 fecha = DateUtil.subMonths(fecha,1);
		 }
		 return brutoAnual+diff;
	 }
	 public Nomina generarNomina(Date fechaNomina){
		 fechaNomina = DateUtil.setFirstDayOfMonth(fechaNomina);
		 if(existNomina(fechaNomina) == null)
			 return new Nomina(fechaNomina,this);
		 throw new IllegalStateException("La nómina ya existe");
	 }

	/**
	 * Método finalizar contrato.
	 * Lógica de dominio
	 */
	 public void finalizeContrato(){
		 Date fechaFin = DateUtil.setLastDayOfMonth(DateUtil.today());
		 setEstado(ContratoStatus.EXTINTO);
		 setFechaFin(fechaFin);
		 if(nominas.size() >= 12){
			 setFechaLiquidacion(fechaFin);
			 setImporteLiquidacion(calcularLiquidacion());
		 }
	 }
	 private double calcularLiquidacion(){
		Double brutoAcumulado = getSalarioBrutoAnual(DateUtil.today());
		int dias = getTipoContrato().getDiasIndemnizacion();
		int años = nominas.size()/12;
		return (brutoAcumulado / 365)* dias * años;
	 }
	public Nomina existNomina(Date inicio) {
		for(Nomina nomina : nominas){
			if(nomina.getFecha().compareTo(inicio) == 0)
				return nomina;
		}
		return null;
	}
}
