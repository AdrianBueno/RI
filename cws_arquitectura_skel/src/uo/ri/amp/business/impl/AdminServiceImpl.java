package uo.ri.amp.business.impl;

import java.util.Date;
import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.admin.categoriasContrato.AddCategoriaContrato;
import uo.ri.amp.business.impl.admin.categoriasContrato.GetCategoriaContratoById;
import uo.ri.amp.business.impl.admin.contratos.AddContrato;
import uo.ri.amp.business.impl.admin.contratos.DeleteContrato;
import uo.ri.amp.business.impl.admin.contratos.FinalizeContrato;
import uo.ri.amp.business.impl.admin.contratos.GetContrato;
import uo.ri.amp.business.impl.admin.contratos.ListContratos;
import uo.ri.amp.business.impl.admin.contratos.ListContratosByMecanico;
import uo.ri.amp.business.impl.admin.contratos.UpdateContrato;
import uo.ri.amp.business.impl.admin.mecanicos.AddMecanico;
import uo.ri.amp.business.impl.admin.mecanicos.DeleteMecanico;
import uo.ri.amp.business.impl.admin.mecanicos.GetMecanico;
import uo.ri.amp.business.impl.admin.mecanicos.GetTotalBrutoMecanico;
import uo.ri.amp.business.impl.admin.mecanicos.ListMecanicosByTipoContrato;
import uo.ri.amp.business.impl.admin.mecanicos.UpdateMecanico;
import uo.ri.amp.business.impl.admin.nominas.AddNomina;
import uo.ri.amp.business.impl.admin.nominas.DeleteLastNomina;
import uo.ri.amp.business.impl.admin.nominas.DeleteNomina;
import uo.ri.amp.business.impl.admin.nominas.GenerateNominas;
import uo.ri.amp.business.impl.admin.nominas.GetNomina;
import uo.ri.amp.business.impl.admin.nominas.GetNominaByDate;
import uo.ri.amp.business.impl.admin.nominas.ListNominasByMecanico;
import uo.ri.amp.business.impl.admin.tiposContrato.AddTipoContrato;
import uo.ri.amp.business.impl.admin.tiposContrato.DeleteTipoContrato;
import uo.ri.amp.business.impl.admin.tiposContrato.GetAcumuladoTipoContrato;
import uo.ri.amp.business.impl.admin.tiposContrato.GetTipoContrato;
import uo.ri.amp.business.impl.admin.tiposContrato.UpdateTipoContrato;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.common.model.TipoContrato;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoContratoFinder;
/**
 * @author Adrián García Bueno UO232346
 *En esta calse implemento la interfaz AdminService
 *No voy a añadir comentarios de javadoc aquí pues ya están en la interfaz.
 */
public class AdminServiceImpl implements AdminService {	
	@Override
	public void addMechanic(Mecanico mecanico)
	throws BusinessException {
		CommandExecutor.execute(new AddMecanico(mecanico));
	}

	@Override
	public void updateMechanic(Long id,String nombre, String apellidos)
	throws BusinessException {
		CommandExecutor.execute(new UpdateMecanico(id,nombre,apellidos));
	}

	@Override
	public void deleteMechanic(Long idMecanico)
	throws BusinessException {
		CommandExecutor.execute(new DeleteMecanico(idMecanico));
		
	}

