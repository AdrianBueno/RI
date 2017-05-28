package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.types.ContratoStatus;
import uo.ri.amp.persistence.util.Jpa;
/**
 * @author Adrián García Bueno
 * Esta clase se encarga de acceder a los contratos del modelo de dominio
 */
public class ContratoFinder {
	private ContratoFinder(){}
	/**Devuelve un contrato a partir de un identificador
	 * @param idContrato identificador del contrato
	 * @return Contrato objeto contrato.
	 */
	public static Contrato findContratoById(Long idContrato){
		return Jpa.getManager().find(Contrato.class, idContrato);
	}
	/**Contrato activo de un mecánico dado
	 * @param idMecanico identificador del mecanico
	 * @return Contrato objeto contrato.
	 */
	public static Contrato findContratoActive(Long idMecanico){
		List<Contrato> list =  Jpa.getManager()
		.createNamedQuery("Contrato.findEstado",Contrato.class)
		.setParameter(1, idMecanico)
		.setParameter(2,ContratoStatus.ACTIVO)
		.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**Devuelve una lista de contratos activos
	 * @return List<Contrato> lista con contratos activos.
	 */
	public static List<Contrato> findContratosActive(){
		return Jpa.getManager()
		.createNamedQuery("Contrato.findAllActive",Contrato.class)
		.getResultList();
	}
	/**Devuelve todos los contratos del sistema en una lista
	 * @return List<Contraot> lista con los contratos del sitema
	 */
	public static List<Contrato> findContratosAll(){
		return Jpa.getManager()
		.createNamedQuery("Contrato.findAll",Contrato.class)
		.getResultList();
	}
	/**Lista con los contratos de un tipo de contrato
	 * @param id identificador del tipo de contrato
	 * @return List<Contrato> lista con los tipos de contrato.
	 */
	public static List<Contrato> findContratosByTipoContrato(Long id){
		return Jpa.getManager()
		.createNamedQuery("Contrato.findByTipoContrato",Contrato.class)
		.setParameter(1, id)
		.getResultList();
	}
	/**Lista con los contratos de una categoria de contrato
	 * @param id identificador de la categoria de contrato
	 * @return List<Contrato> Lista con los contratos de la categoria dada.
	 */
	public static List<Contrato> findContratosByCategoriaContrato(Long id){
		return Jpa.getManager()
		.createNamedQuery("Contrato.findByCategoriaContrato",Contrato.class)
		.setParameter(1, id)
		.getResultList();
	}
	/**Lista todos los contratos de un mecanico dado
	 * @param idMecanico identifiacor del mecanico
	 * @return List<Contrato> lista con los contratos de un mecanico.
	 */
	public static List<Contrato> findContratosByMecanico(Long idMecanico){
		return Jpa.getManager()
				.createNamedQuery("Contrato.findByMecanico",Contrato.class)
				.setParameter(1, idMecanico)
				.getResultList();
	}

}
