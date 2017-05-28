package uo.ri.amp.common.factories;

import uo.ri.amp.common.io.input.InputData;
import uo.ri.amp.common.io.input.InputDataImpl;
import uo.ri.amp.common.io.output.PrinterData;
import uo.ri.amp.common.io.output.PrinterDataImpl;
import alb.util.log.Log;
import alb.util.log.Logger;

/**
 * @author Adrián
 * @version 1
 * Esta clase se encarga de desacoplar la implementación específica con la
 * interfaz usada en el sistema, para que, en caso de cambiar la impl, solo
 * se necesite recompilar esta clase.
 */
public class IoFactory {
	private IoFactory(){}
	public static InputData getInputData(){
		return InputDataImpl.getInstance();
	}
	public static PrinterData getPrinterData(){
		return PrinterDataImpl.getInstance(System.out,System.err);
	}
	public static Logger getLogger(){
		return Log.instance();
	}
}
