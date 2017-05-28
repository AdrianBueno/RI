package uo.ri.amp.common.io.input;

import java.util.Date;

import uo.ri.amp.common.exceptions.UiException;
/**
 * @author Adrián
 * Esta clase proporciona una interfaz para obtener los datos de forma correcta.
 * En caso de no obtener un dato de forma correcta generará una excepción.
 */
public interface InputData {
	//Métodos ID
	public Long getContratoId() throws UiException;
	public Long getMecanicoId() throws UiException;
	public Long getTipoContratoId() throws UiException;
	public Long getCategoriaContratoId() throws UiException;
	public Long getNominaId() throws UiException;
	//Metodos datos comunes
	public String getDni() throws UiException;
	public String getNombre() throws UiException;
	public String getApellidos() throws UiException;
	//Metodos datos 
	public Double getSalarioAnual() throws UiException;
	public Integer getDiasIndemnizacion() throws UiException;
	public Integer getYearNomina() throws UiException;
	public Integer getMonthNomina() throws UiException;
	//Métodos fecha
	public Date getFechaInicio() throws UiException;
	public Date getFechaFin() throws UiException;
	public Date getFechaNomina() throws UiException;
	

}
