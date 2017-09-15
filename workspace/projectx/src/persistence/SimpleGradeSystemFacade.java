package persistence;

import model.*;

public class SimpleGradeSystemFacade{



	public SimpleGradeSystemFacade() {
	}

    public PersistentSimpleGradeSystem getTheSimpleGradeSystem() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeSystemFacade.getNextId();
        SimpleGradeSystem result = new SimpleGradeSystem(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentSimpleGradeSystem)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 213);
    }
    
    public SimpleGradeSystem getSimpleGradeSystem(long SimpleGradeSystemId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

