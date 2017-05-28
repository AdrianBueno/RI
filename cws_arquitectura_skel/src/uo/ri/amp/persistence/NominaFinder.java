package uo.ri.amp.persistence;

import java.util.Date;
import java.util.List;

import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.util.Jpa;
/**
 * Se encarga de acceder a las nominas del modelo de dominio
 * @author Adrián
 *
 */
public class NominaFinder {
	private NominaFinder(){}
	/**Obtiene una nomina a traves de su id
	 * @param id identificador
	 * @return Nomina objeto nomina
	 */
	public static Nomina findNominaById(Long id){
		return Jpa.getManager().find(Nomina.class, id);
	}
	/**Obtiene una nomina a traves de un id de mecanico y una fecha
	 * @param id identificador
	 * @param Date fecha
	 * @return Nomina objeto nomina
	 */
	public static Nomina findNominaByMecanicoAndDate(Long idMec,Date fecha){
		List<Nomina> list =  Jpa.getManager()
				.createNamedQuery("Nomina.findByMecanicoAndDate",Nomina.class)
				.setParameter(1, idMec)
				.setParameter(2, fecha)
				.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**
	 * Obtiene la última nómina de un contrato.
	 * @param idContrato identifacor del contrato
	 * @return Nomina objeto nomina
	 */
	public static Nomina findLastNominaByIdContrato(Long idContrato){
		List<Nomina> list =  Jpa.getManager()
				.createNamedQuery("Nomina.findByContratoLast",Nomina.class)
				.setParameter(1, idContrato)
				.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**Obtiene las nominas por un Mecanico especificado
	 * @param idMecanico identificador del mecanico
	 * @return List<Nomina> lista con las nominas
	 */
	public static List<Nomina> findNominasByMecanico(Long idMecanico){
		return Jpa.getManager()
				.createNamedQuery("Nomina.findByContratoLast",Nomina.class)
				.setParameter(1, idMecanico)
				.getResultList();
	}
	/**Obtiene las nominas por un Mecanico especificado
	 * @param idContrato identificador del contrato
	 * @return List<Nomina> lista con las nominas
	 */
	public static List<Nomina> findNominasByContrato(Long idContrato){
		return Jpa.getManager()
				.createNamedQuery("Nomina.findByContrato",Nomina.class)
				.setParameter(1, idContrato)
				.getResultList();
	}
	/**Obtiene  todas las nominas
	 * @return List<Nomina> lista con las nominas
	 */
	public static List<Nomina> findNominasAll() {
		return Jpa.getManager()
				.createNamedQuery("Nomina.findAll",Nomina.class)
				.getResultList();
	}
}
