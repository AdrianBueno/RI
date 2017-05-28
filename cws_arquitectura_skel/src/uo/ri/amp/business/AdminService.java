package uo.ri.amp.business;

import java.util.Date;
import java.util.List;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;

public interface AdminService {
	//Mecanicos
	/** Añade un nuevo mecánico al sistema.
	 * @param mecanico objeto no nulo.
	 * @throws BusinessException Si el dni ya existe.
	 */
	void addMechanic(Mecanico mecanico) throws BusinessException;
	/**Actualiza el nombre y/o apellidos de un mecánico dado.
	 * @param id identificador del mecánico
	 * @param nombre Nombre del mecánico
	 * @param apellidos apellidos del mecánico
	 * @throws BusinessException El mecánico debe existir previamente.
	 */
	void updateMechanic(Long id,String nombre, String apellidos) 
	throws BusinessException;
	/** Borra un mecánico dado del sistema
	 * El contrato debe estar en vigor para poder ser modificado.
	 * @param idMecanico el identificador del mecánico a borrar.
	 * @throws BusinessException Si el mecánico no existe, o si el 
	 * mecánico tiene asignado datos
	 * como contratos, nóminas, intervenciones, ect.
	 */
	void deleteMechanic(Long idMecanico) throws BusinessException;
	/** Obtiene un objeto mecánico a través de su identificador
	 * @param id identificador del mecánico-
	 * @return Mecanico objecto con los valores correspondientes 
	 * al mecánico con el identificador proporcionado.
	 * @throws BusinessException en caso de no existir
	 */
	Mecanico getMecanicoById(Long id) throws BusinessException;
	/**
	 * 
	 * @param id identificador
	 * @return importe total
	 * @throws BusinessException en caso de no existir
	 */
	double getMecanicoTotalBrutoById(Long id) throws BusinessException;
	/**Devuelve un conjunto con  los mecánicos que tienen un contrato 
	 * en vigor actualmente.
	 * @return List<Mecanico> un conjunto con los mecánicos.
	 * @throws BusinessException si no existe el mecánico
	 */
	List<Mecanico> ListMecanicos() throws BusinessException;
	/**Devuelve un conjunto con todos los mecánicos registrados en el sistema.
	 * @return List<Mecanico> un conjunto con los mecánicos
	 * @throws BusinessException
	 */
	List<Mecanico> ListAllMecanicos() throws BusinessException;
	/**Devuelve un conjunto con todos los mecánicos que tienen
	 *  un contrato del tipo indicado.
	 * @param idTipoContrato Identificador del tipo de contrato.
	 * @return List<Mecanico> conjunto con los mecánicos que 
	 * cumplen la condición
	 * @throws BusinessException en caso de que no exista
	 */
	List<Mecanico> ListMecanicosByTipoContrato(Long idTipoContrato) 
				   throws BusinessException;
	//Contratos
	
	/**Añade un nuevo contrato al sistema
	 * @param contrato nuevo objeto contrato, no nulo.
	 * @param idCategoriaContrato identificador
	 * @param idTipoContrato identificador
	 * @param idMecanico identificador
	 * @throws BusinessException En caso de que el mecánico no exista,
	 * el tipo no exista, la categoría no exista o la fecha no sea válida.
	 */
	void addContrato(Contrato contrato, Long idMecanico, Long idTipoContrato,
			Long idCategoriaContrato) throws BusinessException;
	/**Actualiza un contrato existente
	 * @param contrato el contrato a actualizar.
	 * @throws BusinessException En caso de que no exista,
	 *  mecanico, tipo, categoría o la fecha no sea válida.
	 */
	void updateContrato(Long idContrato, Long idCategoria,
			Long idTipo, Double salario) throws BusinessException;
	/**Borra del sistema un contrato a través de su identificador,
	 *  este no puede tener datos asociados a el, como nóminas.
	 * @param idContrato el identificador del contrato a borrar.
	 * @throws BusinessException Si el identificador no es correcto o
	 *  si el contrato tiene nóminas asociadas al mismo.
	 */
	void deleteContrato(Long idContrato) throws BusinessException;
	/** Finaliza un contrato determinado por un identificador válido.
	 * El contrato debe estar en vigor para poder ser finalizado.
	 * Una vez finalizado se calculará su liquidación y se le añadirá
	 *  la fecha de esta.
	 * El fin del contrato se situará en el último día del mes en curso.
	 * @param idContrato identificador del contrato.
	 * @throws BusinessException si el identificador no es válido o
	 *  si el contrato no está en vigor.
	 */
	Contrato finaliceContrato(Long idContrato) throws BusinessException;
	/**Devuelve un contrato determinado por su identificador.
	 * @param idContrato el identificador del contrato
	 * @return Contrato el contrato asociado al identificador
	 * @throws BusinessException En caso de no existir.
	 */
	Contrato getContratoById(Long idContrato) throws BusinessException;
	/** Lista todos los contratos del sistema.
	 * @return List<Contrato> un List con cada contrato.
	 * @throws BusinessException si hay algun error
	 */
	List<Contrato> listContratos() throws BusinessException;
	/**Lista todos los contratos de un mecánico.
	 * @param idMecanico el identificador del contrato.
	 * @return List<Contrato> un List con cada contrato.
	 * @throws BusinessException si no existe
	 */
	List<Contrato> listContratosByMecanico(Long idMecanico) 
			throws BusinessException;
	
