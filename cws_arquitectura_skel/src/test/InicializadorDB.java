package test;

import java.util.Calendar;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.model.CategoriaContrato;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.common.model.TipoContrato;
import alb.util.date.DateUtil;
/**
 * @author Adrián
 * @version 4 (27/12/2014)
 * Esta clase se encarga de inicializar parte de la base de datos
 * En concreto
 * genera 7 mecánicos varios tipos y categoria de contrato
 * genera 1 contrato para cada mecánico desde antes de 2012
 * y genera las nominas correspondientes a ese contrato hasta el día de hoy.
 * 
 */
public class InicializadorDB {
	private AdminService service = BusinessFactory.getAdminService();
	public static void main(String[] args) {
		try {
			new InicializadorDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public InicializadorDB() throws Exception {
		setUp();
		loadMecanicos();
		loadCategorias();
		loadTipos();
		loadContratos();
		finalizeContrato();
	}
	public void loadMecanicos() throws BusinessException{//7
		service.addMechanic(
				new Mecanico("62141521J","Manolo","Garcia Gonzalez"));
		service.addMechanic(
				new Mecanico("12421532H","Benigno","Plaza Garcia"));
		service.addMechanic(
				new Mecanico("45235352I","Jose Angel","Gonzalez Plaza"));
		service.addMechanic(
				new Mecanico("45123121C","Roberto","Garcia Plaza"));
		service.addMechanic(
				new Mecanico("39242342T","Gillermo","Alvarez Bueno"));
		service.addMechanic(
				new Mecanico("42342342P","Alberto","Bueno Castro"));
		service.addMechanic(
				new Mecanico("82170123R","Luis","Fernandez Bueno"));
	}
	public void loadTipos() throws BusinessException{//5
		service.addTipoContrato(
				new TipoContrato("INDEFINIDO",45));
		service.addTipoContrato(
				new TipoContrato("TEMPORAL",10));
		service.addTipoContrato(
				new TipoContrato("FORMACION",5));
		service.addTipoContrato(
				new TipoContrato("OBRA",15));
		service.addTipoContrato(
				new TipoContrato("ESPECIALISTA",30));
	}
	public void loadCategorias() throws BusinessException{//6
		service.addCategoriaContrato(
				new CategoriaContrato("PEON",10.0,0.05));
		service.addCategoriaContrato(
				new CategoriaContrato("PEON TERRIBLE",15.0,0.10));
		service.addCategoriaContrato(
				new CategoriaContrato("SUBOFICIAL",20.0,0.12));
		service.addCategoriaContrato(
				new CategoriaContrato("SUBOFICIAL TERRIBLE",25.0,0.12));
		service.addCategoriaContrato(
				new CategoriaContrato("OFICIAL",50.0,0.20));
		service.addCategoriaContrato(
				new CategoriaContrato("OFICIAL TERRIBLE",80.0,0.25));
	}
	public void loadContratos() throws BusinessException{
		service.addContrato(
				new Contrato(10000.0,
						DateUtil.fromString("1/5/2012")), 1L, 3L, 3L);
		loadNominas(service.getContratoById(1L));
		service.addContrato(
				new Contrato(12000.0,
						DateUtil.fromString("1/5/2010")), 2L, 1L, 4L);
		loadNominas(service.getContratoById(2L));
		service.addContrato(
				new Contrato(17000.0,
						DateUtil.fromString("1/5/2011")), 3L, 1L, 3L);
		loadNominas(service.getContratoById(3L));
		service.addContrato(
				new Contrato(21000.0,
						DateUtil.fromString("1/5/2012")), 4L, 5L, 5L);
		loadNominas(service.getContratoById(4L));
		service.addContrato(
				new Contrato(25000.0,
						DateUtil.fromString("1/5/2012")), 5L, 4L, 2L);
		loadNominas(service.getContratoById(5L));
	}
	public void loadNominas(Contrato contrato) throws BusinessException{
		Calendar c = Calendar.getInstance();
		c.setTime(contrato.getFechaInicio());
		c.set(Calendar.DAY_OF_MONTH, 1);
		int dif = DateUtil
				.getMonthsBetween(c.getTime(), DateUtil.today());
		for(int i = 0; i < dif; i++){
			service.addNomina(contrato.getId(), c.getTime());
			c.add(Calendar.MONTH, 1);
		}
	}
	public void finalizeContrato() throws BusinessException{
		service.finaliceContrato(2L);
		service.finaliceContrato(3L);
	}
	
	public void setUp() throws Exception {
		Runtime aplicacion = Runtime.getRuntime(); 
        try{
        	aplicacion.exec("cmd.exe /K cd data & start reset.bat & exit")
        	.waitFor();
        	aplicacion.exec("cmd.exe /K cd data & start startup.bat");
        	
        }catch(Exception e){
        	System.out.println(e);
        }
	}

}
