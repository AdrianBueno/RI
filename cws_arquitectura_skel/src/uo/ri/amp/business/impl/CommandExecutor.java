package uo.ri.amp.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.persistence.util.Jpa;
/**
 * Clase para aplicar el patrón Command.
 * @author Adrián
 *
 */
public class CommandExecutor {
	private CommandExecutor(){}
	public static Object execute(Command command) throws BusinessException{
		EntityManager em = null;
		EntityTransaction trx = null;
		try{
			em = Jpa.createEntityManager();
			trx = em.getTransaction();
			trx.begin();
		}catch(Exception e){
			throw e;
		}
		
		try{
			Object ret = command.execute();
			trx.commit();
			return ret;
		}catch(PersistenceException | BusinessException pex ){
			if(trx.isActive())trx.rollback();
			throw pex;
		}finally{
			if(em.isOpen())em.close();
		}
		
	}

}