	@Override
	public Mecanico getMecanicoById(Long id) 
	throws BusinessException {
		return (Mecanico)
		CommandExecutor.execute(new GetMecanico(id));
		
	}
	@Override
	public double getMecanicoTotalBrutoById(Long idMecanico)
	throws BusinessException{
		return (double)
				CommandExecutor.execute(new GetTotalBrutoMecanico(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> ListMecanicos()
	throws BusinessException {
		return (List<Mecanico>)
		CommandExecutor.execute(new Command(){
			@Override
			public Object execute() throws BusinessException {
				return MecanicoFinder.findMecanicos();
			}			
		});
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> ListAllMecanicos()
	throws BusinessException {
		return (List<Mecanico>)
		CommandExecutor.execute(new Command(){
			@Override
			public Object execute() throws BusinessException {
				return MecanicoFinder.findMecanicosAll();
			}			
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> ListMecanicosByTipoContrato(Long idTipoContrato)
	throws BusinessException {
		return (List<Mecanico>)CommandExecutor
				.execute(new ListMecanicosByTipoContrato(idTipoContrato));
	}
	
	//CONTRATOS
	@Override
	public void addContrato(Contrato contrato, Long idMecanico, Long idTipo, 
	Long idCategoria)
	throws BusinessException {
		CommandExecutor
		.execute(new AddContrato(contrato,idMecanico,idTipo,idCategoria));
	}

	@Override
	public void updateContrato(Long idContrato,
	Long idCategoria, Long idTipo, Double salario)
	throws BusinessException{
		CommandExecutor
		.execute(new UpdateContrato(idContrato, idCategoria, idTipo,salario));
		
	}

	@Override
	public void deleteContrato(Long idContrato)
	throws BusinessException {
		CommandExecutor.execute(new DeleteContrato(idContrato));
		
	}

	@Override
	public Contrato finaliceContrato(Long idContrato)
	throws BusinessException {
		return(Contrato)
				CommandExecutor.execute(new FinalizeContrato(idContrato));
		
	}

	@Override
	public Contrato getContratoById(Long idContrato) 
	throws BusinessException {
		return (Contrato) CommandExecutor.execute(new GetContrato(idContrato));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> listContratos()
	throws BusinessException {
		return (List<Contrato>) CommandExecutor.execute(new ListContratos());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> listContratosByMecanico(Long idMecanico)
			throws BusinessException {
		return (List<Contrato>)
			CommandExecutor.execute(new ListContratosByMecanico(idMecanico));
	}

	@Override
	public void addTipoContrato(TipoContrato tipoContrato)
	throws BusinessException {
		CommandExecutor.execute(new AddTipoContrato(tipoContrato));
		
	}

	@Override
	public void updateTipoContrato(Long id,Integer dias)
	throws BusinessException {
		CommandExecutor.execute(new UpdateTipoContrato(id,dias));
	}

	@Override
	public void deleteTipoContrato(Long idTipo)throws BusinessException {
		CommandExecutor.execute(new DeleteTipoContrato(idTipo));
	}
	
	@Override
	public TipoContrato getTipoContrato(Long idTipo)throws BusinessException {
		return (TipoContrato) 
				CommandExecutor.execute(new GetTipoContrato(idTipo));
	}
	@Override
	public Double getAcumuladoTipoContrato(Long idTipo)
	throws BusinessException {
		return (Double) CommandExecutor
				.execute(new GetAcumuladoTipoContrato(idTipo));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoContrato> listTiposContrato() throws BusinessException {
		return (List<TipoContrato>) CommandExecutor.execute(new Command(){
			@Override
			public Object execute() throws BusinessException {
				return TipoContratoFinder.findTiposContrato();
			}
		});
	}

	@Override
	public void generateNominas()
	throws BusinessException {
		CommandExecutor.execute(new GenerateNominas());
		
	}

	@Override
	public void deleteNomina(Long idNomina)
	throws BusinessException {
		CommandExecutor.execute(new DeleteNomina(idNomina));
	}

	@Override
	public void deleteLastNomina(Long idMecanico)
	throws BusinessException {
		CommandExecutor.execute(new DeleteLastNomina(idMecanico));
	}

	@Override
	public Nomina getNomina(Long idNomina)
	throws BusinessException {
		return (Nomina) CommandExecutor.execute(new GetNomina(idNomina));
	}

	@Override
	public Nomina getNomina(Long idMecanico,Date fecha)
	throws BusinessException{
		return (Nomina)CommandExecutor
				.execute(new GetNominaByDate(idMecanico,fecha));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nomina> listNominasByMecanico(Long idMecanico)
	throws BusinessException {
		return (List<Nomina>) CommandExecutor
				.execute(new ListNominasByMecanico(idMecanico));
	}
	@Override
	public CategoriaContrato getCategoriaContratoById(Long idCategoria)
	throws BusinessException {
		return (CategoriaContrato) CommandExecutor
				.execute(new GetCategoriaContratoById(idCategoria));
	}

	@Override
	public void addCategoriaContrato(CategoriaContrato categoria)
	throws BusinessException {
		CommandExecutor.execute(new AddCategoriaContrato(categoria));	
	}

	@Override
	public void addNomina(Long idContrato, Date fecha) 
	throws BusinessException {
		CommandExecutor.execute(new AddNomina(idContrato, fecha));
		
	}
}
