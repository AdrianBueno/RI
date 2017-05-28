package uo.ri.amp.common.io.output;

import java.io.PrintStream;
import java.util.List;

import uo.ri.amp.common.factories.UtilFactory;
import uo.ri.amp.common.io.output.format.CategoriaContratoFormat;
import uo.ri.amp.common.io.output.format.ContratoFormat;
import uo.ri.amp.common.io.output.format.MecanicoFormat;
import uo.ri.amp.common.io.output.format.NominaFormat;
import uo.ri.amp.common.io.output.format.TipoContratoFormat;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.common.properties.UiStr;

public class PrinterDataImpl extends PrinterData {
	private PrinterDataImpl(){}
	private PrintStream out;
	private PrintStream err;
	public static PrinterData getInstance(PrintStream out,PrintStream err) {
		if(instance == null){
			instance = new PrinterDataImpl();
			instance.setOutPrintStream(out);
			instance.setErrPrintStream(err);
		}
		return instance;
	}
	@Override
	public void printContratos(List<Contrato> contratos) {
		for(Contrato contrato : contratos){
			printContrato(contrato);
		}
	}

	@Override
	public void printContrato(Contrato contrato) {
		ContratoFormat format = UtilFactory.getContratoFormat(contrato);
		out.print(format.getFormattedData());
		printMecanico(contrato.getMecanico());
		printTipoContrato(contrato.getTipoContrato());
		printCategoriaContrato(contrato.getCategoriaContrato());
	}

	@Override
	public void printMecanicos(List<Mecanico> mecanicos) {
		for(Mecanico mecanico : mecanicos){
			printMecanico(mecanico);
		}
	}

	@Override
	public void printMecanico(Mecanico mecanico) {
		MecanicoFormat format = UtilFactory.getMecanicoFormat(mecanico);
		out.println(format.getFormattedData());
	}

	@Override
	public void printTiposContrato(List<TipoContrato> tiposContrato) {
		for(TipoContrato tipo : tiposContrato)
			printTipoContrato(tipo);
	}

	@Override
	public void printTipoContrato(TipoContrato tipoContrato) {
		TipoContratoFormat format = 
				UtilFactory.getTipoContratoFormat(tipoContrato);
		out.println(format.getFormattedData());
		
	}

	@Override
	public void printCategoriasContrato(
			List<CategoriaContrato> categoriasContrato) {
		for(CategoriaContrato categoria :categoriasContrato)
			printCategoriaContrato(categoria);
	}

	@Override
	public void printCategoriaContrato(CategoriaContrato categoriaContrato) {
		CategoriaContratoFormat format = 
				UtilFactory.getCategoriaContratoFormat(categoriaContrato);
		out.println(format.getFormattedData());
		
	}

	@Override
	public void printNominas(List<Nomina> nominas) {
		for(Nomina nomina :nominas)
			printNomina(nomina);
	}

	@Override
	public void printNomina(Nomina nomina) {
		NominaFormat format = UtilFactory.getNominaFormatGeneric(nomina);
		out.println(format.getFormattedData());
	}
	@Override
	public void printNominaDetail(Nomina nomina){
		NominaFormat format = UtilFactory.getNominaFormatDetail(nomina);
		out.println(format.getFormattedData());
	}
	@Override
	public void printError(String str){
		this.err.println(UiStr.getStr("ERROR.BASE")+" "+str);
	}
	@Override
	public void print(String str) {
		this.out.println(str);
	}
	@Override
	public void setOutPrintStream(PrintStream out) {
		this.out = out;
	}
	@Override
	public void setErrPrintStream(PrintStream err) {
		this.err = err;
	}

}
