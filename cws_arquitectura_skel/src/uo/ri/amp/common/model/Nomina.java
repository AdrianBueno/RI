package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import alb.util.date.DateUtil;
import uo.ri.amp.common.factories.UtilFactory;
import uo.ri.amp.common.model.util.Calculador;
@Entity
@Table (name = "TNominas")
public class Nomina implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private double salarioBase;
	private double salarioBruto;
	private double salarioNeto;
	private double pagoExtra;
	private double plusProductividad;
	private double trienios;
	private double descuentoIrpf;
	private double descuentoSS;
	@ManyToOne
	private Contrato contrato;
	
	public Nomina(){}
	
	public Nomina(Date fecha, Contrato contrato){
		setFecha(fecha);
		contrato.addNomina(this);
		calcularSalarioBase();
		calcularPagaExtra();
		calcularTrienios();
		calcularPlusProductividad();
		calcularBruto();
		calcularIrpf();
		calcularSs();
		calcularNeto();
	}
	public Nomina(Date fecha, double salarioBase, double salarioBruto,
			double salarioNeto, double pagoExtra, double plusProductividad,
			double trienios, double descuentoIrpf, double descuentoSS) {
		super();
		this.fecha = fecha;
		this.salarioBase = salarioBase;
		this.salarioBruto = salarioBruto;
		this.salarioNeto = salarioNeto;
		this.pagoExtra = pagoExtra;
		this.plusProductividad = plusProductividad;
		this.trienios = trienios;
		this.descuentoIrpf = descuentoIrpf;
		this.descuentoSS = descuentoSS;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public double getSalarioNeto() {
		return salarioNeto;
	}
	public void setSalarioNeto(double salarioNeto) {
		this.salarioNeto = salarioNeto;
	}
	public double getPagoExtra() {
		return pagoExtra;
	}
	public void setPagoExtra(double pagoExtra) {
		this.pagoExtra = pagoExtra;
	}
	public double getPlusProductividad() {
		return plusProductividad;
	}
	public void setPlusProductividad(double plusProductividad) {
		this.plusProductividad = plusProductividad;
	}
	public double getTrienios() {
		return trienios;
	}
	public void setTrienios(double trienios) {
		this.trienios = trienios;
	}
	public double getDescuentoIrpf() {
		return descuentoIrpf;
	}
	public void setDescuentoIrpf(double descuentoIrpf) {
		this.descuentoIrpf = descuentoIrpf;
	}
	public double getDescuentoSS() {
		return descuentoSS;
	}
	public void setDescuentoSS(double descuentoSS) {
		this.descuentoSS = descuentoSS;
	}
	public Contrato getContrato(){
		return contrato;
	}
	public void setContrato(Contrato contrato){
		this.contrato = contrato;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contrato == null) ? 0 : contrato.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Nomina other = (Nomina) obj;
		if (contrato == null) {
			if (other.contrato != null)
				return false;
		} else if (!contrato.equals(other.contrato))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	
	private void calcularSalarioBase(){
		setSalarioBase(contrato.getSalarioBaseAnual()/14);
	}
	private void calcularPagaExtra(){
		Calculador cPagaExtra = UtilFactory.getCalculadorPagaExtra();
		Double pagaExtra = cPagaExtra.calcular(getSalarioBase(),getFecha());
		setPagoExtra(pagaExtra);
	}
	private void calcularPlusProductividad(){
		double plusProd =contrato.getCategoriaContrato().getPlusProductividad();
		double importeAverias =calcularImporteAverias();
		setPlusProductividad(plusProd*importeAverias);
	}
	private double calcularImporteAverias(){
		Mecanico mecanico = contrato.getMecanico();
		Calculador cImportes = UtilFactory.getCalculadorImporteAverias();
		Date fin = DateUtil.subMonths(getFecha(),1);
		Date inicio = DateUtil.subDays(fin, 365);
		return cImportes.calcular(mecanico,inicio,fin);
	}
	private void calcularTrienios(){
		int años = contrato.getNominas().size()/12;
		double importe = contrato.getCategoriaContrato().getImporteTrienios();
		setTrienios(importe * (años/3));
	}
	private void calcularBruto(){
		Double bruto = getSalarioBase()
				+getPlusProductividad()
				+getTrienios()
				+getPagoExtra();
		setSalarioBruto(bruto);
	}
	private void calcularIrpf(){
		Calculador cIrpf = UtilFactory.getCalculadorIrpf();
		double brutoAnual = contrato.getSalarioBrutoAnual(getFecha());
		double baseMensual = getSalarioBase();
		double irpf = cIrpf.calcular(baseMensual,brutoAnual);
		setDescuentoIrpf(irpf);
	}
	private void calcularSs(){
		double ss = getSalarioBase()*0.05 + getPagoExtra()*0.05;
		setDescuentoSS(ss);
	}
	private void calcularNeto(){
		double neto = getSalarioBruto() 
				- getDescuentoIrpf() 
				- getDescuentoSS();
		setSalarioNeto(neto);
	}

	
	
	
}
