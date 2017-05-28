package uo.ri.amp.common.io.output;

import java.io.PrintStream;
import java.util.List;

import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;

public abstract class PrinterData {
	protected static PrinterData instance;
	
	public abstract void printContratos(List<Contrato> contratos);
	public abstract void printContrato(Contrato contrato);
	public abstract void printMecanicos(List<Mecanico> mecanicos);
	public abstract void printMecanico(Mecanico mecanico);
	public abstract void printTiposContrato(List<TipoContrato> tiposContrato);
	public abstract void printTipoContrato(TipoContrato tipoContrato);
	public abstract void printCategoriasContrato(List<CategoriaContrato> categoriasContrato);
	public abstract void printCategoriaContrato(CategoriaContrato categoriaContrato);
	public abstract void printNominas(List<Nomina> nominas);
	public abstract void printNomina(Nomina nomina);
	public abstract void printNominaDetail(Nomina nomina);
	public abstract void print(String str);
	public abstract void printError(String str);
	public abstract void setErrPrintStream(PrintStream err);
	public abstract void setOutPrintStream(PrintStream printer);
}
