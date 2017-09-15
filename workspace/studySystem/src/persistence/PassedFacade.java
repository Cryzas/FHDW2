package persistence;

import model.*;

public class PassedFacade{



	public PassedFacade() {
	}

    public PersistentPassed getThePassed() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        Passed result = new Passed(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentPassed)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 214);
    }
    
    public Passed getPassed(long PassedId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

