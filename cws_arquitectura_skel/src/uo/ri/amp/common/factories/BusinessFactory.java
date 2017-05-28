package uo.ri.amp.common.factories;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.CashService;
import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.MechanicService;
import uo.ri.amp.business.impl.AdminServiceImpl;

/**
 * 
 * @author Adri�n Garc�a Bueno UO232346
 * @version 1
 * Esta clase se encarga de desacoplar una capa superior de la capa de negocio proporcionandole 
 * una clase implementaci�n de una interfaz.
 */
public class BusinessFactory {
	public static AdminService getAdminService(){
		return new AdminServiceImpl();
	}
	public static CashService getCashService(){
		return null;
	}
	public static ForemanService getForemanService(){
		return null;
	}
	public static MechanicService getMechanicService(){
		return null;
	}
}