	//Tipos de contrato.
	/**Añade un nuevo tipo de contrato
	 * @param tipoContrato objeto TipoContrato no nulo y con nombre único.
	 * @throws BusinessException si el nómbre ya existe.
	 */
	void addTipoContrato(TipoContrato tipoContrato) throws BusinessException;
	/**Actualiza un tipo de contrato, solo se puede actualizar 
	 * la propiedad dias de indemnización.
	 * @param id el identificador del tipo de contrato
	 * @param diasIndem los dias de indemnización
	 * @throws BusinessException si el objeto tipoContrato no existe 
	 * en el sistema.
	 */
	void updateTipoContrato(Long id,Integer diasIndem) throws BusinessException;
	/**Elimina un tipo de contrato especificado por un identificador.
	 * @param idTipoContrato identificador del tipo de contrato.
	 * @throws BusinessException En caso de que el tipo de contrato 
	 * no exista en el sistema.
	 */
	void deleteTipoContrato(Long idTipoContrato) throws BusinessException;
	/**
	 * 
	 * @param idTipoContrato identificador del tipo de contrato
	 * @return TipoContrato objeto tipo contrato
	 * @throws BusinessException si no existe
	 */
	TipoContrato getTipoContrato(Long idTipoContrato) throws BusinessException;
	/**Lista los tipode contrato existentes.
	 * @return List<TipoContrato> un conjunto con los datos de 
	 * cada tipo de contrato
	 * @throws BusinessException  si algun error
	 */
	List<TipoContrato> listTiposContrato() throws BusinessException;
	/**Obtiene el total de dinero acumulado de ese tipo de contrato
	 * @param idTipo
	 * @return Double el total acumulado
	 * @throws BusinessException en caso de que no exista el tipo de contrato.
	 */
	Double getAcumuladoTipoContrato(Long idTipo) throws BusinessException;
	//Categorias
	/**Aña de una categoria de contrato al sistema nueva
	 * @param categoria un objeto categoria creado y no nulo
	 * @throws BusinessException definida por la implementación
	 */
	void addCategoriaContrato(CategoriaContrato categoria)
	throws BusinessException;
	/**Devuelve una categoria Contrato por su id
	 * @param idCategoriaContrato identioficador
	 * @return CategoríaContrato objeto categoria
	 * @throws BusinessException si no existe
	 */
	CategoriaContrato getCategoriaContratoById(Long idCategoriaContrato) 
			throws BusinessException;
	
	//Nóminas
	/**Genera las nóminas del mes pasado para todos los trabajadores.
	 * @throws BusinessException en caso de errores.
	 */
	void generateNominas() throws BusinessException;
	/**Añade una nomina al sistema
	 * @param idContrato identificador
	 * @param nomina la nomina a añadir
	 * @throws BusinessException definida por la impl.
	 */
	void addNomina(Long idContrato, Date fecha) throws BusinessException;
	/**Borra una nómina a través de su identificador.
	 * @param idNomina identificador de la nómina 
	 * @throws BusinessException en caso de que no exista.
	 */
	void deleteNomina(Long idNomina) throws BusinessException;
	/**Borra la última nómina de un mecánico.
	 * El mecánico debe existir
	 * El mecánico debe tener un contrato en vigor. (?)
	 * @param idMecanico el identificador del mecánico.
	 * @throws BusinessException En caso de que el mecánico no exita.
	 */
	void deleteLastNomina(Long idMecanico) throws BusinessException;
	/**Obtiene una nómina determinada por su identificador
	 * @param idNomina identificador de la nómina.
	 * @return Nomina objeto Nomina con los datos de esta.
	 * @throws BusinessException si no existe.
	 */
	Nomina getNomina(Long idNomina) throws BusinessException;
	/**Devuelve los datos de una nómina correspondiente a un mecánico 
	 * y cierta fecha.
	 * @param idMecanico e identificador del mecánico.
	 * @param año año de la nómina.
	 * @param mes mes de la nómina
	 * @return Nomina nomina en cuestión
	 * @throws BusinessException en caso de que no exista el identificador.
	 */
	Nomina getNomina(Long idMecanico, Date fecha) throws BusinessException;
	/**Lista todas las nóminas pertenecientes a un mecánico
	 * @param idMecanico identificador del mecánico
	 * @return Nomina objeto Nomina con los datos de este.
	 * @throws BusinessException en caso de que no exista el identificador
	 */
	List<Nomina> listNominasByMecanico(Long idMecanico) 
			throws BusinessException;
	
}
