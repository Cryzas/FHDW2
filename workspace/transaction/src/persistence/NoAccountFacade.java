package persistence;

import model.*;

public class NoAccountFacade{



	public NoAccountFacade() {
	}

    public PersistentNoAccount getTheNoAccount() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountHandleFacade.getNextId();
        NoAccount result = new NoAccount(null, null, "", common.Fraction.Null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNoAccount)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 140);
    }
    
    public NoAccount getNoAccount(long NoAccountId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

