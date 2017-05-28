package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.util.Jpa;
/**
 * @author Adrián Garcia bueno
 * Esta clase se encarga de acceder a los mecanicos del modelo de dominio
 */
public class MecanicoFinder {
	private MecanicoFinder(){}
	/**Obtiene un mecanico a traves de su identificador
	 * @param idMecanico identificador
	 * @return Mecanico objeto mecanico
	 */
	public static Mecanico findMecanicoById(Long idMecanico){
		return Jpa.getManager().find(Mecanico.class, idMecanico);
	}
	/**Obtiene un mecanico a través del dni.
	 * @param dniMecanico dni del mecanico
	 * @return Mecanico objeto mecanico.
	 */
	public static Mecanico findMecanicoByDni(String dniMecanico){
		 List<Mecanico> list =  Jpa.getManager()
			 .createNamedQuery("Mecanico.findByDni",Mecanico.class)
			 .setParameter(1, dniMecanico)
			 .getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**Devuelve todos los mecanicos con contrato ACTIVO
	 * @return List<Mecanico> lista con mecanicos.
	 */
	public static List<Mecanico> findMecanicos(){
		return Jpa.getManager()
			.createNamedQuery("Mecanico.findAllWitContrato",Mecanico.class)
			.getResultList();
	}
	/**Devuelve todos los mecanicos
	 * @return List<Mecanico> lista con mecanicos.
	 */
	public static List<Mecanico> findMecanicosAll(){
		return Jpa.getManager()
			.createNamedQuery("Mecanico.findAll",Mecanico.class)
			.getResultList();
	}
	/**
	 * Devuelve todos los mecanicos con este Tipocontrato
	 * @param id identificador
	 * @return List<Mecanico> lista con mecanicos
	 */
	public static List<Mecanico> findMecanicosByTipoContrato(Long id){
		return Jpa.getManager()
			.createNamedQuery("Mecanico.findByTipoContrato",Mecanico.class)
			.setParameter(1, id)
			.getResultList();
	}
	/**
	 * Devuelve todos los mecanicos con esta categoria contrato
	 * @param id identificador
	 * @return List<Mecanico> lista con mecanicos
	 */
	public static List<Mecanico> findMecanicosByCategoriaContrato(Long id){
		return Jpa.getManager()
			.createNamedQuery("Mecanico.findByCategoriaContrato",Mecanico.class)
			.setParameter(1, id)
			.getResultList();
	}
}
