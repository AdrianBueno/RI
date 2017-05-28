package uo.ri.amp.common.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.types.AveriaStatus;
import uo.ri.amp.common.model.types.FacturaStatus;
import alb.util.date.DateUtil;
import alb.util.math.Round;
@Entity
@Table (name ="TFacturas")
public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	//Campos naturales
	private long numero;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private double iva;
	private double importe;
	@Enumerated(EnumType.STRING)
	private FacturaStatus status;
	//Campos de asociación
	@OneToMany( mappedBy="factura")
	private Set<Averia> averias = new HashSet<Averia>();
	@OneToMany( mappedBy="factura")
	private Set<Cargo> cargos = new HashSet<Cargo>();
	
	Factura(){}
	
	public Factura(long numero) {
		super();
		this.numero = numero;
		this.fecha = new Date();
	}
	public Factura(long numero, Date fecha) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		setStatus(FacturaStatus.SIN_ABONAR);
	}
	
	public Factura(long numero, List<Averia> listAverias) throws BusinessException {
		this.numero = numero;
		this.averias = new HashSet<Averia>();
		this.fecha = new Date();
		for(Averia averia : listAverias){
			this.addAveria(averia);
		}
		setStatus(FacturaStatus.SIN_ABONAR);
	}
	public Factura(long numero, Date _15_6_2012, List<Averia> listAverias) throws BusinessException {
		// TODO Auto-generated constructor stub
		this.numero = numero;
		this.fecha = _15_6_2012;
		for(Averia averia : listAverias){
			this.addAveria(averia);
		}
		setStatus(FacturaStatus.SIN_ABONAR);
	}
	public Factura(long numero, Date fecha, double iva, double importe,
			FacturaStatus status) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.iva = iva;
		this.importe = importe;
		this.status = status;
	}
	
	
	public Long getId() {
		return id;
	}
	public long getNumero() {
		return numero;
	}
	void _setNumero(long numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getIva() {
		Date d = DateUtil.fromString("01/7/2012");
		if(fecha.after(d))
			iva=21;
		else
			iva=18;
		return iva;
	}
	void _setIva(double iva) {
		this.iva = iva;
	}
	public double getImporte() {
		this.importe = 0;
		for(Averia averia :averias)
			this.importe +=averia.getImporte();
		return Round.twoCents((importe*(100+getIva()))/100);
		//return importe + (importe*getIva());
	}
	void _setImporte(double importe) {
		this.importe = importe;
	}
	public FacturaStatus getStatus() {
		return status;
	}
	public void setStatus(FacturaStatus status) { //Puede cambiar?
		this.status = status;
	}
	
	//Métodos de asociación
	Set<Cargo> _getCargos() {
		return cargos;
	}
	public Set<Cargo> getCargos() {
		return Collections.unmodifiableSet(cargos);
	}
	public void addAveria(Averia averia) throws BusinessException{
		if(averia.getStatus() != AveriaStatus.TERMINADA)
			throw new BusinessException("");
		averia._setFactura(this);
		averias.add(averia);
	}
	public void removeAveria(Averia averia){
		averias.remove(averia);
		averia._setFactura(null);
	}
	public Set<Averia> getAverias(){
		return Collections.unmodifiableSet(averias);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
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
		Factura other = (Factura) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	
}
