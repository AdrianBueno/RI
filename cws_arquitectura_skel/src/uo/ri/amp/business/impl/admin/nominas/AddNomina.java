package uo.ri.amp.business.impl.admin.nominas;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.model.Contrato;
import uo.ri.amp.common.model.Nomina;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AddNomina implements Command {

	private Long idContrato;
	private Date fecha;



	public AddNomina(Long idContrato, Date fecha) {
		this.idContrato = idContrato;
		this.fecha = fecha;
	}

	@Override
	public Object execute() throws BusinessException {
		Contrato contrato = ContratoFinder.findContratoById(idContrato);
		Nomina nomina = new Nomina(fecha,contrato);
		Jpa.getManager().persist(nomina);
		return null;
	}

}
