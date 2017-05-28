package uo.ri.amp.common.factories;

import uo.ri.amp.business.asserts.CategoriasContratoAsserts;
import uo.ri.amp.business.asserts.ContratosAsserts;
import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.asserts.NominasAsserts;
import uo.ri.amp.business.asserts.TiposContratoAsserts;
import uo.ri.amp.business.asserts.impl.CategoriasContratoAssertsImpl;
import uo.ri.amp.business.asserts.impl.ContratosAssertsImpl;
import uo.ri.amp.business.asserts.impl.MecanicosAssertsImpl;
import uo.ri.amp.business.asserts.impl.NominasAssertsImpl;
import uo.ri.amp.business.asserts.impl.TiposContratoAssertsImpl;
/**Esta clase se encarga de desacoplar las interfaces de asertos usadas en la
 * capa de negocio de su implementación
 * uo.ri.amp.common.factories AssertsFactory
 * @version 1 22/12/2014
 * @author Adrián
 */
public class AssertsFactory {
	
	public static ContratosAsserts getContratosAsserts(){
		return new ContratosAssertsImpl();
	}

	public static TiposContratoAsserts getTiposContratoAsserts() {
		return new TiposContratoAssertsImpl();
	}

	public static MecanicosAsserts getMecanicosAsserts() {
		return new MecanicosAssertsImpl();
	}
	public static NominasAsserts getNominasAsserts(){
		return new NominasAssertsImpl();
	}

	public static CategoriasContratoAsserts getCategoriasContratoAssert() {
		return new CategoriasContratoAssertsImpl();
	}
}
