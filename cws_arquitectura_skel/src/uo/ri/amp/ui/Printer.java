package uo.ri.amp.ui;

import java.util.Calendar;
import java.util.List;

import uo.ri.amp.common.model.Averia;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Factura;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.MedioPago;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.common.model.types.ContratoStatus;
import alb.util.console.Console;
/**
 * 
 * @author Adrián García Bueno (Extensión)
 * @author ?
 * Externalizo la impresión de varios tipos de datos, me ahorra código en la capa ui y mejora la legibilidad.
 * Esta clase está obsoleta y no se usa
 */
@Deprecated
public class Printer {
	private Printer(){}
	
	public static void printContratos(List<Contrato> contratos){
		for(Contrato contrato : contratos){
			Console.println("Contrado: "+contrato.getId());
			Console.println("Mecanico: 		ID: "+contrato.getMecanico().getId()+" Nombre: "+contrato.getMecanico().getDni());
			Console.println("TipoContrato: 	ID:"+contrato.getTipoContrato().getId()+" Nombre: "+contrato.getTipoContrato().getNombre());
			Console.println("Salario Anual Base: "+contrato.getSalarioBaseAnual());
			Console.println("Fecha inicio: "+contrato.getFechaInicio());
			if(contrato.getFechaFin() != null)
				Console.println("Fecha fin: "+contrato.getFechaFin());
			Console.println("Estado: "+contrato.getEstado());
			if(contrato.getEstado() == ContratoStatus.EXTINTO){
				Console.println("Fecha Liquidación: "+contrato.getFechaLiquidacion());
				Console.println("Importe Liquidación: "+contrato.getImporteLiquidacion());
			}
		}
	}
	public static void printNominas(List<Nomina> listNominasByMecanico) {
		for(Nomina nomina :listNominasByMecanico){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(nomina.getFecha());
			Console.printf("Año: %-4.4d Mes: %-4.4d", calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
			Console.println();
			Console.println("Neto: "+nomina.getSalarioNeto());
			Console.println();
		}
		
	}
	public static void printMecanicos(List<Mecanico> mecanicos){
		for(Mecanico mecanico : mecanicos){
			printMechanic(mecanico);
			Console.println();
		}
	}
	public static void printTiposContrato(List<TipoContrato> tiposContrato){
		for(TipoContrato tipo :tiposContrato){
			printTipoContrato(tipo);
		}
	}
	public static void printNominaDetail(Nomina nomina){
		Console.println();
		Console.print("Fecha: "+nomina.getFecha());
		Console.println();
		Console.println("Detalles --------------------------------");
		Console.println("		Bruto: "+nomina.getSalarioBruto());
		Console.println("	 	 Neto: "+nomina.getSalarioNeto());
		Console.println("Desglose --------------------------------");
		Console.println("	 Productividad: "+nomina.getPlusProductividad());
		Console.println("		Paga extra: "+nomina.getPagoExtra());
		Console.println("	  	  Trienios: "+nomina.getTrienios());
		Console.println("		  	  IRPF: -"+nomina.getDescuentoIrpf());
		Console.println("Seguridad Sociaul: -"+nomina.getDescuentoSS());
		Console.println();
	}
	
	public static void printInvoice(Factura invoice) {

		double importeConIVa = invoice.getImporte();
		double iva =  (Double) invoice.getIva();
		double importeSinIva = importeConIVa / (1 + iva / 100);

		Console.printf("Factura nÂº: %d\n", 				invoice.getNumero() );
		Console.printf("\tFecha: %1$td/%1$tm/%1$tY\n", 	invoice.getFecha());
		Console.printf("\tTotal: %.2f â‚¬\n", 			importeSinIva);
		Console.printf("\tIva: %.1f %% \n", 			invoice.getIva() );
		Console.printf("\tTotal con IVA: %.2f â‚¬\n", 	invoice.getImporte() );
		Console.printf("\tEstado: %s\n", 				invoice.getStatus() );
	}

	public static void printPaymentMeans(List<MedioPago> medios) {
		Console.println();
		Console.println("Medios de pago disponibles");
		
		Console.printf("\t%s \t%-8.8s \t%s \n", "ID", "Tipo", "Acumulado");
		for (MedioPago medio : medios) {
			Console.println( medio.toString() );
		}
	}

	public static void printRepairing(Averia rep) {
		
		Console.printf("\t%d \t%-40.40s \t%td/%<tm/%<tY \t%-12.12s \t%.2f\n",  
				rep.getId()
				, rep.getDescripcion() 
				, rep.getFecha()
				, rep.getStatus()
				, rep.getImporte()
		);
	}

	public static void printMechanic(Mecanico m) {
		Console.printf("\t%d %-10.10s %-25.25s %-25.25s\n",  
				m.getId()
				, m.getDni()
				, m.getNombre()
				, m.getApellidos()
			);
	}
	public static void printTipoContrato(TipoContrato tipo){
		Console.printf("\tID: %d \t Nombre: %-10.10s \t Dias_Indemnizacion: %d", tipo.getId(),tipo.getNombre(),tipo.getDiasIndemnizacion());
		Console.println();
	}

	

}
