package persistence;

import model.*;

public class ThirdGradeSystemFacade{



	public ThirdGradeSystemFacade() {
	}

    public PersistentThirdGradeSystem getTheThirdGradeSystem() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theGradeSystemFacade.getNextId();
        ThirdGradeSystem result = new ThirdGradeSystem(null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentThirdGradeSystem)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 212);
    }
    
    public ThirdGradeSystem getThirdGradeSystem(long ThirdGradeSystemId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

