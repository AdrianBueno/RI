package uo.ri.amp.common.io.input;

import java.util.Date;

import uo.ri.amp.common.exceptions.UiException;
import uo.ri.amp.common.factories.UtilFactory;
import uo.ri.amp.common.io.input.validators.Validator;
import uo.ri.amp.common.properties.UiStr;
import alb.util.console.Console;
import alb.util.date.DateUtil;
/**
 * @author Adrián García Bueno
 * Esta clase usa el patrón Singleton
 * En esta clase hago la implementación de la interfaz de entrada de datos.
 * Estos métodos tienen la única función de coordinar la entrada de datos
 * (Externalizada en Console.) con la validación de datos (Mediante la Clase
 * Validator y un patrón Strategy)
 * Se podría mejorar usando una interfaz para acceder a la clase que proporciona
 * las cadenas de entrada y error UiStr.
 * Esta clase solo debería estar instanciada una vez en toda la aplicación.
 * De esta manera solo hay un acceso al properties por variable.
 */
public class InputDataImpl implements InputData {
	private  String errorId = UiStr.getStr("ERROR.ID");
	private  String errorDni = UiStr.getStr("ERROR.DNI");
	private  String errorNombre = UiStr.getStr("ERROR.NOMBRE");
	private  String errorApellidos = UiStr.getStr("ERROR.APELLIDOS");
	private  String errorNumero = UiStr.getStr("ERROR.NUMERO");
	private  String errorFecha = UiStr.getStr("ERROR.FECHA");
	
	private  String inputIdContrato = UiStr.getStr("IN.ID_CONTRATO");
	private  String inputIdMecanico = UiStr.getStr("IN.ID_MECANICO");
	private  String inputIdTipo = UiStr.getStr("IN.ID_TIPO");
	private  String inputIdCategoria = UiStr.getStr("IN.ID_CATEGORIA");
	private  String inputIdNomina = UiStr.getStr("IN.ID_NOMINA");
	
	private  String inputDni = UiStr.getStr("IN.DNI");
	private  String inputNombre = UiStr.getStr("IN.NOMBRE");
	private  String inputApellidos = UiStr.getStr("IN.APELLIDOS");
	
	private  String inputSalario = UiStr.getStr("IN.SALARIO");
	private  String inputDiasIndemnizacion = UiStr.getStr("IN.DIAS_INDEM");
	private  String inputAño = UiStr.getStr("IN.AÑO");
	private  String inputMes = UiStr.getStr("IN.MES");
	
	private  String inputFechaInicio = UiStr.getStr("IN.INICIO");
	private  String inputFechaFin = UiStr.getStr("IN.FIN");
	
	private Validator validator; //Patrón Strategy
	
	//Constructor privado para el singleton
	private InputDataImpl(){}
	
	private static InputDataImpl instance;
	public static InputData getInstance(){
		if(instance == null)
			instance = new InputDataImpl();
		return instance;
	}
	
	@Override
	public Long getContratoId() throws UiException {
		Long id = Console.readLong(inputIdContrato);
		if(id == null)
			throw new UiException(errorId);
		return id;
	}
	@Override
	public Long getMecanicoId() throws UiException {
		Long id = Console.readLong(inputIdMecanico);
		if(id == null)
			throw new UiException(errorId);
		return id;
	}
	@Override
	public Long getTipoContratoId() throws UiException {
		Long id = Console.readLong(inputIdTipo);
		if(id == null)
			throw new UiException(errorId);
		return id;
	}

	@Override
	public Long getCategoriaContratoId() throws UiException {
		Long id = Console.readLong(inputIdCategoria);
		if(id == null)
			throw new UiException(errorId);
		return id;
	}

	@Override
	public Long getNominaId() throws UiException {
		Long id = Console.readLong(inputIdNomina);
		if(id == null)
			throw new UiException(errorId);
		return id;
	}

	@Override
	public String getDni() throws UiException {
		String dni = Console.readString(inputDni);
		validator = UtilFactory.getValidatorDni();
		if(!validator.validate(dni))
			throw new  UiException(errorDni);
		return dni;
	}

	@Override
	public String getNombre() throws UiException {
		String nombre = Console.readString(inputNombre);
		validator = UtilFactory.getValidatorNombre();
		if(!validator.validate(nombre))
			throw new  UiException(errorNombre);
		return nombre;
	}

	@Override
	public String getApellidos() throws UiException {
		String apellidos = Console.readString(inputApellidos);
		validator = UtilFactory.getValidatorApellidos();
		if(!validator.validate(apellidos))
			throw new  UiException(errorApellidos);
		return apellidos;
	}

	@Override
	public Double getSalarioAnual() throws UiException {
		Double salarioAnual = Console.readDouble(inputSalario);
		validator = UtilFactory.getValidatorSalario();
		if(!validator.validate(salarioAnual.toString()))
			throw new UiException(errorNumero);
		return salarioAnual;
	}

	@Override
	public Integer getDiasIndemnizacion() throws UiException {
		Integer diasIndemnizacion = Console.readInt(inputDiasIndemnizacion);
		if(diasIndemnizacion == null)
			throw new UiException(errorNumero);
		return diasIndemnizacion;
	}

	@Override
	public Integer getYearNomina() throws UiException {
		Integer var = Console.readInt(inputAño);
		validator = UtilFactory.getValidatorAño();
		if(!validator.validate(var.toString()))
			throw new UiException(errorNumero);
		return var;
	}

	@Override
	public Integer getMonthNomina() throws UiException {
		Integer var = Console.readInt(inputMes);
		validator = UtilFactory.getValidatorMes();
		if(validator.validate(var.toString()))
			throw new UiException(errorNumero);
		return var;
	}

	@Override
	public Date getFechaInicio() throws UiException {
		String fecha = Console.readString(inputFechaInicio);
		validator = UtilFactory.getValidatorFecha();
		if(!validator.validate(fecha))
			throw new UiException(errorFecha);
		return DateUtil.fromString(fecha);
	}

	@Override
	public Date getFechaFin() throws UiException {
		String fecha = 	Console.readString(inputFechaFin);
		if(fecha.trim().equals(""))
			return null;
		else{
			validator = UtilFactory.getValidatorFecha();
			if(!validator.validate(fecha))
				throw new UiException(errorFecha);
			return DateUtil.fromString(fecha);
		}
	}

	@Override
	public Date getFechaNomina() throws UiException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
