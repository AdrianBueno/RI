package uo.ri.amp.business.impl;

import uo.ri.amp.common.exceptions.BusinessException;

public interface Command {
	public Object execute() throws BusinessException;
}
