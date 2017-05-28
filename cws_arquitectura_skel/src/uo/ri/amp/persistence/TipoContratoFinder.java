package uo.ri.amp.persistence;
import java.util.List;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.util.Jpa;
public class TipoContratoFinder {
	private TipoContratoFinder() {}
	/**
	 * Obtiene un tipo de contrato atraves de su identificador
	 * @param idTipoContrato identificador del tipo
	 * @return TipoContrato Objeto tipo de contrato
	 */
	public static TipoContrato findTipoContratoById(Long idTipoContrato){
		return Jpa.getManager().find(TipoContrato.class, idTipoContrato);
	}
	/**Tipo de contrato a traves de su nombre
	 * @param nameTipoContrato nombre del tipo de contrato
	 * @return TipoContrato objeto tipo contrato
	 */
	public static TipoContrato findTipoContratoByName(String nameTipoContrato){
		List<TipoContrato> list =  Jpa.getManager()
				.createNamedQuery("TipoContrato.findByName",TipoContrato.class)
				.setParameter(1,nameTipoContrato)
				.getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**Lista tipos de contraot
	 * @return List<TipoContrato> lista con los tipo de contrato
	 */
	public static List<TipoContrato> findTiposContrato(){
		return (List<TipoContrato>) Jpa.getManager()
				.createNamedQuery("TipoContrato.findAll",TipoContrato.class)
				.getResultList();
	}
}
