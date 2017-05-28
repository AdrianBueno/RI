package uo.ri.amp.persistence;

import java.util.Date;
import java.util.List;

import uo.ri.amp.common.model.Averia;
import uo.ri.amp.persistence.util.Jpa;
/**Se encarga de buscar entre las averias
 * @author Adrián
 * @version 2
 */
public class AveriaFinder {
	/**Busca las averias de un mecánico.
	 * @param idMecanico identificador del mecanico
	 * @return List<Averia> lista con las averias que encontró.
	 */
	public static List<Averia> findByMecanico(Long idMecanico){
		return Jpa.getManager()
				.createNamedQuery("",Averia.class)
				.getResultList();
	}
	/**Busca todas las Averias
	 * @return List<Averia> lista con las averias que encontró.
	 */
	public static List<Averia> findAll(){
		return Jpa.getManager()
				.createNamedQuery("Averia.findAll",Averia.class)
				.getResultList();
	}
	/**Busca averias entre 2 fechas.
	 * @param date1 fecha de inicio
	 * @param date2 fecha de fin
	 * @return List<Averi> lista con las averias encontradas
	 */
	public static List<Averia> findByDate(Date date1,Date date2){
		return Jpa.getManager()
				.createNamedQuery("Averia.findByDate",Averia.class)
				.setParameter(1, date1)
				.setParameter(2, date2)
				.getResultList();
	}
	/**Lista las averias con los ids pasados por parametros
	 * @param idsAveria identificadores
	 * @return List<Averia> lista con averias encontradas
	 */
	public static List<Averia> findByIds(List<Long> idsAveria) {
		return Jpa.getManager()
				.createNamedQuery("Averia.findByIds",Averia.class)
				.setParameter(1, idsAveria)
				.getResultList();
	}
}
