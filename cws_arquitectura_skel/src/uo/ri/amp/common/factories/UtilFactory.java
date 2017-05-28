package uo.ri.amp.common.factories;

import uo.ri.amp.common.io.input.validators.Validator;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoApellidos;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoAño;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoDni;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoFecha;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoMes;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoNombre;
import uo.ri.amp.common.io.input.validators.ValidatorGenericoSalarioAnual;
import uo.ri.amp.common.io.output.format.CategoriaContratoFormat;
import uo.ri.amp.common.io.output.format.ContratoFormat;
import uo.ri.amp.common.io.output.format.MecanicoFormat;
import uo.ri.amp.common.io.output.format.NominaFormat;
import uo.ri.amp.common.io.output.format.TipoContratoFormat;
import uo.ri.amp.common.io.output.format.impl.CategoriaContratoFormatImpl;
import uo.ri.amp.common.io.output.format.impl.ContratoFormatImpl;
import uo.ri.amp.common.io.output.format.impl.MecanicoFormatImpl;
import uo.ri.amp.common.io.output.format.impl.NominaFormatDetail;
import uo.ri.amp.common.io.output.format.impl.NominaFormatGeneric;
import uo.ri.amp.common.io.output.format.impl.TipoContratoFormatImpl;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.common.model.util.Calculador;
import uo.ri.amp.common.model.util.CalculadorIRPF;
import uo.ri.amp.common.model.util.CalculadorImporteAverias;
import uo.ri.amp.common.model.util.CalculadorPagaExtra;
/**
 * @author Admin
 * @version 1
 * Esta clase se encaga de proveer una implementación a las interfaces
 * de cietos elementos usados en la capa de negocio, o en el modelo de dominio.
 */
public class UtilFactory {
	private UtilFactory(){}
	public static Calculador getCalculadorPagaExtra() {
		return new CalculadorPagaExtra();
	}

	public static Calculador getCalculadorImporteAverias() {
		return new CalculadorImporteAverias();
	}

	public static Calculador getCalculadorIrpf() {
		return new CalculadorIRPF();
	}
	
	public static Validator getValidatorDni(){
		return new ValidatorGenericoDni();
	}
	public static Validator getValidatorNombre() {
		return new ValidatorGenericoNombre();
	}
	public static Validator getValidatorApellidos() {
		return new ValidatorGenericoApellidos();
	}
	public static Validator getValidatorSalario() {
		return new ValidatorGenericoSalarioAnual();
	}
	public static Validator getValidatorAño() {
		return new ValidatorGenericoAño();
	}
	public static Validator getValidatorMes() {
		return new ValidatorGenericoMes();
	}
	public static Validator getValidatorFecha() {
		return new ValidatorGenericoFecha();
	}
	public static ContratoFormat getContratoFormat(Contrato contrato){
		return new ContratoFormatImpl(contrato);
	}
	public static MecanicoFormat getMecanicoFormat(Mecanico mecanico){
		return new MecanicoFormatImpl(mecanico);
	}
	public static TipoContratoFormat getTipoContratoFormat(TipoContrato tipo){
		return new TipoContratoFormatImpl(tipo);
	}
	public static CategoriaContratoFormat getCategoriaContratoFormat(CategoriaContrato categoria){
		return new CategoriaContratoFormatImpl(categoria);
	}
	public static NominaFormat getNominaFormatDetail(Nomina nomina){
		return new NominaFormatDetail(nomina);
	}
	public static NominaFormat getNominaFormatGeneric(Nomina nomina){
		return new NominaFormatGeneric(nomina);
	}
}
