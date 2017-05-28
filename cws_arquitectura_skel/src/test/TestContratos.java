package test;


import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
 * @version 2
 * Esta clase se encarga de hacer pruebas sobre el manejo de contratos
 * 
 */
public class TestContratos {
	AdminService services = BusinessFactory.getAdminService();
	private void loadData1() throws BusinessException{
		for(int i = 1; i <= 20; i++){
			services.addMechanic(
					new Mecanico("DNI_"+i,"NOMBRE_"+i,"APELLIDO_"+i));
			services.addTipoContrato(new TipoContrato("TIPO_"+i,i*3));
			services.addCategoriaContrato(
					new CategoriaContrato("CAT_"+i,i*4.0,i*4L));
		}
	}
	@Test
	public void testManageContratos() throws BusinessException {
		loadData1();
		for(int i = 1; i <=20; i++){
			Contrato contrato = new Contrato(1000.0*i,DateUtil.today());
			services.addContrato(contrato, (long)i, (long)i, 1L);
			Assert.assertEquals(contrato, services.getContratoById((long)i));
		}
		System.out.println("Añadir Contratos OK");
		List<Contrato> contratos = services.listContratos();
		Assert.assertEquals(20, contratos.size());
	
		
	}
	@Before
	public void setUp() throws Exception {
		Runtime aplicacion = Runtime.getRuntime(); 
        try{
        	aplicacion
        	.exec("cmd.exe /K cd data & start reset.bat & exit").waitFor();
        	aplicacion
        	.exec("cmd.exe /K cd data & start startup.bat");
        	
        }catch(Exception e){
        	System.out.println(e);
        }
	}
	@After
	public void tearDown() throws Exception {
		Runtime aplicacion = Runtime.getRuntime(); 
        try{
        	aplicacion
        	.exec("cmd.exe /K cd data & start reset.bat & exit").waitFor();
        }catch(Exception e){
        	System.out.println(e);
        }
	}

}
