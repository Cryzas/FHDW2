package persistence;

import model.*;

public class BFalseFacade{



	public BFalseFacade() {
	}

    public PersistentBFalse getTheBFalse() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theMyBooleanFacade.getNextId();
        BFalse result = new BFalse(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentBFalse)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 282);
    }
    
    public BFalse getBFalse(long BFalseId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

