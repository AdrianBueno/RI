package uo.ri.amp.business.impl.admin.mecanicos;

import uo.ri.amp.business.asserts.MecanicosAsserts;
import uo.ri.amp.business.impl.Command;
import uo.ri.amp.common.exceptions.BusinessException;
import uo.ri.amp.common.factories.AssertsFactory;
import uo.ri.amp.common.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;

public class UpdateMecanico implements Command {

	private Mecanico mecanico;
	private MecanicosAsserts asserts = AssertsFactory.getMecanicosAsserts();
	private Long id;
	private String nombre;
	private String apellidos;


	public UpdateMecanico(Long id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Override
	public Object execute() throws BusinessException {
		mecanico = MecanicoFinder.findMecanicoById(id);
		asserts.updateMecanico(mecanico);
		mecanico.setNombre(nombre);
		mecanico.setApellidos(apellidos);
		return null;
	}

}
