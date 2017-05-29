package persistence;

import model.CycleException;

@SuppressWarnings("serial")
public class PersistenceExceptionCycleTunnel extends PersistenceException {

	public CycleException cycleException;

	public PersistenceExceptionCycleTunnel(CycleException cycleException) {
		super(cycleException.getMessage(), 0);
		this.cycleException = cycleException;
	}

}
