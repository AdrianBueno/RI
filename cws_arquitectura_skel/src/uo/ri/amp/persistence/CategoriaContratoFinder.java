package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.persistence.util.Jpa;
/**
 * 
 * @author Adrián
 *Esta clase se encarga de acceder a las categorias del modelo de dominio
 */
public class CategoriaContratoFinder {
	private CategoriaContratoFinder(){}
	/**Devuelve una categoria de contrato
	 * @param idCategoriaContrato el identificador de la categoria
	 * @return CategoriaContrato un objeto con el identificador especificado
	 */
	public static CategoriaContrato 
	findCategoriaContratoById(Long idCategoriaContrato){
		return Jpa.getManager()
				.find(CategoriaContrato.class, idCategoriaContrato);
	}
	/**Devuelve una categoria de contrato a partir de un nombre
	 * @param nameCategoriaContrato el nombre de la categoria
	 * @return CategoriaContrato un objeto con el nombre especificado
	 */
	public static CategoriaContrato
	findCategoriaContratoByName(String nameCategoriaContrato){
		List<CategoriaContrato> list = Jpa.getManager()
		.createNamedQuery("CategoriaContrato.findByName"
				,CategoriaContrato.class)
		.setParameter(1, nameCategoriaContrato).getResultList();
		return list.size() > 0 ? list.get(0) : null;
	}
	/**
	 * Devuelve todas las categorias de contrato
	 * @return lista  una lista con las categorias encontradas.
	 */
	public static List<CategoriaContrato> findCategoriasContrato(){
		return (List<CategoriaContrato>) Jpa.getManager()
		.createNamedQuery("CategoriaContrato.findAll",CategoriaContrato.class)
		.getResultList();
	}

}
