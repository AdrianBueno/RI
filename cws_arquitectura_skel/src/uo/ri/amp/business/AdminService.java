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
	/** A�ade un nuevo mec�nico al sistema.
	 * @param mecanico objeto no nulo.
	 * @throws BusinessException Si el dni ya existe.
	 */
	void addMechanic(Mecanico mecanico) throws BusinessException;
	/**Actualiza el nombre y/o apellidos de un mec�nico dado.
	 * @param id identificador del mec�nico
	 * @param nombre Nombre del mec�nico
	 * @param apellidos apellidos del mec�nico
	 * @throws BusinessException El mec�nico debe existir previamente.
	 */
	void updateMechanic(Long id,String nombre, String apellidos) 
	throws BusinessException;
	/** Borra un mec�nico dado del sistema
	 * El contrato debe estar en vigor para poder ser modificado.
	 * @param idMecanico el identificador del mec�nico a borrar.
	 * @throws BusinessException Si el mec�nico no existe, o si el 
	 * mec�nico tiene asignado datos
	 * como contratos, n�minas, intervenciones, ect.
	 */
	void deleteMechanic(Long idMecanico) throws BusinessException;
	/** Obtiene un objeto mec�nico a trav�s de su identificador
	 * @param id identificador del mec�nico-
	 * @return Mecanico objecto con los valores correspondientes 
	 * al mec�nico con el identificador proporcionado.
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
	/**Devuelve un conjunto con  los mec�nicos que tienen un contrato 
	 * en vigor actualmente.
	 * @return List<Mecanico> un conjunto con los mec�nicos.
	 * @throws BusinessException si no existe el mec�nico
	 */
	List<Mecanico> ListMecanicos() throws BusinessException;
	/**Devuelve un conjunto con todos los mec�nicos registrados en el sistema.
	 * @return List<Mecanico> un conjunto con los mec�nicos
	 * @throws BusinessException
	 */
	List<Mecanico> ListAllMecanicos() throws BusinessException;
	/**Devuelve un conjunto con todos los mec�nicos que tienen
	 *  un contrato del tipo indicado.
	 * @param idTipoContrato Identificador del tipo de contrato.
	 * @return List<Mecanico> conjunto con los mec�nicos que 
	 * cumplen la condici�n
	 * @throws BusinessException en caso de que no exista
	 */
	List<Mecanico> ListMecanicosByTipoContrato(Long idTipoContrato) 
				   throws BusinessException;
	//Contratos
	
	/**A�ade un nuevo contrato al sistema
	 * @param contrato nuevo objeto contrato, no nulo.
	 * @param idCategoriaContrato identificador
	 * @param idTipoContrato identificador
	 * @param idMecanico identificador
	 * @throws BusinessException En caso de que el mec�nico no exista,
	 * el tipo no exista, la categor�a no exista o la fecha no sea v�lida.
	 */
	void addContrato(Contrato contrato, Long idMecanico, Long idTipoContrato,
			Long idCategoriaContrato) throws BusinessException;
	/**Actualiza un contrato existente
	 * @param contrato el contrato a actualizar.
	 * @throws BusinessException En caso de que no exista,
	 *  mecanico, tipo, categor�a o la fecha no sea v�lida.
	 */
	void updateContrato(Long idContrato, Long idCategoria,
			Long idTipo, Double salario) throws BusinessException;
	/**Borra del sistema un contrato a trav�s de su identificador,
	 *  este no puede tener datos asociados a el, como n�minas.
	 * @param idContrato el identificador del contrato a borrar.
	 * @throws BusinessException Si el identificador no es correcto o
	 *  si el contrato tiene n�minas asociadas al mismo.
	 */
	void deleteContrato(Long idContrato) throws BusinessException;
	/** Finaliza un contrato determinado por un identificador v�lido.
	 * El contrato debe estar en vigor para poder ser finalizado.
	 * Una vez finalizado se calcular� su liquidaci�n y se le a�adir�
	 *  la fecha de esta.
	 * El fin del contrato se situar� en el �ltimo d�a del mes en curso.
	 * @param idContrato identificador del contrato.
	 * @throws BusinessException si el identificador no es v�lido o
	 *  si el contrato no est� en vigor.
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
	/**Lista todos los contratos de un mec�nico.
	 * @param idMecanico el identificador del contrato.
	 * @return List<Contrato> un List con cada contrato.
	 * @throws BusinessException si no existe
	 */
	List<Contrato> listContratosByMecanico(Long idMecanico) 
			throws BusinessException;
	
	//Tipos de contrato.
	/**A�ade un nuevo tipo de contrato
	 * @param tipoContrato objeto TipoContrato no nulo y con nombre �nico.
	 * @throws BusinessException si el n�mbre ya existe.
	 */
	void addTipoContrato(TipoContrato tipoContrato) throws BusinessException;
	/**Actualiza un tipo de contrato, solo se puede actualizar 
	 * la propiedad dias de indemnizaci�n.
	 * @param id el identificador del tipo de contrato
	 * @param diasIndem los dias de indemnizaci�n
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
	/**A�a de una categoria de contrato al sistema nueva
	 * @param categoria un objeto categoria creado y no nulo
	 * @throws BusinessException definida por la implementaci�n
	 */
	void addCategoriaContrato(CategoriaContrato categoria)
	throws BusinessException;
	/**Devuelve una categoria Contrato por su id
	 * @param idCategoriaContrato identioficador
	 * @return Categor�aContrato objeto categoria
	 * @throws BusinessException si no existe
	 */
	CategoriaContrato getCategoriaContratoById(Long idCategoriaContrato) 
			throws BusinessException;
	
	//N�minas
	/**Genera las n�minas del mes pasado para todos los trabajadores.
	 * @throws BusinessException en caso de errores.
	 */
	void generateNominas() throws BusinessException;
	/**A�ade una nomina al sistema
	 * @param idContrato identificador
	 * @param nomina la nomina a a�adir
	 * @throws BusinessException definida por la impl.
	 */
	void addNomina(Long idContrato, Date fecha) throws BusinessException;
	/**Borra una n�mina a trav�s de su identificador.
	 * @param idNomina identificador de la n�mina 
	 * @throws BusinessException en caso de que no exista.
	 */
	void deleteNomina(Long idNomina) throws BusinessException;
	/**Borra la �ltima n�mina de un mec�nico.
	 * El mec�nico debe existir
	 * El mec�nico debe tener un contrato en vigor. (?)
	 * @param idMecanico el identificador del mec�nico.
	 * @throws BusinessException En caso de que el mec�nico no exita.
	 */
	void deleteLastNomina(Long idMecanico) throws BusinessException;
	/**Obtiene una n�mina determinada por su identificador
	 * @param idNomina identificador de la n�mina.
	 * @return Nomina objeto Nomina con los datos de esta.
	 * @throws BusinessException si no existe.
	 */
	Nomina getNomina(Long idNomina) throws BusinessException;
	/**Devuelve los datos de una n�mina correspondiente a un mec�nico 
	 * y cierta fecha.
	 * @param idMecanico e identificador del mec�nico.
	 * @param a�o a�o de la n�mina.
	 * @param mes mes de la n�mina
	 * @return Nomina nomina en cuesti�n
	 * @throws BusinessException en caso de que no exista el identificador.
	 */
	Nomina getNomina(Long idMecanico, Date fecha) throws BusinessException;
	/**Lista todas las n�minas pertenecientes a un mec�nico
	 * @param idMecanico identificador del mec�nico
	 * @return Nomina objeto Nomina con los datos de este.
	 * @throws BusinessException en caso de que no exista el identificador
	 */
	List<Nomina> listNominasByMecanico(Long idMecanico) 
			throws BusinessException;
	
}
