package persistence;

import model.*;

public class NotPassedFacade{



	public NotPassedFacade() {
	}

    public PersistentNotPassed getTheNotPassed() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeFacade.getNextId();
        NotPassed result = new NotPassed(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentNotPassed)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 219);
    }
    
    public NotPassed getNotPassed(long NotPassedId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

