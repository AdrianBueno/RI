package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.BusinessFactory;
import uo.ri.amp.common.model.TipoContrato;

public class TestTiposContrato {
	private AdminService service;
	@Before
	public void setUp() throws Exception {
		service = BusinessFactory.getAdminService();
		Runtime aplicacion = Runtime.getRuntime(); 
        try{
        	aplicacion.exec("cmd.exe /K cd data & start reset.bat & exit")
        	.waitFor();
        	aplicacion.exec("cmd.exe /K cd data & start startup.bat");
        	
        }catch(Exception e){
        	System.out.println(e);}
	}

	@After
	public void tearDown() throws Exception {
		
	}
	/**Este test prueba si el añadido, actualizado, listado y borrado
	 * funcionan adecuadamente.
	 * @throws BusinessException propio de la capa de servicio usada.
	 */
	@Test
	public void testManageTipoContrato() throws BusinessException {
		String name = "TipoContrato_";
		for(int i = 1; i <= 20; i++){
			TipoContrato tipo = new TipoContrato(name+i,i);
			service.addTipoContrato(tipo);
			Assert.assertEquals(tipo, service.getTipoContrato((long)i));
		}
		System.out.println("Añadir TiposContrato OK");
		for(int i = 1; i <= 20; i++){
			TipoContrato refTipo = service.getTipoContrato((long)i);
			service.updateTipoContrato((long)i, i+2);
			TipoContrato tipo = service.getTipoContrato((long)i);
			Assert.assertEquals(refTipo, tipo);
		}
		System.out.println("Actualizar TiposContrato OK");
		Assert.assertEquals(20,service.listTiposContrato().size());
		System.out.println("Listar TiposContrato OK");
		for(int i = 1; i <= 20; i++){
			service.deleteTipoContrato((long)i);
			Assert.assertEquals(null,service.getTipoContrato((long)i));
		}
		System.out.println("Borrar TiposContrato OK");
	}
}
