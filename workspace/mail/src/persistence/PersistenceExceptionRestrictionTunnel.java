package persistence;

import model.RestrictionException;

@SuppressWarnings("serial")
public class PersistenceExceptionRestrictionTunnel extends PersistenceException {

	public RestrictionException restrictionException;

	public PersistenceExceptionRestrictionTunnel(RestrictionException restrictionException) {
		super(restrictionException.getMessage(), 0);
		this.restrictionException = restrictionException;
	}

}
